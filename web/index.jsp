<%-- 
    Document   : index
    Created on : Dec 9, 2017, 11:20:00 AM
    Author     : Cory Hack
    Notes      : Home page of the site in jsp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>
<%@include file="footer.jsp" %>
<!DOCTYPE html>
<html>    
    <body>
        <!-- Add jumbotron with navigation buttons -->
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <div class="jumbotron">
                        <h1>Buy and sell directly.</h1>
                        <p>Direct Sell! allows users to buy or sell items from each other directly.  We make it easy
                           to post items with pictures and descriptions, contact sellers through our in house messaging system, and
                           facilitate payment between parties using PayPal.  Users are free to arrange pickup or delivery as they
                           see fit.</p>
                        <p><a href="login.jsp" class="btn btn-primary btn-lg" role="button">Sign in or Create an Account</a></p>                                                  
                    </div>
                </div>
            </div>
        </div>
        
        <div class="container">
            <div class="text-center"><h2>You can sell just about anything on Direct Sell!</h2></div>            
            <div class="row">
              <div class="col-md-4">
                <div class="thumbnail">                  
                    <img src="images/garage.jpg" alt="Packed Garage" title="Packed Garage" style="width:100%">
                    <div class="caption">
                      <p>Have a garage full of stuff you don't need?  Unload your unwanted items while putting money in your pocket!</p>
                    </div>
                  </a>
                </div>
              </div>
              <div class="col-md-4">
                <div class="thumbnail">                  
                    <img src="images/figures.jpg" alt="Action Figures" title="Action Figures" style="width:100%">
                    <div class="caption">
                      <p>Have some old childs toys that hold no sentimental value?  Sell these toys and add to your childs college fund!</p>
                    </div>
                  </a>
                </div>
              </div>
              <div class="col-md-4">
                <div class="thumbnail">
                  
                    <img src="images/jeep.jpg" alt="Jeep for Sale" title="Jeep for Sale" style="width:100%">
                    <div class="caption">
                      <p>Sell your old vehicle privately and make more money than you would trading it in!</p>
                    </div>
                  </a>
                </div>
              </div>
            </div>
          </div
    </body>
</html>
