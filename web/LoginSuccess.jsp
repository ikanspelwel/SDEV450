<%-- 
    Document   : LoginSuccess
    Created on : Nov 12, 2017, 12:01:05 PM
    Author     : Kimberly

// This isn't currently being used, leaving here for now for reference may
use something very similar to this in different code.
--%>

<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
        <%
            //Allow access only if user exists
            Integer uID = null;
            if (session.getAttribute("UID") == null) {
                response.sendRedirect("/DirectSell450/login.jsp");
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

            if (userName == null) {
                response.sendRedirect("/DirectSell450/login.jsp?e1=true");
            } else {
                //Redirects user to profile page if login successful
                response.sendRedirect("/DirectSell450/account.jsp");
            }
        %>
    </body>
</html>
