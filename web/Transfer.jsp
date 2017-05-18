<%-- 
    Document   : Transfer
    Created on : 19 Mar, 2017, 10:54:56 PM
    Author     : PAVAN VARMA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Transfer Fund Coop Bank</title>

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

    </head>

    <body>
    <center>
        <a href="Main.jsp" class="btn btn-info" role="button">Back to Main</a>
    </center>
    <br>
    <%
        if(session.getAttribute("uname")!=null)
        {   
            out.print("<center>");
            out.print("Hello! "+session.getAttribute("uname")+"<br>");
            out.print("<a href='#' class='btn btn-info' role='button'>Logout</a>");
            out.print("</center>");
        }
    %>
        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>Coop Bank</strong> Transfer Funds </h1>
                            <div class="description">
                            	<p>
	                            	Enter Your Details
                            	</p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>Transfer Funds</h3>
                            		<p>Enter the Account Number and Amount to be Transfered</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-key"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="/WebApp/Transfer" method="post" class="login-form">
                                        <div class="form-group">
                                          
                                            <select class="form-control" id="type" name="acc_type1">
                                              <option value="" selected disabled>Sender's Account Type</option>  
                                              <option value="s">Savings Account</option>
                                              <option value="c">Current Account</option>
                                            </select>
                                          </div>
                                                <div class="form-group">
                                                  <label class="sr-only" for="form-username">Sender's Account No</label>
                                                  <input type="text" name="send_account_number" placeholder=" Sender's Account No..." class="form-username form-control" id="form-username">
                                                </div>
                                                
                                                <div class="form-group">
                                          
                                            <select class="form-control" id="type" name="acc_type2">
                                              <option value="" selected disabled>Receiver's Account Type</option>  
                                              <option value="s">Savings Account</option>
                                              <option value="c">Current Account</option>
                                            </select>
                                          </div>
                                                <div class="form-group">
                                                  <label class="sr-only" for="form-username">Receiver's Account No</label>
                                                  <input type="text" name="recv_account_number" placeholder="Receiver's Account No..." class="form-username form-control" id="form-username">
                                                </div>
                                                
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Amount</label>
			                        	<input type="text" name="amount" placeholder="Amount..." class="form-password form-control" id="form-password">
			                        </div>
			                        <button type="submit" class="btn">Transfer</button>
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

