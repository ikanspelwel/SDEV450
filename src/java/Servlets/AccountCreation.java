/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.UserDB;
import Objects.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author michaelangel
 */
@WebServlet("/AccountCreation")
public class AccountCreation extends HttpServlet {

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
        String userName = request.getParameter("user");
        String email = request.getParameter("email");
	String emailConfirm = request.getParameter("emailConfirm");
        String pwd = request.getParameter("pwd");
	String pwdConfirm = request.getParameter("pwdConfirm");
        String zip = request.getParameter("zip");
        
	// TODO validate all the front end info
        // verify all the user information because you cannot trust the front end
	/*
        if(userName.length() == 0){
            // not valid
            return;
        }
	*/

        /* Instance of our userDB and user class */
        Database.UserDB userCheck = new UserDB();

        // attempt to add the user to the database
        User user = null;
        try {
            user = userCheck.AddNewUser(userName, email, pwd, zip);
        } catch(IllegalArgumentException ex) {
            // get http session,redirect, and respond with account already exists
	    response.sendRedirect("/DirectSell450/login.jsp?e3=true");
	    return;
        } catch (SQLException e) {
            // report error
	    response.sendRedirect("/DirectSell450/login.jsp?e4=true");
        }
        
        // check if user was added to the database
        if(user != null){
            //Create the session
            HttpSession session = request.getSession();
            session.setAttribute("UID", user.getUid());
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30 * 60);
            //Create the cookie
            Cookie userCookie = new Cookie("login", user.getUid().toString());
            //setting cookie to expiry in 30 mins
            userCookie.setMaxAge(30 * 60);
            response.addCookie(userCookie);
            //Get the encoded URL string
            String encodedURL = response.encodeRedirectURL("/DirectSell450/account.jsp");
            response.sendRedirect(encodedURL);
	} else {
            // TODO deal with error that is not SQLException or IllegalArgumentException
	    response.sendRedirect("/DirectSell450/login.jsp?e5=true");
        }
    }

     /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {

        return "Login Servlet to authenticate user, establish cookie & session.";
    }

}
