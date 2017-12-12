<!-- 
     Document   : composeEmail
     Created on : Dec 2, 2017, 10:37:27 AM
     Author     : Original composer hack3, Main functionality added by Adam Ring.
 --%>
<%@page import="Database.UserDB"%>
<%@page import="Database.ListingDB" %>
<%@page import="Objects.Listing" %>
<%@page import="java.sql.SQLException"%>
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

    /**
     * Need to go and get the listing detail based on the provided listingID.
     */
    Database.ListingDB listingLookup = new ListingDB();
    Integer listing_id = null;
    Objects.Listing listing = null; 
    try {
        // Try and get a number from the listing_id param. 
        listing_id = Integer.parseInt(request.getParameter("listing_id"));
    } catch (NumberFormatException e) {
        // Invalid Message ID. They are doing something bad, so just kick em out.
        response.sendRedirect("/DirectSell450/listings.jsp");
        throw new javax.servlet.jsp.SkipPageException();
    }

    try {
        // Try and go and get the listing information. 
        listing = listingLookup.getListing(listing_id);
    } catch (SQLException e) {
        //TODO Report error
        System.out.printf("DB Connection failed: %s\n", e.getMessage());
    }
    
    if(listing == null) {
        // Again trying to do something bad so just kick em out. 
        response.sendRedirect("/DirectSell450/listings.jsp");
        throw new javax.servlet.jsp.SkipPageException();
    }
    
    // Okay now we are good to go, we have a valid listing_id!

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>
<!-- Contact Form -->
<div class="container">
    <div class="row">         
        <div class="col-xs-12">             
            <form class="form-horizontal" action="Contact" method="post">
                <h2 class="signin-heading">Compose Email</h2>                              
                <label for="inputSubject" class="control-label">Subject</label>
                <input type="text" class="form-control" id="inputSubject" placeholder="Subject" required value="<% out.print(listing.getListingTitle()); %>" readonly="true"><br>
                <label for="comment" class="control-label">Message:</label>
                <textarea class="form-control" rows="5" id="inputComment" placeholder="Message..." required></textarea><br>
                <button href="inbox.jsp" class="btn btn-primary btn-lg" type="submit" id="emailSubmit">Submit</button>
                <button href="inbox.jsp" class="btn btn-warning btn-lg" type="button" id="emailCancel">Cancel</button>
            </form><br>                    
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>