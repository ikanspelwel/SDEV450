<%-- 
    Document   : ValidateSessionExists
    Created on : Nov 12, 2017, 4:18:06 PM
    Author     : Kimberly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validate Session Exists</title>
    </head>
    <body>
        <%
            //Allow access only if session exists
            //Otherwise redirects to login.html
            //Session established at time of login via LoginSuccess.jsp
            String user = null;
            if (session.getAttribute("user") == null) {
                response.sendRedirect("/DirectSell450/login.html");
                //A modal may be nice here to notify user of need to login
                //before accessing the page they clicked on
            } else {
                //Get the session information 
                user = (String) session.getAttribute("user");
            }
            String userName = null;
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("user")) {
                        userName = cookie.getValue();
                    }
                    if (cookie.getName().equals("JSESSIONID")) {
                        sessionID = cookie.getValue();
                    }
                }
            } else {
                //Back-up URL encoding if cookies 
                //disabled on user computer
                sessionID = session.getId();
            }
            //Redirects user to desired page if cookie/session/URL encoding exists
            /****** Redirect page will need updated with applicable page *******/
            response.sendRedirect("/DirectSell450/profile.html");

            if (userName == null) {
                response.sendRedirect("/DirectSell450/login.html");
            }
        %>
    </body>
</html>
