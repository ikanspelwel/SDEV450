<%-- 
    Document   : addListing
    Created on : Nov 18, 2017, 12:14:23 PM
    Author     : ikanspelwel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload to Database Demo</title>
</head>
<body>
    <center>
        <h1>File Upload to Database Demo</h1>
        <form method="post" action="AddListing" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>Place Holder (leave blank): </td>
                    <td><input type="text" name="firstName" size="50"/></td>
                </tr>
                <tr>
                    <td>Place Holder (leave blank): </td>
                    <td><input type="text" name="lastName" size="50"/></td>
                </tr>
                <tr>
                    <td>Image: </td>
                    <td><input type="file" name="image" size="50"/></td>
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