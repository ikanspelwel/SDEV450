<%-- 
    Document   : about
    Created on : Dec 9, 2017, 7:02:55 AM
    Author     : Cory Hack
    Notes      : About page describing our team.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>
<%@include file="footer.jsp" %>
<!DOCTYPE html>
<html>
    <body>      
        
        <!-- About us blocks.  Idea credit goes to gutomoraes @ https://bootsnipp.com/snippets/featured/boxes-with-icon-hover -->
        <div class="container">
            <div class="row">        
                <div class="col-xs-12 col-sm-6 col-md-4">
                    <div class="box">
                        <div class="icon">
                            <div class="image"><i class="fa fa-graduation-cap"></i></div>
                            <div class="info">
                                <h3 class="title">Who We Are</h3>
                                    <p>We are a group of students who decided to create a web application that people could use to sell their unused
                                       items.  We wanted to make this process as easy as possible, all within one easy to use application.</p>                                
                            </div>
                        </div>
                        <div class="space"></div>
                    </div> 
                </div>
                <div class="col-xs-12 col-sm-6 col-md-4">
                    <div class="box">
                        <div class="icon">
                            <div class="image"><i class="fa fa-envelope"></i></div>
                            <div class="info">
                                <h3 class="title">We'd Love To Hear From You!</h3>
                                    <p>We are always looking for feedback.  Please don't hesitate to contact us and let us know what you think!</p>
                                <div class="more">
                                    <a href="contact.jsp" class="btn btn-primary btn-lsm"  title="Contact US">Contact US</a>  
                                </div>
                            </div>
                        </div>
                        <div class="space"></div>
                    </div> 
                </div>
                <div class="col-xs-12 col-sm-6 col-md-4">
                    <div class="box">
                        <div class="icon">
                            <div class="image"><i class="fa fa-users"></i></div>
                            <div class="info">
                                <h3 class="title">Humble Beginnings</h3>
                                    <p>All of us attend Champlain College and were taking a Java 3 course.  The course required us to come up
                                       with a group project and meet certain goals.  This led to us designing the Direct Sell! application.</p>                                
                            </div>
                        </div>
                        <div class="space"></div>
                    </div> 
                </div>
            </div>
        </div>
    </body>
</html>
