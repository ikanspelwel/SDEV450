<%-- 
    Document   : listings
    Created on : Nov 19, 2017, 1:47:29 PM
    Author     : Kyle Holmes
    Notes      : java (starting line 48) created primarily by Kyle Holmes, with HTML taken from originally from Cody.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>
<%@include file="footer.jsp" %>
<%@page import="Database.ListingDB" %>
<%@page import="javax.imageio.ImageIO" %>"

<%@page import="Objects.Listing" %>
<%@page import="Database.ImageDB" %>
<%@page import="Objects.Images" %>
<%@page import="java.sql.SQLException" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <body>

        <!-- Add listing header, listings -->
        <!-- Style taken from inbox -->
        <!-- Credit for panel idea goes to harogaston @ https://bootsnipp.com/snippets/ORE6d -->
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="panel panel-default panel-table">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col col-xs-6">
                                    <button href="profile.html" class="btn btn-primary" type="submit" id="loginSubmit">Listings</button>
                                    <button href="profile.html" class="btn btn-primary" type="submit" id="addListing"><a href = addListing.jsp>New Listing</a></button>
                                </div>                                
                            </div>
                        </div>


                        <div class="panel-body">
                            <table id="listingTable" class="table  table-responsive table-striped table-bordered table-list">
                                <tbody>
                                    <tr>


                                        <% Database.ListingDB listingLookup = new ListingDB();
                                        ImageDB imageLookup = new ImageDB();
                                        /*do we have some way to get these values from the URL to determine how many appear on the page?
                                           //it would be "listings.jsp?low=0&high=20"
                                            int low = Integer.parseInt(request.getParameter("low"));
                                            int high = Integer.parseInt(request.getParameter("high"));
                                        */
                                        //I'd like to delete these next 2 lines and use the ones above
                                        int low=0;
                                        int high=20;
                                            try {
                                                ArrayList<Objects.Listing> arrListing = listingLookup.inOrder(low, high);
                                            ArrayList<Integer> imageIDs = null;
                                           if(!arrListing.isEmpty()){
                                                for (int i=0;i<arrListing.size();i++){
                                                    String title = arrListing.get(i).getListingTitle();
                                                    String desc = arrListing.get(i).getDescription();
                                                    int listing_id = arrListing.get(i).getListingid();
                                                    imageIDs = imageLookup.lookupImage(listing_id);
                                                    out.print("<td align=\"center\">");
                                                    out.print("<div class=\"thumbnail\">");
                                                    if(!imageIDs.isEmpty()){
                                                    out.print(String.format("<img src=\"ListingServlet?image_id=%d\"",imageIDs.get(0)));
                                                    out.print("style=\"width:25%\"/>");
                                                    out.print("</div>");
                                                    }
                                                    out.print(String.format("<a href=\"listing_detail.jsp?listing_id=%d\"><strong>%s:</strong> %s</a>", listing_id,title, desc));
                                                    out.print("</td>");                                                    
                                                    out.print("</tr><tr>");
                                                    imageIDs.clear();
                                                } 
                                           }else {
                                                out.print("<td align=\"center\">");
                                                out.print("no listing found");
                                                out.print("</td>");
                                                }} catch (SQLException e) {
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
