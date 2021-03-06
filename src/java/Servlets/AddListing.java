/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.ImageDB;
import Database.ListingDB;
import Objects.Listing;
import Objects.User;
import Database.UserDB;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author ikanspelwel modified to create listing (in addition to Adam R's image
 * saving function) by Adam F
 */
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class AddListing extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        // gets values of text fields
        String title = request.getParameter("inputTitle");
        String description = request.getParameter("inputDesc");
        String category = request.getParameter("inputCat");
        String strPrice = (request.getParameter("inputPrice"));
        Double dblPrice = null;
        int uid = (int) session.getAttribute("UID");
        
      
        
        // redirects if price isn't a digit
        try{
           dblPrice = Double.parseDouble(strPrice); 
        }
        catch (NumberFormatException ex){
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Add Listing</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Error!</h1>");
                out.println("<pre>");
                out.println("Price must be a digit, redirecting to add listing page"
                        + " in 5 seconds..");
                out.println("<a href = addListing.jsp>Try Again Now.</a>");
                out.println("<meta http-equiv=\"refresh\" content=\"5; url=/DirectSell450/addListing.jsp\" />");
                out.println("</pre>");
                out.println("</body>");
                out.println("</html>");
            }
        }
        
        InputStream inputStream = null; // input stream of the upload file

        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("image");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the upload file
            if(filePart.getSize() > 0) {
                inputStream = filePart.getInputStream();
            }
        }

        // fetches input stream of the upload file for the blob column
//            statement.setBlob(3, inputStream);
        Database.ListingDB newListing = new ListingDB();
        int listingID = -1;
        try {
            listingID = newListing.newListing(title, description, category, uid, dblPrice);
            if (inputStream != null) {
                Database.ImageDB newImage = new ImageDB();
                newImage.SaveImage("jpg", listingID, inputStream);
            }
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Listing Added</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Listing added successfully!</h1>");
                out.println("<pre>");
                out.println("Redirecting to Index");
                out.println("<a href = index.jsp>Return to index now.</a>");
                out.println("<meta http-equiv=\"refresh\" content=\"0; url=/DirectSell450/index.jsp\" />");
                out.println("</pre>");
                out.println("</body>");
                out.println("</html>");
            }

        } catch (SQLException ex) {
            Logger.getLogger(AddListing.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            newListing.disconnect();
        }
    }

void inputError(String cause){
    
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
        //processRequest(request, response);
        // Get is not allowed for Image Upload
        // TODO add error handling if get is tried.
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
