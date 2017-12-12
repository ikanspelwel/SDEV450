<%-- 
    Document   : listing_detail
    Created on : Dec 6, 2017, 9:19:18 PM
    Author     : Kyle Holmes
    Notes      : Page created primarily by Kyle Holmes, with HTML taken from originally from Cody.  Copied mostly from listings page
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>
<%@include file="footer.jsp" %>
<%@page import="Database.ListingDB" %>
<%@page import="javax.imageio.ImageIO" %>

<%@page import="Objects.Listing" %>
<%@page import="java.text.SimpleDateFormat" %>

<%@page import="Database.ImageDB" %>
<%@page import="Objects.Images" %>
<%@page import="java.sql.SQLException" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <body>

        <!-- Add listing header, listings -->
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="panel panel-default panel-table">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col col-xs-6">
                                    <a href="listings.jsp" class="btn btn-primary" role="button" id="Listings">Listings</a>
                                    <a href="addListing.jsp" class="btn btn-primary" role="button" id="newListing">New Listing</a>
                                    <a href="composeEmail.jsp?listing_id=<% out.print(request.getParameter("listing_id")); %>" class="btn btn-primary" role="button" id="composeMsg">Message Seller</a>
                                </div>                                
                            </div>
                        </div>


                        <div class="panel-body">
                            <table id="listingTable" class="table  table-responsive table-striped table-bordered table-list">
                                <tbody>
                                    <tr>


                                        <% //Setup DBs for lookup
                                            Database.ListingDB listingLookup = new ListingDB();
                                            ImageDB imageLookup = new ImageDB();
                                            //get listing_id from URL
                                            int listing_id = Integer.parseInt(request.getParameter("listing_id"));
                                            try {
                                                Objects.Listing listing = listingLookup.getListing(listing_id);

                                                ArrayList<Integer> imageIDs = imageLookup.lookupImage(listing_id);

                                                //make sure listing is not empty(unlikely if someone clicked on link)
                                                if (listing != null) {
                                                    String title = listing.getListingTitle();
                                                    double price = listing.getPrice();
                                                    String desc = listing.getDescription();
                                                    String date = new SimpleDateFormat("dd/MM/yyyy").format(listing.getDate());
                                                    out.print(String.format("<p><strong>%s ($%.2f):</strong></p><p> %s</p><p> Date Posted:%s</p>", title, price, desc, date));

                                                    //Only execute below if images are present
                                                    if (!imageIDs.isEmpty()) {
                                                        for (int i = 0; i < imageIDs.size(); i++) {
                                                            //this if statement should put 2 images per line.  We can take it out if there are issues
                                                            if ((i & 1) == 0) {
                                                                out.print("</tr><tr>");
                                                            }
                                                            //prints the images
                                                            Images image = imageLookup.getImages(imageIDs.get(i));
                                                            request.setAttribute("listing_id", "1");
                                                            out.print("<td align=\"center\">");
                                                            out.print("<div class=\"thumbnail\">");
                                                            if (image != null) {
                                                                out.print(String.format("<img src=\"ListingServlet?image_id=%d\"", imageIDs.get(i)));//servlet to pull images
                                                                out.print("style=\"width:40%\"/>");//images were too big before
                                                                out.print("</div></td>");
                                                            }
                                                        }

                                                    }
                                                } else {//if for some reason no listing is found (if someone edits url directly)
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
