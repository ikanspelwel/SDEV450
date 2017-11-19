<%-- 
    Document   : header
    Created on : Nov 18, 2017, 6:25:05 PM
    Author     : Flammino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Direct Sell!</title>
        
        <!-- Bootsrap CDN Import -->              
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
                integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"
              
        <!-- Custom styles -->
        <link rel="stylesheet" type="text/css" href="css/style.css">
        
        <!-- Font Awesome CDN for expanded glyphicons -->
        <script src="https://use.fontawesome.com/3d123a1bf9.js"></script>
        
        <!-- JavaScript for active page navbar highlight -->
        <script>
            $(function(){
                $('a').each(function(){
                    if ($(this).prop('href') == window.location.href) {
                        $(this).addClass('active'); $(this).parents('li').addClass('active');
                    }
                });
            });
        </script>
        
        <!-- JavaScript function for modal use with the check all trash button -->
        <script type="text/javascript">
            $(document).ready(function(){
                $("#trash").click(function(){
                    $("#permDelModal").modal('show');
                });
            });
        </script>
        
        <script type="text/javascript">
            $(document).ready(function(){
                $("#trash").click(function(){
                    $("#delModal").modal('show');
                });
            });
        </script>
        
        <!-- JavaScript function for modal use with the edit profile button -->
        <script type="text/javascript">
            $(document).ready(function(){
                $("#edit").click(function(){
                    $("#editModal").modal('show');
                });
            });
        </script>
        
    </head>
</html>
