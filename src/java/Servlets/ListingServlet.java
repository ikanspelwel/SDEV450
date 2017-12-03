/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;
import Database.ImageDB;
import Database.ListingDB;
import java.sql.Blob;
import Objects.Images;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kmh5004
 */
@WebServlet("/ListingServlet/*")
public class ListingServlet extends HttpServlet {

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
        /*
        Database.ListingDB listingLookup = new ListingDB();
        Objects.Listing listing = null;
        try {
        listing = listingLookup.inOrder(1,20);
                } catch(SQLException e)  {
                    //TODO Report error
                }
        if (listing != null) {
            String title = listing.getListingTitle();
            String desc = listing.getDescription();
            response.getWriter();
        }
            */
        //Credit for below from Mohamed Saligh https://stackoverflow.com/questions/5243726/how-to-display-an-image-in-jsp
        
        ImageDB imageLookup= new ImageDB();
        try{
        Images image = imageLookup.getImage(Integer.parseInt(request.getParameter("listing_id")));//return blob...
        //From Timothy Groot https://stackoverflow.com/questions/6662432/easiest-way-to-convert-a-blob-into-a-byte-array
        Blob blob = image.getImage();
        int blobLength = (int) blob.length();
        byte[] imgByt = blob.getBytes(1, blobLength);

//release the blob and free up memory. (since JDBC 4.0)
blob.free();
response.setContentType("image/jpg");
response.getOutputStream().write(imgByt);
response.getOutputStream().flush();
response.getOutputStream().close();
        }
        catch (SQLException e) {
            
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
