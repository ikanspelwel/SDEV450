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
<%@page import="java.sql.SQLException" %>
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
                                                Objects.Listing[] listing = listingLookup.inOrder(low, high);
                                            

                                           
                                                for (int i = 0; i < listing.length; i++) {
                                                    String title = listing[i].getListingTitle();
                                                    String desc = listing[i].getDescription();
                                                    out.print("<td align=\"center\" class=\"visible-md visible-lg\">");
                                                    out.print(String.format("<option value='%s'>%s</option>", title, desc));
                                                    out.print("</td>");
                                                }
                                             /*else {
                                                out.print("<td align=\"center\" class=\"visible-md visible-lg\">");
                                                out.print("no listing found");
                                                out.print("</td>");
                                                }*/} catch (SQLException e) {
                                                //TODO Report error
                                                System.out.printf("DB Connection failed: %s\n", e.getMessage());
                                            }%>

                                        <td align="center" class="visible-md visible-lg">Listing 2</td>
                                        <td align="center" class="visible-md visible-lg">Listing 3</td>
                                        <td align="center" class="visible-md visible-lg">Listing 4</td>
                                        <td align="center" class="visible-md visible-lg">Listing 5</td>
                                    </tr>
                                    <tr>
                                        <td align="center" class="visible-md visible-lg">Listing 6</td>
                                        <td align="center" class="visible-md visible-lg">Listing 7</td>
                                        <td align="center" class="visible-md visible-lg">Listing 8</td>
                                        <td align="center" class="visible-md visible-lg">Listing 9</td>
                                        <td align="center" class="visible-md visible-lg">Listing 10</td>
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