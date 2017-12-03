package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kimberly
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        //invalidate the session if exists
        //https://stackoverflow.com/questions/24677949/why-session-is-not-null-after-session-invalidate-in-java
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        //no encoding because we have invalidated the session
        response.sendRedirect("/DirectSell450/login.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        //There is no method to remove the cookie but we can set the 
        //maximum age to 0 so that it will be deleted from client browser immediately.

        return "Logout Servlet to end session when user logs out.";
    }// </editor-fold>

}
