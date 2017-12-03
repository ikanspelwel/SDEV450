<%-- 
    Document   : composeEmail
    Created on : Dec 2, 2017, 10:37:27 AM
    Author     : hack3
--%>

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
                        <label for="inputEmail" class="control-label">Email</label>
                        <input type="email" name="email" class="form-control" id="inputEmail" placeholder="Email" required><br>
                        <label for="inputSubject" class="control-label">Subject</label>
                        <input type="text" name="subject" class="form-control" id="inputSubject" placeholder="Subject" required><br>
                        <label for="comment" class="control-label">Message:</label>
                        <textarea class="form-control" name="message" rows="5" id="inputComment" placeholder="Message..." required></textarea><br>
                        <button href="#" class="btn btn-primary btn-lg" type="submit" id="emailSubmit">Submit</button>
                        <button href="inbox.jsp" class="btn btn-warning btn-lg" type="button" id="emailCancel">Cancel</button>                       
                    </form><br>                    
                </div>
            </div>
        </div>
    </body>
</html>
