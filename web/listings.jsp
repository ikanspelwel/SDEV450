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
<%@page import="Objects.Listing" %>
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
                            <table id="listingTable" class="table table-striped table-bordered table-list">
                                <tbody>
                                    <tr>


                                        <% Database.ListingDB listingLookup = new ListingDB();
                                            int low = 0;
                                            int high = 20;
                                            try {
                                                ArrayList<Objects.Listing> arrListing = listingLookup.inOrder(low, high);
                                            

                                           if(!arrListing.isEmpty()){
                                                for (int i=0;i<(high-low);i++){
                                                    String title = arrListing.get(i).getListingTitle();
                                                    String desc = arrListing.get(i).getDescription();
                                                    out.print("<td align=\"center\" class=\"visible-md visible-lg\">");
                                                    out.print(String.format("<option value='%s'>\n%s</option>", title, desc));
                                                    out.print("</td>");
                                                    if((i==4)||(i==9)||(i==14)||(i==19)){
                                                        out.print("</tr><tr>");
                                                                
                                                    }
                                                    
                                                } 
                                           }else {
                                                out.print("<td align=\"center\" class=\"visible-md visible-lg\">");
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