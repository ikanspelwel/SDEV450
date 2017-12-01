<%-- 
    Document   : inbox
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
<%@include file="footer.jsp" %>
<!DOCTYPE html>
<html>
    <body>

        <!-- Add inbox header, mail options and messages -->
        <!-- Credit for panel idea goes to harogaston @ https://bootsnipp.com/snippets/ORE6d -->
        <div class="container">            
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="panel panel-default panel-table">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col col-xs-6">
                                    <h3 class="panel-title"><i class="fa fa-envelope-square"></i>&nbspInbox</h3>
                                </div>                                
                            </div>
                        </div>
                        <div class="panel-body">
                            <table id="inboxTable" class="table table-striped table-bordered table-list">
                                <thead>
                                    <tr>
                                        <th class="col-check visible-md visible-lg"><input type="checkbox" id="checkAll" title="Check All"/><a class="btn btn-danger pull-right visible-md visible-lg" 
                                                                                                                                               title="Delete" id="trash"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>

                                            <!-- JQuery to check all checkboxes -->
                                            <script>
                                                $("#checkAll").click(function () {
                                                    $('input:checkbox').prop('checked', this.checked);
                                                });
                                            </script>
                                        </th>
                                        <th class="col-tools"><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span></th>                                    
                                        <th class="col-text visible-md visible-lg">Date</th>
                                        <th class="col-text">Name</th>
                                        <th class="col-text">Subject</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td align="center" class="visible-md visible-lg"><input type="checkbox" id="checkItem" class="visible-md visible-lg"/></td>
                                        <td align="center">
                                            <a class="btn btn-default" title="Reply"><span <i class="fa fa-reply"
                                                                                              aria-hidden="true" ></i></span></a>
                                            <a class="btn btn-danger" title="Delete"><span class="glyphicon glyphicon-trash"
                                                                                           aria-hidden="true" ></span></a>
                                        </td>
                                        <td class="visible-md visible-lg">Javascript Date Return</td>
                                        <td>JavaScript Name Return</td>
                                        <td>JavaScript Subject Return</td>
                                    </tr>
                                    <tr>
                                        <td align="center" class="visible-md visible-lg"><input type="checkbox" id="checkItem" class="visible-md visible-lg"/></td>
                                        <td align="center">
                                            <a class="btn btn-default" title="Reply"><span <i class="fa fa-reply"
                                                                                              aria-hidden="true"></i></span></a>
                                            <a class="btn btn-danger" title="Delete"><span class="glyphicon glyphicon-trash"
                                                                                           aria-hidden="true"></span></a>
                                        </td>
                                        <td class="visible-md visible-lg">Javascript Date Return</td>
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

        <!-- Modal for use with trash button for confirmation-->
        <div id="delModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">Delete Messages?</h4>
                    </div>
                    <div class="modal-body">
                        <p>Are you sure you want to delete these messages?</p>                        
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        <button type="button" class="btn btn-primary">Confirm</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
