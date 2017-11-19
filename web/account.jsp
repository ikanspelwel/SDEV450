<%-- 
    Document   : account
    Created on : Nov 19, 2017, 12:52:33 PM
    Author     : hack3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>
<%@include file="footer.jsp" %>
<!DOCTYPE html>
<html>    
    <body>
        
        <!-- Profile panel; Idea credit for panel: https://bootsnipp.com/snippets/nPvnk -->
        <div class="container">
            <div class="row">                       
                <div class="col-md-10 col-md-offset-1 col-lg-8 col-lg-offset-2">
                    <div class="panel panel-default">
                        <div class="panel-heading"><h4 >User Profile <button class="btn btn-default pull-right" title="Edit Profile" id="edit"><span <i class="fa fa-pencil"
                                aria-hidden="true" ></i></span></button></h4>
                        </div>
                        <div class="panel-body">       
                            <div class="box box-info">        
                                <div class="box-body">                                    
                                    <div class="col-sm-6">
                                        <h4 class="userName">User Name</h4></span>                                                    
                                    </div>
                                    <div class="clearfix"></div>
                                    <hr style="margin:5px 0 5px 0;">              
                                    <div class="col-sm-5 col-xs-6" >Full Name:</div><div class="col-sm-7 col-xs-6 ">fName</div>
                                    <div class="clearfix"></div>
                                    <div class="bot-border"></div>                                                                 
                                    <div class="col-sm-5 col-xs-6" >Email:</div><div class="col-sm-7">email@email.com</div>
                                    <div class="clearfix"></div>
                                    <div class="bot-border"></div>                                    
                                    <div class="col-sm-5 col-xs-6" >Date Joined:</div><div class="col-sm-7">11 Nov 201</div>                                    
                                    <div class="clearfix"></div>
                                    <div class="bot-border"></div>                                    
                                    <div class="col-sm-5 col-xs-6" >Zip Code:</div><div class="col-sm-7">12345</div>                                    
                                    <div class="clearfix"></div>
                                    <div class="bot-border"></div>
                                    <div class="col-sm-5 col-xs-6" >Password:</div><div class="col-sm-7">***********</div>                                    
                                    <div class="clearfix"></div>
                                    <div class="bot-border"></div>
                                </div>
                            </div>            
                        </div> 
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Panel display for active listings table-->
        <div class="container">            
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="panel panel-default panel-table">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col col-xs-6">
                                    <h3 class="panel-title"></i>Active Listings</h3>
                                </div>                                
                            </div>
                        </div>
                        <div class="panel-body">
                            <table id="inboxTable" class="table table-bordered table-list">                                
                                <tbody>
                                    <tr>
                                        <td>Listing 1</td>
                                        <td>Listing 2</td>
                                        <td>Listing 3</td>
                                    </tr>
                                    <tr>
                                        <td>Listing 4</td>
                                        <td>Listing 5</td>
                                        <td>Listing 6</td>
                                    </tr>
                                </tbody>
                            </table>        
                        </div>                        
                    </div>
                </div>
            </div>            
        </div>
        
        <!-- Modal for use with edit profile button -->
        <div id="editModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">Edit Profile</h4>
                    </div>
                    <form class="modal-form">
                        <div class="form-group">
                          <label for="fullName">Full Name</label>
                          <input type="text" class="form-control" id="fullName" placeholder="User's current full name">
                        </div>
                        <div class="form-group">
                          <label for="email">Email address</label>
                          <input type="email" class="form-control" id="email" placeholder="Users current email">
                        </div>
                        <div class="form-group">
                          <label for="zipCode">Zip Code</label>
                          <input type="text" class="form-control" id="zipCode" placeholder="Users current zip code">
                        </div>
                        <div class="form-group">
                          <label for="password">Password</label>
                          <input type="password" class="form-control" id="password" placeholder="**********">
                        </div>                
                    </form>
                    <div class="modal-footer">
                        <div class="btn-group btn-group-justified" role="group" aria-label="group button">
                            <div class="btn-group" role="group">
                                <button type="button" class="btn btn-default" data-dismiss="modal"  role="button">Cancel</button>
                            </div>                            
                            <div class="btn-group" role="group">
                                <button type="button" id="submit" class="btn btn-default btn-hover-green" data-action="save" role="button">Submit</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div
    </body>
</html>
