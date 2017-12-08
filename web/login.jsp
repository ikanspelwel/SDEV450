<%-- 
    Document   : login
    Created on : Nov 18, 2017, 9:41:15 AM
    Author     : ikanspelwel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>
<%@include file="footer.jsp" %>
<!DOCTYPE html>
<html>    
    <body>
        
        <!-- Sign in and registration forms -->
        <div class="container">
            <div class="row">         
                <div class="col-sm-12 col-md-6">             
                    <form class="form-horizontal" action="LoginServlet" method="post">
                        <h2 class="signin-heading">Please sign in</h2>
                        <% if( request.getParameter("e1") != null ) { %>
                        <h3 class="alert alert-danger">Invalid login credentials.</h3>
                        <% } %>
                        <% if( request.getParameter("e2") != null ) { %>
                        <h3 class="alert alert-danger">Please login first.</h3>
                        <% } %>
                        <label for="inputEmail" class="control-label">Email</label>
                        <input type="email" name="user" class="form-control" id="inputEmail" placeholder="Email" required>
                        <label for="inputPassword" class="control-label">Password</label>
                        <input type="password" name="pwd" class="form-control" id="inputPassword" placeholder="Password" required>
                        <div class="checkbox">
                            <label><input type="checkbox"> Remember me</label>
                        </div>
                        <button class="btn btn-primary" type="submit" id="loginSubmit">Sign in</button>
                     </form><br>
                    <a href="passReset.jsp" id="resetPass">Forgot your password?</a>
                </div>         
                <div class="col-sm-12 col-md-6">         
                    <form class="form-horizontal" action="AccountCreation" method="post">
                        <h2 class="register-heading">Need to make an account?</h2>
                        <% if( request.getParameter("e3") != null ) { %>
                        <h3 class="alert alert-danger">Email already in use.</h3>
                        <% } %>
                        <% if( request.getParameter("e4") != null ) { %>
                        <h3 class="alert alert-danger">Unknown database error has occurred please try again later.</h3>
                        <% } %>
                        <% if( request.getParameter("e5") != null ) { %>
                        <h3 class="alert alert-danger">Unknown Java error has occurred please try again later.</h3>
                        <% } %>
                        <label for="fullName" class="control-label">Full Name</label>
                        <input name="user" type="text" class="form-control" id="fullName" placeholder="Full Name" required>
                        
                        <label for="zippCode" class="control-label">Zip Code</label>
                        <input name="zip" type="text" class="form-control" id="zipCode" placeholder="Zip Code" required>
                        
                        <label for="inputEmail" class="control-label">Email</label>
                        <input name="email" type="email" class="form-control" id="inputEmail" placeholder="Email" required>
                       
                        <label for="confirmEmail" class="control-label">Confirm Email</label>
                        <input name="emailConfirm" type="email" class="form-control" id="confirmEmail" placeholder="Confirm Email" required>
                        
                        <label for="inputPassword" class="control-label">Password</label>
                        <input name="pwd" nametype="password" class="form-control" id="inputPassword" placeholder="Password" required>
                        
                        <label for="confirmPassword" class="control-label">Confirm Password</label>
                        <input name="pwdConfirm" type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password" required>
                        <div class="checkbox">
                            <label><input type="checkbox"> Remember me</label>
                        </div>
                        <button class="btn btn-primary" type="submit" id="createAccount">Create Account</button>
                    </form><br>         
                </div>         
            </div>
        </div>        
</html>