<%-- 
    Document   : listings
    Created on : Nov 19, 2017, 1:47:29 PM
    Author     : kmh5004
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>
<%@include file="footer.jsp" %>
<%@page import="Database.ListingDB" %>
<%@page import="javax.imageio.ImageIO" %>"

<%@page import="Objects.Listing" %>
<%@page import="java.sql.Blob" %>
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
                                    <button href="profile.html" class="btn btn-primary" type="submit" id="loginSubmit">New Listing</button>
                                </div>                                
                            </div>
                        </div>


                        <div class="panel-body">
                            <table id="listingTable" class="table  table-responsive table-striped table-bordered table-list">
                                <tbody>
                                    <tr>


                                        <% Database.ListingDB listingLookup = new ListingDB();
                                        ImageDB imageLookup = new ImageDB();
                                            int low = 0;
                                            int high = 20;
                                            try {
                                                ArrayList<Objects.Listing> arrListing = listingLookup.inOrder(low, high);
                                            
                                           if(!arrListing.isEmpty()){
                                                for (int i=0;i<arrListing.size();i++){
                                                    String title = arrListing.get(i).getListingTitle();
                                                    String desc = arrListing.get(i).getDescription();
                                                    int listing_id = arrListing.get(i).getListingid();
                                                    //out.print(String.format("<jsp: param name=\"listing_id\" value=\"%d\"/>",listing_id));
                                                    Images image=imageLookup.getImage(listing_id);
                                                    //int Image_id = image.getImageid();
                                                  //  Blob imageBlob = image.getImage();
                                                  //  String image_type = image.getImageType();
                                                    request.setAttribute("listing_id","1");
                                                    out.print("<td align=\"center\">");
                                                    out.print("<div class=\"thumbnail\">");
                                                    if(image!=null){
                                                    out.print(String.format("<img src=\"ListingServlet?listing_id=%d\"",listing_id));
                                                    out.print("style=\"width:25%\"/>");
                                                    }
                                                    //out.print("width=\"117\" height=\"160\"");
                         //    out.print("onError=\"loadImage()\" onAbort=\"loadImage()\" />");
                                                    //out.print("alt=\"test\" title=\"test\" style=\"width:100%\">");
                                                    out.print("</div>");
                                                    out.print(String.format("<strong>%s:</strong> %s", title, desc));
                                                    //out.print(String.format("%d",Image_id));
                                                    out.print("</td>");                                                    
                                                    out.print("</tr><tr>");
                                                                
                                                  
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
