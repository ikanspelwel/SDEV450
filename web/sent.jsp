<%-- 
    Document   : sent
    Created on : Nov 18, 2017, 10:30:16 AM
    Author     : ikanspelwel
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Database.UserDB"%>
<%@page import="Database.MessagesDB"%>
<%
    /* Instance of our userDB and user class */
    Database.UserDB userCheck = new UserDB();
    Objects.User user = null;
    List<Objects.Messages> allMessages = new ArrayList<>();

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

    Database.MessagesDB messageDb = new MessagesDB();
    try {
        allMessages = messageDb.GetMessages(user.getUid(), "Sent");
    } catch (Exception e) {
        System.out.printf("Retrieving messages failed: %s\n", e.getMessage());
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
                                <% if (allMessages.size() == 0) { %>
                                <th class="col-text">None...</th>
                                <% } else { %>
                                <th class="col-text">Date</th>
                                <th class="col-text">Item</th>
                                <th class="col-text">Message</th>
                                <% } %>
                            </tr>
                        </thead>
                        <tbody>
                            <% System.out.printf("Count of allMessages %d\n", allMessages.size()); %>
                            <% for (int i = 0; i < allMessages.size(); i++) { %>
                            <tr>
                                <td class="visible-md visible-lg"><% out.print(String.format("%s", allMessages.get(i).dateSent.toString())); %></td>
                                <td class="visible-md visible-lg"><% out.print(String.format("%s", allMessages.get(i).listingTitle)); %></td>
                                <td class="visible-md visible-lg"><% out.print(String.format("%s", allMessages.get(i).messageText)); %></td>
                            </tr>
                            <%}%>
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
