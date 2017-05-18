<%-- 
    Document   : Signup
    Created on : 19 Mar, 2017, 6:42:17 PM
    Author     : PAVAN VARMA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sign Up Coop Bank</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="assets1/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets1/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets1/css/form-elements.css">
        <link rel="stylesheet" href="assets1/css/style.css">

        <link rel="shortcut icon" href="assets1/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets1/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets1/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets1/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets1/ico/apple-touch-icon-57-precomposed.png">
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"> </script>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>  
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    </head>

    <body>
       
    
        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <center>
                            <a href="Main.jsp#service" class="btn btn-info" role="button">Back to Main Site</a>
                       </center>
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>Coop Bank</strong> Sign Up </h1>
                           
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>Register to our site</h3>
                            		<p>Enter your Details to Register:</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-key"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="/WebApp/DetecF" method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">Name</label>
			                        	<input type="text" name="form-name" placeholder="Name..." class="form-username form-control" id="form-name" required>
			                        </div>
                                              
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">E-Mail</label>
			                        	<input type="email" name="form-email" placeholder="E-Mail..." class="form-username form-control" id="form-email" required>
			                        </div>
                                                <div class="form-group">
			                        	<label class="sr-only" for="form-password">Address</label>
			                        	<input type="text" name="form-address" placeholder="Address..." class="form-username form-control" id="form-address" required>
			                        </div>
                                                
                                           <div class="form-group">
                                          
                                            <select class="form-control" id="type" name="type">
                                              <option value="choose" selected disabled>Account Type</option>  
                                              <option value="s">Savings Account</option>
                                              <option value="c">Current Account</option>
                                            </select>
                                          </div>
                                                
                                           <div class="form-group">
			                        	<label class="sr-only" for="form-password">Create PIN</label>
			                        	<input type="password" name="form-password" placeholder="Create PIN" class="form-password form-control" id="form-password" required>
			                        </div>
                                                
                                             
                                          <div class="form-group">
			                    		<label class="sr-only" for="form-username">Date of Birth</label>
			                        	<input type="text" name="form-date" placeholder="Date Of Birth(dd/mm/yyyy)" class="form-username form-control" id="form-date">
			                  </div>
                                                
                                                <div class="form-group">
                                          
                                            <select class="form-control" id="gender" name="gender">
                                              <option value="" selected disabled>Choose Sex</option>  
                                              <option value="m">Male</option>
                                              <option value="f">Female</option>
                                            </select>
                                          </div>
                                                

                                        <div class="form-group">
                                                <label class="sr-only" for="form-mobileno">Mobile No</label>
                                                <input type="text" name="form-mobileno" pattern="[7-9]{1}[0-9]{9}" title="Enter mobile no in 10 digit format" placeholder="Mobile No" class="form-username form-control" id="form-mobileno" required>
                                        </div>
                                        <div class="form-group">
                                                <div class="col-md-9 col-md-offset-3">
                                                    <div id="messages"></div>
                                                </div>
                                        </div>        

			                        <button type="submit" class="btn">Sign Up!</button>
			                    </form>
		                    </div>
                        </div>
                    </div>
                    
                </div>
            </div>
            
        </div>


        <!-- Javascript -->
        <script src="assets1/js/jquery-1.11.1.min.js"></script>
        <script src="assets1/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets1/js/jquery.backstretch.min.js"></script>
        <script src="assets1/js/scripts.js"></script>
        

    </body>


</html>

