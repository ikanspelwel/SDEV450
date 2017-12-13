/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.UserDB;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author michaelangel
 */
@WebServlet("/AccountUpdate")
public class AccountUpdate extends HttpServlet {

    private static final long serialVersionUID = 1L;

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

        // get the information from the front end
        String name = request.getParameter("fullName");
        String email = request.getParameter("email");
        String zip = request.getParameter("zipCode");
        String oldPwd = request.getParameter("oldPwd");
        String newPwd = request.getParameter("newPwd");

        //Create the session
        HttpSession session = request.getSession();
        Integer uID = (Integer) session.getAttribute("UID");
        // TODO use the user info from the cookie to update the records in the db
        /* Instance of our userDB and user class */
        Database.UserDB userUpdateDB = new UserDB();
        try {
            boolean result = userUpdateDB.updateUser(uID, oldPwd, newPwd, name, zip, email);
            //System.out.print(result);
            //Get the encoded URL string
            String encodedURL = response.encodeRedirectURL("/DirectSell450/account.jsp");
            response.sendRedirect(encodedURL);
        } catch (SQLException e) {
            // TODO handle error properly
        } finally {
            userUpdateDB.disconnect();
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {

        return "Account update servlet to update user info using a session.";
    }

}
