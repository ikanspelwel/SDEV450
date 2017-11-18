<%-- 
    Document   : login
    Created on : Nov 18, 2017, 9:41:15 AM
    Author     : ikanspelwel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Direct Sell!</title>
        
        <!-- Bootsrap CDN Import -->              
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
                integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"
              
        <!-- Custom styles -->
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        
        <!-- Create Navbar that collapses for mobile and expands for larger screens -->
        <nav id="myNavbar" class="navbar navbar-default" role="navigation">    
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html">Direct Sell!</a>
                </div>
                
                <!-- Navigation links and forms -->
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <ul class="nav navbar-nav">
                        <li><a href="index.html">Home</a></li>
                        <li><a href="listings.html">Listings</a></li>
                        <li><a href="about.html">About</a></li>
                        <li><a href="contact.html">Contact</a></li>
                        <li><a href="profile.html">Profile</a></li>
                        <li class="dropdown">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">Messages <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="inbox.jsp">Inbox</a></li>                        
                                <li><a href="sent.html">Sent Items</a></li>
                                <li class="divider"></li>
                                <li><a href="trash.html">Trash</a></li>
                            </ul>
                        </li>
                        <form class="navbar-form navbar-left">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search">
                                <span class="input-group-btn">
                                    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
                                </span>
                            </div>
                        </form>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="login.jsp">Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <!-- Sign in and registration forms -->
        <div class="container">
            <div class="row">         
                <div class="col-sm-12 col-md-6">             
                    <form class="form-horizontal" action="LoginServlet" method="post">
                        <h2 class="signin-heading">Please sign in</h2>
                        <label for="inputEmail" class="control-label">Email</label>
                        <input type="email" name="user" class="form-control" id="inputEmail" placeholder="Email" required>
                        <label for="inputPassword" class="control-label">Password</label>
                        <input type="password" name="pwd" class="form-control" id="inputPassword" placeholder="Password" required>
                        <div class="checkbox">
                            <label><input type="checkbox"> Remember me</label>
                        </div>
                        <button class="btn btn-primary" type="submit" id="loginSubmit">Sign in</button>
                     </form><br>
                    <a href="#" id="resetPass">Forgot your password?</a>
                </div>         
                <div class="col-sm-12 col-md-6">         
                    <form class="form-horizontal">
                        <h2 class="register-heading">Need to make an account?</h2>
                        <label for="fullName" class="control-label">Full Name</label>
                        <input type="text" class="form-control" id="fullName" placeholder="Full Name" required>
                        <label for="zippCode" class="control-label">Zip Code</label>
                        <input type="text" class="form-control" id="zipCode" placeholder="Zip Code" required>
                        <label for="inputEmail" class="control-label">Email</label>
                        <input type="email" class="form-control" id="inputEmail" placeholder="Email" required>
                        <label for="confirmEmail" class="control-label">Confirm Email</label>
                        <input type="email" class="form-control" id="confirmEmail" placeholder="Confirm Email" required>
                        <label for="inputPassword" class="control-label">Password</label>
                        <input type="password" class="form-control" id="inputPassword" placeholder="Password" required>
                        <label for="confirmPassword" class="control-label">Confirm Password</label>
                        <input type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password" required>
                        <div class="checkbox">
                            <label><input type="checkbox"> Remember me</label>
                        </div>
                        <button class="btn btn-primary" type="submit" id="createAccount">Create Account</button>
                    </form><br>         
                </div>         
            </div>
        </div>
        
        <!-- Add footer -->
        <footer class="footer">
            <div class="container">
                <div class="row">
                    <div class="footer-text">
                        <p>Copyright &copy; &ndash; All Rights Reserved 2017</p>
                    </div>                    
                </div>
            </div>
        </footer>
    </body>
</html>