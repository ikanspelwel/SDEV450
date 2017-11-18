package Servlets;

import Database.UserDB;
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
 * @author Kimberly, created base code Adam Ring integrated Database Class
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

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

        /* Instance of our userDB and user class */
        Database.UserDB userCheck = new UserDB();
        Objects.User user = null;
        
        /* Getting a user object (or null) back from the CheckLogIn method */
        try {
            user = userCheck.CheckLogIn(request.getParameter("user"), request.getParameter("pwd"));
        } catch (SQLException e) {
            //TODO Report error.
        }

        if (user != null) {
            //Create the session
            HttpSession session = request.getSession();
            session.setAttribute("UID", user.getUid());
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30 * 60);
            //Create the cookie
            Cookie userName = new Cookie("login", user.getUid().toString());
            //setting cookie to expiry in 30 mins
            userName.setMaxAge(30 * 60);
            response.addCookie(userName);
            //Get the encoded URL string
            String encodedURL = response.encodeRedirectURL("LoginSuccess.jsp");
            response.sendRedirect(encodedURL);
        } else {
            //A modal may be nice here to notify user of invalid login
            //This alert needs refinement, but I couldn't easily change            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html><html>");
            out.println("<center><font size=14 color=red>Either user name or password is wrong.</font></center>");
            rd.include(request, response);
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
    }// </editor-fold>

}
