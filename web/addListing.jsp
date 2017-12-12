<%-- 
    Document   : addListing
    Created on : Nov 18, 2017, 12:14:23 PM
    Author     : Adam Ring, modified to include required text fields by Adam Flammino and Cory Hack
                interaction with other files fixed by Adam Flammino
--%>

<%@page import="Database.UserDB"%>
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
    
        <!-- Add Listing Form -->
        <div class="container">
            <div class="row">         
                <div class="col-xs-12">             
                    <form class="form-horizontal" method="post" action="AddListing" enctype="multipart/form-data">
                        <h2>Add a new listing</h2>                        
                        <input type ="hidden" name="uid" value=uID)>
                        <label for="inputTitle" class="control-label">Listing Title:</label>
                        <input type="text" class="form-control" id="inputTitle" name="inputTitle" placeholder="Listing Title..." required>
                        <label for="inputDesc" class="control-label">Description:</label>
                        <textarea class="form-control" rows="5" id="inputDesc" name="inputDesc" placeholder="Description..." required></textarea>
                        <label for="inputCat" class="control-label">Category:</label>
                        <input type="text" class="form-control" id="inputCat" name="inputCat" placeholder="Category..." required>
                        <label for="inputPrice" class="control-label" id="inputPrice">Price:</label>
                        <input type="text" class="form-control" id="inputTitle" name="inputPrice" placeholder="Price..." required>
                        <label for="inputFile" class="control-label">Image (JPEG ONLY): </label><br>
                        <!--Browse button credit to Cory LaViska @ https://www.abeautifulsite.net/whipping-file-inputs-into-shape-with-bootstrap-3 -->
                        <label class="btn btn-default btn-file">Browse...<input type="file" name="image"></label><br>
                        <br><input href="listings.jsp" class="btn btn-primary btn-lg" type="submit" value="Save" id="listingsSubmit"></input>
                        <a href="listings.jsp" class="btn btn-warning btn-lg" type="button" id="emailCancel">Cancel</a>
                    </form><br>                    
                </div>
            </div>
        </div>

<!--    <center>
        <h2>Add a new listing</h2>
        <form method="post" action="AddListing" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>
                        <input type ="hidden" name="uid" value=session.getAttribute("UID")/>
                    </td>
                        
                </tr>
                <tr>
                    <td>Listing title:
                        <br>
                        <br>
                    </td>
                    <td><input type="text" name="title" size="50"/>
                        <br>
                        <br>
                    </td>
                </tr>
                <tr>
                    <td>Description: 
                        <br>
                        <br>
                    </td>
                    <td><textarea name="description" cols="50" rows="10"></textarea>
                        <br>
                        <br>
                    </td>
                </tr>
                <tr>
                    <td>Category: 
                        <br>
                        <br>
                    </td>
                    <td><input type="text" name="category" size="20"/>
                        <br>
                        <br>
                    </td>
                </tr>
                <tr>
                    <td>Price: 
                        <br>
                        <br>
                    </td>
                    <td><input type="text" name="price" size="6"/>
                        <br>
                        <br>
                    </td>
                </tr>
                <tr>
                    <td>Image: 
                        <br>
                        <br>
                    </td>
                    <td><input type="file" name="image" size="50"/>
                        <br>
                        <br>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save">
                    </td>
                </tr>
            </table>
        </form>
    </center>-->
    </body>
</html>