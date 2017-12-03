package Servlets;

import Database.UserDB;
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

        /* Instance of printwriter for try/catch exception*/
        PrintWriter out = response.getWriter();

        /* Instance of our userDB and user class */
        Database.UserDB userCheck = new UserDB();
        Objects.User user = null;

        /* Getting a user object (or null) back from the CheckLogIn method */
        try {
            user = userCheck.CheckLogIn(request.getParameter("user"), request.getParameter("pwd"));
        } catch (SQLException e) {
            // Display generic error message on failure..
            out.println("Error, see server log for details.");
            // Log more info to the Log file.
            System.out.printf("Error: %s\n", e.getMessage());
        }

        /* If user exists in the database, create session */
        if (user != null) {

            //Create the session
            HttpSession session = request.getSession();
            session.setAttribute("UID", user.getUid());

            //setting session to expiry in 1 year
            session.setMaxInactiveInterval(31536000);

            //Get the encoded URL string
            String encodedURL = response.encodeRedirectURL("/DirectSell450/profile.html");
            response.sendRedirect(encodedURL);

        } else { //Alert user to login
            response.sendRedirect("/DirectSell450/login.jsp?e1=true");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {

        return "Login Servlet to authenticate user, establish user session.";
    }// </editor-fold>

}
