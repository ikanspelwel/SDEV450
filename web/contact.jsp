<%-- 
    Document   : contact
    Created on : Dec 3, 2017, 3:13:08 PM
    Author     : Ari
--%>
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>
<%@include file="footer.jsp" %>
        <!-- Contact Form -->
        <div class="container">
            <div class="row">         
                <div class="col-xs-12">             
                    <form class="form-horizontal" action="Contact" method="post">
                        <h2 class="signin-heading">Question or concern?  Let us know!</h2>
                        <label for="inputEmail" class="control-label">Email</label>
                        <input type="email" name="email" class="form-control" id="inputEmail" placeholder="Email" required><br>                        
                        <label for="inputSubject" class="control-label">Subject</label>
                        <input type="text" name="subject" class="form-control" id="inputSubject" placeholder="Subject" required><br>
                        <label for="comment" class="control-label">Comment:</label>
                        <textarea class="form-control" name="message" rows="5" id="inputComment" placeholder="Comment..." required></textarea><br>
                        <button class="btn btn-primary btn-lg" type="submit" id="contactSubmit"><a href="#">Submit</a></button>
                    </form>                    
                </div>
            </div>
        </div>
<%@include file="footer.jsp" %>
    </body>
</html>

