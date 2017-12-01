/*
 * Common componets for servelets
 * Adam Flammino 11/12/17
 */
package Servlets;

public class CommonComponents {
    static String header(){
        return "    <head>\n"
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
                    + "    </head>\n";
    }
    
    static String footer(){
       return "        <!-- Add footer -->\n"
                    + "        <footer class=\"footer\">\n"
                    + "            <div class=\"container\">\n"
                    + "                <div class=\"row\">\n"
                    + "                    <div class=\"footer-text\">\n"
                    + "                        <p>Copyright &copy; &ndash; All Rights Reserved 2017</p>\n"
                    + "                    </div>                    \n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "        </footer>\n";
    }
    
    static String navBar(){
        return "<div class=\"collapse navbar-collapse\" id=\"navbarCollapse\">\n"
                    + "                    <ul class=\"nav navbar-nav\">\n"
                    + "                        <li><a href=\"index.html\">Home</a></li>\n"
                    + "                        <li><a href=\"listings.jsp\">Listings</a></li>\n"
                    + "                        <li><a href=\"about.html\">About</a></li>\n"
                    + "                        <li><a href=\"contact.html\">Contact</a></li>\n"
                    + "                        <li><a href=\"profile.html\">Profile</a></li>\n"
                    + "                        <li class=\"dropdown\">\n"
                    + "                            <a data-toggle=\"dropdown\" class=\"dropdown-toggle\" href=\"#\">Messages <b class=\"caret\"></b></a>\n"
                    + "                            <ul class=\"dropdown-menu\">\n"
                    + "                                <li><a href=\"inbox.jsp\">Inbox</a></li>                        \n"
                    + "                                <li><a href=\"sent.jsp\">Sent Items</a></li>\n"
                    + "                                <li class=\"divider\"></li>\n"
                    + "                                <li><a href=\"trash.jsp\">Trash</a></li>\n"
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
                    + "                        <li class=\"active\"><a href=\"login.jsp\">Login</a></li>\n"
                    + "                    </ul>\n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "        </nav>\n";
    }
}
