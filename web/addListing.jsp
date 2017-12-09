<%-- 
    Document   : addListing
    Created on : Nov 18, 2017, 12:14:23 PM
    Author     : ikanspelwel, modified to include required text fields by Adam Flammino
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>
<%@include file="footer.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>File Upload to Database Demo</title>
    </head>
    <body>
    <center>
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
    </center>
</body>
</html>