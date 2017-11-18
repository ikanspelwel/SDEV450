<%-- 
    Document   : inbox
    Created on : Nov 18, 2017, 10:30:16 AM
    Author     : ikanspelwel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Direct Sell!</title>
        
        <!-- Bootstrap CDN Import -->                
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
                integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        
        <!-- Custom styles -->
        <link rel="stylesheet" type="text/css" href="css/style.css">
        
        <!-- Font Awesome CDN for expanded glyphicons -->
        <script src="https://use.fontawesome.com/3d123a1bf9.js"></script>       

    </head>
    <body>
        
        <!-- Create Navbar that collapses for mobile and expands for larger screens -->
        <nav id="myNavbar" class="navbar navbar-default" role="navigation">    
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html">Direct Sell!</a>
                </div>
                
                <!-- Navigation links and forms -->
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <ul class="nav navbar-nav">
                        <li><a href="index.html">Home</a></li>
                        <li><a href="listings.html">Listings</a></li>
                        <li><a href="about.html">About</a></li>
                        <li><a href="contact.html">Contact</a></li>
                        <li><a href="profile.html">Profile</a></li>
                        <li class="dropdown active">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">Messages <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="inbox.jsp">Inbox</a></li>                        
                                <li><a href="sent.html">Sent Items</a></li>
                                <li class="divider"></li>
                                <li><a href="trash.html">Trash</a></li>
                            </ul>
                        </li>
                        <form class="navbar-form navbar-left">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search">
                                <span class="input-group-btn">
                                    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
                                </span>
                            </div>
                        </form>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                    <li><a href="login.html">Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        
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
                                    <th class="col-check visible-md visible-lg"><input type="checkbox" id="checkAll" title="Check All"/><a class="btn btn-danger pull-right visible-md visible-lg" title="Delete">
                                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
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