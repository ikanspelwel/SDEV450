<%-- 
    Document   : passReset
    Created on : Dec 7, 2017, 7:05:07 PM
    Author     : ikanspelwel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<!-- JavaScript function for modal use with the reset button-->
<script type="text/javascript">
    $(document).ready(function(){
        $("#resetSubmit").click(function(){
            $("#resetModal").modal('show');
        });
    });
</script>

<%@include file="navbar.jsp" %>


<div class="container">
    <div class="row">         
        <div class="col-sm-12 col-md-6">             
            <form class="form-horizontal">
                <h2 class="signin-heading">Password Recovery</h2>
                <label for="inputEmail" class="control-label">Email</label>
                <input type="email" class="form-control" id="inputEmail" placeholder="Email" required><br>                        
                <button href="profile.html" class="btn btn-primary" type="submit" id="resetSubmit">Reset Password</button>
            </form><br>                    
        </div>                          
    </div>
</div>

<!-- Modal for use with the reset password button for confirmation -->
<div id="resetModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Password Reset</h4>
            </div>
            <div class="modal-body">
                <p>You have been sent an email containing a temporary password.</p>                        
            </div>                    
        </div>
    </div>
</div


<%@include file="footer.jsp" %>
</body>
</html>
