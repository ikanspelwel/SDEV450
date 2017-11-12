package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SDEV 450 Direct Sell Team
 */
public class Login extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <meta charset=\"utf-8\">\n"
                    + "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                    + "        <title>Direct Sell!</title>\n"
                    + "        \n"
                    + "        <!-- Bootsrap CDN Import -->              \n"
                    + "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n"
                    + "        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"\n"
                    + "                integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\n"
                    + "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\n"
                    + "              integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\"\n"
                    + "              \n"
                    + "        <!-- Custom styles -->\n"
                    + "        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        \n"
                    + "        <!-- Create Navbar that collapses for mobile and expands for larger screens -->\n"
                    + "        <nav id=\"myNavbar\" class=\"navbar navbar-default\" role=\"navigation\">    \n"
                    + "            <div class=\"container\">\n"
                    + "                <div class=\"navbar-header\">\n"
                    + "                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#navbarCollapse\">\n"
                    + "                        <span class=\"sr-only\">Toggle navigation</span>\n"
                    + "                        <span class=\"icon-bar\"></span>\n"
                    + "                        <span class=\"icon-bar\"></span>\n"
                    + "                        <span class=\"icon-bar\"></span>\n"
                    + "                    </button>\n"
                    + "                    <a class=\"navbar-brand\" href=\"index.html\">Direct Sell!</a>\n"
                    + "                </div>\n"
                    + "                \n"
                    + "                <!-- Navigation links and forms -->\n"
                    + "                <div class=\"collapse navbar-collapse\" id=\"navbarCollapse\">\n"
                    + "                    <ul class=\"nav navbar-nav\">\n"
                    + "                        <li><a href=\"index.html\">Home</a></li>\n"
                    + "                        <li><a href=\"listings.html\">Listings</a></li>\n"
                    + "                        <li><a href=\"about.html\">About</a></li>\n"
                    + "                        <li><a href=\"contact.html\">Contact</a></li>\n"
                    + "                        <li><a href=\"profile.html\">Profile</a></li>\n"
                    + "                        <li class=\"dropdown\">\n"
                    + "                            <a data-toggle=\"dropdown\" class=\"dropdown-toggle\" href=\"#\">Messages <b class=\"caret\"></b></a>\n"
                    + "                            <ul class=\"dropdown-menu\">\n"
                    + "                                <li><a href=\"inbox.html\">Inbox</a></li>                        \n"
                    + "                                <li><a href=\"sent.html\">Sent Items</a></li>\n"
                    + "                                <li class=\"divider\"></li>\n"
                    + "                                <li><a href=\"trash.html\">Trash</a></li>\n"
                    + "                            </ul>\n"
                    + "                        </li>\n"
                    + "                        <form class=\"navbar-form navbar-left\">\n"
                    + "                            <div class=\"input-group\">\n"
                    + "                                <input type=\"text\" class=\"form-control\" placeholder=\"Search\">\n"
                    + "                                <span class=\"input-group-btn\">\n"
                    + "                                    <button type=\"button\" class=\"btn btn-default\"><span class=\"glyphicon glyphicon-search\"></span></button>\n"
                    + "                                </span>\n"
                    + "                            </div>\n"
                    + "                        </form>\n"
                    + "                    </ul>\n"
                    + "                    <ul class=\"nav navbar-nav navbar-right\">\n"
                    + "                        <li class=\"active\"><a href=\"login.html\">Login</a></li>\n"
                    + "                    </ul>\n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "        </nav>\n"
                    + "        \n"
                    + "        <!-- Sign in and registration forms -->\n"
                    + "        <div class=\"container\">\n"
                    + "            <div class=\"row\">         \n"
                    + "                <div class=\"col-sm-12 col-md-6\">             \n"
                    + "                    <form class=\"form-horizontal\">\n"
                    + "                        <h2 class=\"signin-heading\">Please sign in</h2>\n"
                    + "                        <label for=\"inputEmail\" class=\"control-label\">Email</label>\n"
                    + "                        <input type=\"email\" class=\"form-control\" id=\"inputEmail\" placeholder=\"Email\" required>\n"
                    + "                        <label for=\"inputPassword\" class=\"control-label\">Password</label>\n"
                    + "                        <input type=\"password\" class=\"form-control\" id=\"inputPassword\" placeholder=\"Password\" required>\n"
                    + "                        <div class=\"checkbox\">\n"
                    + "                            <label><input type=\"checkbox\"> Remember me</label>\n"
                    + "                        </div>\n"
                    + "                        <button href=\"profile.html\" class=\"btn btn-primary\" type=\"submit\" id=\"loginSubmit\">Sign in</button>\n"
                    + "                     </form><br>\n"
                    + "                    <a href=\"#\" id=\"resetPass\">Forgot your password?</a>\n"
                    + "                </div>         \n"
                    + "                <div class=\"col-sm-12 col-md-6\">         \n"
                    + "                    <form class=\"form-horizontal\">\n"
                    + "                        <h2 class=\"register-heading\">Need to make an account?</h2>\n"
                    + "                        <label for=\"fullName\" class=\"control-label\">Full Name</label>\n"
                    + "                        <input type=\"text\" class=\"form-control\" id=\"fullName\" placeholder=\"Full Name\" required>\n"
                    + "                        <label for=\"zippCode\" class=\"control-label\">Zip Code</label>\n"
                    + "                        <input type=\"text\" class=\"form-control\" id=\"zipCode\" placeholder=\"Zip Code\" required>\n"
                    + "                        <label for=\"inputEmail\" class=\"control-label\">Email</label>\n"
                    + "                        <input type=\"email\" class=\"form-control\" id=\"inputEmail\" placeholder=\"Email\" required>\n"
                    + "                        <label for=\"confirmEmail\" class=\"control-label\">Confirm Email</label>\n"
                    + "                        <input type=\"email\" class=\"form-control\" id=\"confirmEmail\" placeholder=\"Confirm Email\" required>\n"
                    + "                        <label for=\"inputPassword\" class=\"control-label\">Password</label>\n"
                    + "                        <input type=\"password\" class=\"form-control\" id=\"inputPassword\" placeholder=\"Password\" required>\n"
                    + "                        <label for=\"confirmPassword\" class=\"control-label\">Confirm Password</label>\n"
                    + "                        <input type=\"password\" class=\"form-control\" id=\"confirmPassword\" placeholder=\"Confirm Password\" required>\n"
                    + "                        <div class=\"checkbox\">\n"
                    + "                            <label><input type=\"checkbox\"> Remember me</label>\n"
                    + "                        </div>\n"
                    + "                        <button href=\"profile.html\" class=\"btn btn-primary\" type=\"submit\" id=\"createAccount\">Create Account</button>\n"
                    + "                    </form><br>         \n"
                    + "                </div>         \n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "        \n"
                    + "        <!-- Add footer -->\n"
                    + "        <footer class=\"footer\">\n"
                    + "            <div class=\"container\">\n"
                    + "                <div class=\"row\">\n"
                    + "                    <div class=\"footer-text\">\n"
                    + "                        <p>Copyright &copy; &ndash; All Rights Reserved 2017</p>\n"
                    + "                    </div>                    \n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "        </footer>\n"
                    + "    </body>\n"
                    + "</html>");
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
        return "A webpage that allows login and account creation.";
    }// </editor-fold>

}
