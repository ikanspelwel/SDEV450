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
            String userName = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("user")) {
                        userName = cookie.getValue();
                        response.sendRedirect("/DirectSell450/profile.html");
                    }
                }
            }
            if (userName == null) {
                response.sendRedirect("/DirectSell450/login.html");
            }
        %>
        <%
            
        %>
        <%-- Excess Code from Tutorial - May be deleted at later time...
        <h3>Hi <%=userName%>, Login successful.</h3>
        <br>
        <form action="LogoutServlet" method="post">
            <input type="submit" value="Logout" >
        </form>
        --%>
    </body>
</html>
