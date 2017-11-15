<%-- 
    Document   : LoginSuccess
    Created on : Nov 12, 2017, 12:01:05 PM
    Author     : Kimberly
--%>

<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
        <title>Login Success Page</title>
    </head>
    <body>
        <%
            //Allow access only if user exists
            Integer uID = null;
            if (session.getAttribute("UID") == null) {
                response.sendRedirect("/DirectSell450/login.html");
            } else {
                uID = (Integer) session.getAttribute("UID");
            }
            String userName = null;
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {

                    if (cookie.getName().equals("login")) {
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
            //Redirects user to profile page if login successful
            response.sendRedirect("/DirectSell450/profile.html");

            if (userName == null) {
                response.sendRedirect("/DirectSell450/login.html");
            }
        %>
    </body>
</html>
