/*
 * Created by Adam Ring. 
 */
package Servlets;

import Database.MessagesDB;
import Database.UserDB;
import Objects.Messages;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ikanspelwel
 */
@WebServlet("/DeleteMessage")
public class DeleteMessage extends HttpServlet {

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
         * corresponding user object. Now going to check for a messageID.
         */
        Database.MessagesDB messageDB = new MessagesDB();
        Objects.Messages messages = null;
        Integer msgId = null;
        try {
            // Try and get a number from the listing_id param. 
            msgId = Integer.parseInt(request.getParameter("deleteId"));
        } catch (NumberFormatException e) {
            // Invalid Message ID. They are doing something bad, so just kick em out.
            response.sendRedirect("/DirectSell450/inbox.jsp");
            return;
        }

        try {
            // Try and go and get the listing information. 
            messages = messageDB.GetMessage(msgId);
        } catch (SQLException e) {
            //TODO Report error
            System.out.printf("DB Connection failed: %s\n", e.getMessage());
        }

        if (messages == null) {
            // Again trying to do something bad so just kick em out. 
            response.sendRedirect("/DirectSell450/inbox.jsp");
            return;
        }

        /**
         * If we have reached this point, we now have a valid user, and valid
         * listing, just need to check if they are trying to delete a message
         * that they are allowed to delete. Can only delete from Inbox so
         * message has to have been sent to them.
         */
        if (messages.receiverID != user.getUid()) {
            // Oops, that doesn't compute, just kick em out. 
            response.sendRedirect("/DirectSell450/inbox.jsp");
            return;
        } else {
            /**
             * Now we are good to delete the message, we have passed all of the
             * sanity checks.
             */

            try {
                messageDB.DeleteMessage(messages.messageID);
                // Message deleted! send back to inbox.
                response.sendRedirect("/DirectSell450/inbox.jsp");
                return;
            } catch (Exception e) {
                System.out.printf("Deleting message failed: %s\n", e.getMessage());
                //TODO add error message to display to user. 
                // Failsafe, send them back to inbox. 
                response.sendRedirect("/DirectSell450/inbox.jsp");
            }

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
