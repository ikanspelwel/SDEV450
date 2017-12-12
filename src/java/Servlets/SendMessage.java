/*
 * Created by Adam Ring. 
 */
package Servlets;

import Database.ListingDB;
import Database.MessagesDB;
import Database.UserDB;
import Objects.Messages;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ikanspelwel
 */
public class SendMessage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /* Instance of our userDB and user class */
        Database.UserDB userCheck = new UserDB();
        Objects.User user = null;

        Integer uID = null;
        HttpSession session = request.getSession();
        if (session.getAttribute("UID") == null) {
            response.sendRedirect("/DirectSell450/login.jsp?e2=true");
            return;
        } else {
            uID = (Integer) session.getAttribute("UID");
            try {
                user = userCheck.GetUser(uID);
            } catch (SQLException e) {
                // user will still be null so good to go, but lets log it.
                System.out.printf("Error: %s\n", e.getMessage());
            }
            if (user == null) {
                /**
                 * If user is null, then that user ID wasn't found. Something
                 * very fishy there, as this shouldn't really happen, but just
                 * going to reset the UID session var and kick them out to the
                 * login screen.
                 */
                session.setAttribute("UID", null);
                response.sendRedirect("/DirectSell450/login.jsp?e2=true");
                return;
            }
        }

        /**
         * Now that we have gotten here, we have a valid session and
         * corresponding user object. Now going to check for a valid listing_id.
         */
        Database.ListingDB listingLookup = new ListingDB();
        Integer listing_id = null;
        Objects.Listing listing = null;
        try {
            // Try and get a number from the listing_id param. 
            listing_id = Integer.parseInt(request.getParameter("listing_id"));
        } catch (NumberFormatException e) {
            // Invalid Message ID. They are doing something bad, so just kick em out.
            response.sendRedirect("/DirectSell450/listings.jsp");
            return;
        }

        try {
            // Try and go and get the listing information. 
            listing = listingLookup.getListing(listing_id);
        } catch (SQLException e) {
            //TODO Report error
            System.out.printf("DB Connection failed: %s\n", e.getMessage());
            response.sendRedirect("/DirectSell450/listings.jsp");
            return;
        }

        if (listing == null) {
            // Again trying to do something bad so just kick em out. 
            response.sendRedirect("/DirectSell450/listings.jsp");
            return;
        }

        Integer senderID = listing.getUid();

        // Instance of our MessagesDB object.
        Database.MessagesDB messageDb = new MessagesDB();

        /**
         * If there is a replyID sent, then this is a reply and we need to
         * change the FK_RECEIVER_ID to the proper user.
         */
        if (!request.getParameter("replyId").isEmpty()) {
            Integer messageId;
            Objects.Messages tmpMessage;
            try {
                // Try and get a number from the replyId param. 
                messageId = Integer.parseInt(request.getParameter("replyId"));
            } catch (NumberFormatException e) {
                // Invalid Message ID. They are doing something bad, so just kick em out.
                response.sendRedirect("/DirectSell450/listings.jsp");
                return;
            }

            try {
                // Try and go and get the listing information. 
                tmpMessage = messageDb.GetMessage(messageId);
            } catch (SQLException e) {
                //TODO Report error
                System.out.printf("DB Connection failed: %s\n", e.getMessage());
                response.sendRedirect("/DirectSell450/listings.jsp");
                return;
            }

            /**
             * Overwriting the sender ID to be the sender of the message we are
             * replying to.
             */
            senderID = tmpMessage.senderID;

        }

        /**
         * If we have reached this point, we now have a valid sending user, and
         * valid listing, so we can go ahead and send our email.
         */
        Objects.Messages message = new Messages(null, user.getUid(), senderID, listing.getListingid(), 0, request.getParameter("body"), null, 0);

        try {
            messageDb.newMessage(message);
            response.sendRedirect("/DirectSell450/contactSent.jsp");
            return;
        } catch (Exception e) {
            System.out.printf("Adding new message failed: %s\n", e.getMessage());
            //TODO add error message to display to user. 
        }

        // Okay now we are good to go, we have a valid listing_id!
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SendMessage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SendMessage at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
