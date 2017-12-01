<%-- 
    Document   : sent
    Created on : Nov 18, 2017, 10:30:16 AM
    Author     : ikanspelwel
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
        }
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>
        <!-- Add sent header and messages -->
        <!-- Credit for panel idea goes to harogaston @ https://bootsnipp.com/snippets/ORE6d -->
        <div class="container">            
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="panel panel-default panel-table">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col col-xs-6">
                                    <h3 class="panel-title"><i class="fa fa-paper-plane"></i>&nbsp;Sent Items</h3>
                                </div>                                
                            </div>
                        </div>
                        <div class="panel-body">
                            <table id="inboxTable" class="table table-striped table-bordered table-list">
                                <thead>
                                <tr>
                                    <th class="col-text">Date</th>
                                    <th class="col-text">Name</th>
                                    <th class="col-text">Subject</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Javascript Date Return</td>
                                        <td>JavaScript Name Return</td>
                                        <td>JavaScript Subject Return</td>
                                    </tr>
                                    <tr>
                                        <td>Javascript Date Return</td>
                                        <td>JavaScript Name Return</td>
                                        <td>JavaScript Subject Return</td>
                                    </tr>
                                </tbody>
                            </table>        
                        </div>                        
                    </div>
                </div>
            </div>            
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
