<%-- 
    Document   : navbar
    Created on : Nov 18, 2017, 6:29:15 PM
    Author     : Flammino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
                        <li><a href="login.jsp">Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </body>
</html>
