<%-- 
    Document   : account
    Created on : Nov 19, 2017, 12:52:33 PM
    Author     : hack3
--%>
<%@page import="java.sql.SQLException"%>
<%@page import="Objects.Images"%>
<%@page import="Database.ImageDB"%>
<%@page import="Database.UserDB"%>
<%@page import="Database.ListingDB" %>
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
        
        <!-- Profile panel; Idea credit for panel: https://bootsnipp.com/snippets/nPvnk -->
        <div class="container">
            <div class="row">                       
                <div class="col-md-10 col-md-offset-1 col-lg-8 col-lg-offset-2">
                    <div class="panel panel-default">
                        <div class="panel-heading"><h4 >User Profile <button class="btn btn-default pull-right" title="Edit Profile" id="edit"><span <i class="fa fa-pencil"
                                aria-hidden="true" ></i></span></button></h4>
                        </div>
                        <div class="panel-body">       
                            <div class="box box-info">        
                                <div class="box-body">                                    
                                    <div class="col-sm-6">
                                        <h4 class="userName">User Name</h4></span>                                                    
                                    </div>
                                    <div class="clearfix"></div>
                                    <hr style="margin:5px 0 5px 0;">              
                                    <div class="col-sm-5 col-xs-6" >Full Name:</div><div class="col-sm-7 col-xs-6 "> <% out.print(user.getFullName()); %> </div>
                                    <div class="clearfix"></div>
                                    <div class="bot-border"></div>                                                                 
                                    <div class="col-sm-5 col-xs-6" >Email:</div><div class="col-sm-7"><% out.print(user.getEmail()); %></div>
                                    <div class="clearfix"></div>
                                    <div class="bot-border"></div>                                    
                                    <div class="col-sm-5 col-xs-6" >Date Joined:</div><div class="col-sm-7"><% out.print(user.getDateJoined()); %></div>                                    
                                    <div class="clearfix"></div>
                                    <div class="bot-border"></div>                                    
                                    <div class="col-sm-5 col-xs-6" >Zip Code:</div><div class="col-sm-7"><% out.print(user.getZip()); %></div>                                    
                                    <div class="clearfix"></div>
                                    <div class="bot-border"></div>
                                    <!-- <div class="col-sm-5 col-xs-6" >Password:</div><div class="col-sm-7"><% //out.print(user.getPassword()); %></div> -->
                                    <div class="col-sm-5 col-xs-6" >Password:</div><div class="col-sm-7">*********</div> <!-- no need to show the password or even how long it is -->
                                    <div class="clearfix"></div>
                                    <div class="bot-border"></div>
                                </div>
                            </div>            
                        </div> 
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Panel display for active listings table-->
        <div class="container">            
            <div class="row">
                <div class="col-md-10 col-md-offset-1 col-lg-8 col-lg-offset-2">
                    <div class="panel panel-default panel-table">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col col-xs-6">
                                    <h3 class="panel-title"></i>Your Listings</h3>
                                </div>                                
                            </div>
                        </div>
                        <div class="panel-body">
                            <table id="inboxTable" class="table table-bordered table-list">                                
                                <tbody>
                                    <tr>
                                        <%  
                                            Database.ListingDB listingLookup = new ListingDB();
                                            ImageDB imageLookup = new ImageDB();
                                            int low = 0;
                                            int high = 20;
                                            try {
                                                ArrayList<Objects.Listing> arrListing = listingLookup.inOrder(low, high);

                                                if (!arrListing.isEmpty()) {
                                                    for (int i = 0; i < arrListing.size(); i++) {
                                                        // only display the postings associated with the user
                                                        // we're doing it this way instead of reworking the ListingDB functions due to time/potenial recfactoring issues
                                                        if(arrListing.get(i).getUid() == user.getUid()) {
                                                            String title = arrListing.get(i).getListingTitle();
                                                            String desc = arrListing.get(i).getDescription();
                                                            int listing_id = arrListing.get(i).getListingid();
                                                            Images image = imageLookup.getImage(listing_id);
                                                            request.setAttribute("listing_id", "1");
                                                            out.print("<td align=\"center\">");
                                                            out.print("<div class=\"thumbnail\">");
                                                            if (image != null) {
                                                                out.print(String.format("<img src=\"ListingServlet?listing_id=%d\"", listing_id));
                                                                out.print("style=\"width:25%\"/>");
                                                            }
                                                            out.print("</div>");
                                                            // print out the post title and description
                                                            out.print(String.format("<strong>%s:</strong> %s", title, desc));
                                                            out.print("</td>");
                                                            out.print("</tr><tr>");
                                                        }
                                                    }
                                                } else {
                                                    out.print("<td align=\"center\">");
                                                    out.print("no listing found");
                                                    out.print("</td>");
                                                }
                                            } catch (SQLException e) {
                                                //TODO Report error
                                                System.out.printf("DB Connection failed: %s\n", e.getMessage());
								    }%>

                                    </tr>
                                </tbody>
                            </table>        
                        </div>                        
                    </div>
                </div>
            </div>            
        </div>
        
        <!-- Modal for use with edit profile button -->
        <div id="editModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">Edit Profile</h4>
                    </div>
                    <form class="modal-form">
                        <div class="form-group">
                          <label for="fullName">Full Name</label>
                          <input type="text" class="form-control" id="fullName" placeholder="User's current full name">
                        </div>
                        <div class="form-group">
                          <label for="email">Email address</label>
                          <input type="email" class="form-control" id="email" placeholder="Users current email">
                        </div>
                        <div class="form-group">
                          <label for="zipCode">Zip Code</label>
                          <input type="text" class="form-control" id="zipCode" placeholder="Users current zip code">
                        </div>
                        <div class="form-group">
                          <label for="password">Password</label>
                          <input type="password" class="form-control" id="password" placeholder="**********">
                        </div>                
                    </form>
                    <div class="modal-footer">
                        <div class="btn-group btn-group-justified" role="group" aria-label="group button">
                            <div class="btn-group" role="group">
                                <button type="button" class="btn btn-default" data-dismiss="modal"  role="button">Cancel</button>
                            </div>                            
                            <div class="btn-group" role="group">
                                <button type="button" id="submit" class="btn btn-default btn-hover-green" data-action="save" role="button">Submit</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div
    </body>
</html>
