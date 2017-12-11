<!-- 
     Document   : composeEmail
     Created on : Dec 2, 2017, 10:37:27 AM
     Author     : hack3
 --%>
<%@page import="Database.UserDB"%>
<%
    /* Instance of our userDB and user class */
    Database.UserDB userCheck = new UserDB();
    Objects.User user = null;

    //Allow access only if user exists
    Integer uID = null;
    if (session.getAttribute("UID") == null) {
        response.sendRedirect("/DirectSell450/login.jsp?e2=true");
        throw new javax.servlet.jsp.SkipPageException();
    } else {
        uID = (Integer) session.getAttribute("UID");
        user = userCheck.GetUser(uID);
        if (user == null) {
            /*
            If user is null, then that user ID wasn't found. Something very 
            fishy there, as this shouldn't really happen, but just going to 
            reset the UID session var and kick them out to the login screen. 
             */
            session.setAttribute("UID", null);
            response.sendRedirect("/DirectSell450/login.jsp?e2=true");
            throw new javax.servlet.jsp.SkipPageException();
        }
    }
%>

 <%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@include file="header.jsp" %>
 <%@include file="navbar.jsp" %>
 <%@include file="footer.jsp" %>
 <!DOCTYPE html>
 <html>    
     <body>
         
         <!-- Contact Form -->
         <div class="container">
             <div class="row">         
                 <div class="col-xs-12">             
                     <form class="form-horizontal" action="Contact" method="post">
                         <h2 class="signin-heading">Compose Email</h2>                              
                         <label for="inputSubject" class="control-label">Subject</label>
                         <input type="text" class="form-control" id="inputSubject" placeholder="Subject" required><br>
                         <label for="comment" class="control-label">Message:</label>
                         <textarea class="form-control" rows="5" id="inputComment" placeholder="Message..." required></textarea><br>
                         <button href="inbox.jsp" class="btn btn-primary btn-lg" type="submit" id="emailSubmit">Submit</button>
                         <button href="inbox.jsp" class="btn btn-warning btn-lg" type="button" id="emailCancel">Cancel</button>
                     </form><br>                    
                 </div>
             </div>
         </div>
     </body>
 </html>