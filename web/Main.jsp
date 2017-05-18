<%-- 
Document   : Main
    Created on : 19 Mar, 2017, 6:37:53 PM
    Author     : PAVAN VARMA
--%>

<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js"> <!--<![endif]-->
    
<head>
<!-- meta character set -->  
<meta charset="utf-8">
<!-- Always force latest IE rendering engine or request Chrome Frame -->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Welcome to Coop Bank</title>
<!-- Meta Description -->
<meta name="description" content="Blue One Page Creative HTML5 Template">
<meta name="keywords" content="one page, single page, onepage, responsive, parallax, creative, business, html5, css3, css3 animation">
<meta name="author" content="Coop Bank">
<!-- Mobile Specific Meta -->
<meta name="viewport" content="width=device-width, initial-scale=1">		
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
<!-- Fontawesome Icon font -->     
<link rel="stylesheet" href="css/font-awesome.min.css">
<!-- bootstrap.min -->
<link rel="stylesheet" href="css/jquery.fancybox.css">
<!-- bootstrap.min -->
<link rel="stylesheet" href="css/bootstrap.min.css">		
<!-- bootstrap.min -->
<link rel="stylesheet" href="css/owl.carousel.css">
<!-- bootstrap.min -->
<link rel="stylesheet" href="css/slit-slider.css">
<!-- bootstrap.min -->
<link rel="stylesheet" href="css/animate.css">
<!-- Main Stylesheet -->
<link rel="stylesheet" href="css/main.css">
<!-- Modernizer Script for old Browsers -->
<script src="js/modernizr-2.6.2.min.js">
</script>
</head>
<body id="body">	
<div id="preloader">
<div class="loder-box">
<div class="battery">
</div>
</div>	
</div>

        
<!--
Fixed Navigation
==================================== -->
        
<header id="navigation" class="navbar-inverse navbar-fixed-top animated-header">
            
<div class="container">
                
<div class="navbar-header">
                    
<!-- responsive nav button -->
					
<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
						
<span class="sr-only">Toggle navigation</span>
						
<span class="icon-bar"></span>
						
<span class="icon-bar"></span>
						
<span class="icon-bar"></span>
                    
</button>
					
<!-- /responsive nav button -->
					
					
<!-- logo -->
					
<h1 class="navbar-brand">
						
<a href="Main.html">Coop Bank</a>
					
</h1>
					
<!-- /logo -->
                
</div>

				
<!-- main nav -->
                
<nav class="collapse navbar-collapse navbar-right" role="navigation">
   
<ul id="nav" class="nav navbar-nav">    
    
<li><a href="#body">Home</a></li>
                        
<li><a href="#service">Login/Sign Up</a></li>

<li><a href="#contact">Contact Us</a></li>
<%
    if(session.getAttribute("uname") == null)
    {
        out.print("<li><a href='#'>Hello Please Login</a></li>");
    }
    else
    {
        out.print("<li><a href='#'>Hello "+session.getAttribute("uname")+"</a></li>");
        out.print("<li>");
        out.print("<form action='/WebApp/Logout' method='post'>");
        out.print("<button type='submit' class='btn'>Logout</button>");
        out.print("</form>");
        out.print("</li>");
    }
%>
</ul>           
</nav>       
</div>
        
</header>
        
<!--
End Fixed Navigation
====================================-->
		
		
<main class="site-content" role="main">
		
        
<!--
Home Slider
====================================-->
		
		
<section id="home-slider">
				
					
<div class="sl-slide" data-orientation="horizontal" data-slice1-rotation="-25" data-slice2-rotation="-25" data-slice1-scale="2" data-slice2-scale="2">

						
<div class="bg-img bg-img-1">
</div>

						
<div class="slide-caption">
                            
<div class="caption-content">
                                
<h2 class="animated fadeInDown">Coop Bank</h2>
                                
<span class="animated fadeInDown">Help You Grow</span>
                                

</div>
                        
</div>
						
					
</div>
</section>
		
        
<!--
End Home SliderEnd
====================================-->
			
		
			
<!-- Service section -->
			
<section id="service">
					
						
<div class="sec-title text-center">
							
<h2 class="wow animated bounceInLeft">Login Coop Bank</h2>
							
<p class="wow animated bounceInRight">Choose Your Way</p>
						
</div>
						
						
<div class="col-md-3 col-sm-6 col-xs-12 text-center wow animated zoomIn">

<div class="service-item">
								
<div class="service-icon">

<a href = "Login.jsp">
									
<i class="fa fa-home fa-3x"></i></a>
								
</div>
								
<h3>Login</h3>
								
<p>Already Registered User can login with their Customer ID</p>
							
</div>
						
</div>
					
						
<div class="col-md-3 col-sm-6 col-xs-12 text-center wow animated zoomIn" data-wow-delay="0.3s">
							
<div class="service-item">
								
<div class="service-icon">

<a href = "Signup.jsp">									
<i class="fa fa-tasks fa-3x"></i></a>
								
</div>
								
<h3>Register User</h3>
								
<p>New User must create Account and get their Customer ID</p>
							
</div>
						
</div>

<%
    if(session.getAttribute("uname")!=null)
    {
        out.print("<div class='col-md-3 col-sm-6 col-xs-12 text-center wow animated zoomIn' data-wow-delay='0.3s'>");
        out.print("<div class='service-item'>");
	out.print("<div class='service-icon'>");
        out.print("<a href = 'Transfer.jsp'>");
	out.print("<i class='fa fa-tasks fa-3x'></i></a>");
	out.print("</div>");
	out.print("<h3>NEFT Transfer</h3>");
	out.print("<p>User can transfer money online from one account to another.</p>");
        out.print("</div>");
	out.print("</div>");
        out.print("<div class='col-md-3 col-sm-6 col-xs-12 text-center wow animated zoomIn' data-wow-delay='0.3s'>");
	out.print("<div class='service-item'>");
	out.print("<div class='service-icon'>");
        out.print("<a href = 'Balance.jsp'>");									
        out.print("<i class='fa fa-tasks fa-3x'></i></a>");
	out.print("</div>");
	out.print("<h3>Check Balance</h3>");
        out.print("<p>Can check their account balance.</p>");
	out.print("</div>");
	out.print("</div>");
    }
    else
    {
        out.print("<div class='col-md-3 col-sm-6 col-xs-12 text-center wow animated zoomIn' data-wow-delay='0.3s'>");
        out.print("<div class='service-item'>");
	out.print("<div class='service-icon'>");
        out.print("<a href = '#'>");
	out.print("<i class='fa fa-tasks fa-3x'></i></a>");
	out.print("</div>");
	out.print("<h3>NEFT Transfer</h3>");
	out.print("<p>User can transfer money online from one account to another.</p>");
        out.print("</div>");
	out.print("</div>");
        out.print("<div class='col-md-3 col-sm-6 col-xs-12 text-center wow animated zoomIn' data-wow-delay='0.3s'>");
	out.print("<div class='service-item'>");
	out.print("<div class='service-icon'>");
        out.print("<a href = '#'>");									
        out.print("<i class='fa fa-tasks fa-3x'></i></a>");
	out.print("</div>");
	out.print("<h3>Check Balance</h3>");
        out.print("<p>Can check their account balance.</p>");
	out.print("</div>");
	out.print("</div>");
    }

%>
</section>
<!-- end Service section -->

			

			
<!-- Contact section -->
			
<section id="contact" >
				
<div class="container">
					
<div class="row">
						
						
<div class="sec-title text-center wow animated fadeInDown">


<br/>
<br/>
<br/>
<br/>
<br/>
<h2>Comment</h2>
<p>Leave a Message</p>
						
</div>
						
						
						
<div class="col-md-7 contact-form wow animated fadeInLeft">
							
<form action="getComment.htm" method="post">
								
<div class="input-field">
									
<input type="text" name="name" class="form-control" placeholder="Your Name...">
								
</div>
								
<div class="input-field">
									
<input type="email" name="email" class="form-control" placeholder="Your Email...">
								
</div>
								
<div class="input-field">
									
<textarea name="message" class="form-control" placeholder="Messages..."></textarea>
								
</div>
						       
<input name = "submit" type="submit" value = "Submit" class="btn btn-blue btn-effect">
							
</form>
						
</div>
						
						
<div class="col-md-5 wow animated fadeInRight">
							
<address class="contact-details">
								
<h3>Contact Us</h3>						
								
<p><i class="fa fa-pencil"></i>
Coop Bank
<span>SRM Nagar</span> 
<span>SRM University,Kattankulathur,Chennai</span>
<span>India</span></p><br>
								
<p><i class="fa fa-phone"></i>Phone: +91 9876543210</p>
								
<p><i class="fa fa-envelope"></i>abc@gmail.com</p>
							
</address>
						
</div>
			
					
</div>
				
</div>
			
</section>
			
<!-- end Contact section -->
</main>
		
		

		
		
<!-- Essential jQuery Plugins================================================== -->
		
<!-- Main jQuery -->
        
<script src="js/jquery-1.11.1.min.js"></script>
		
<!-- Twitter Bootstrap -->
        
<script src="js/bootstrap.min.js"></script>
		
<!-- Single Page Nav -->
        
<script src="js/jquery.singlePageNav.min.js"></script>
		
<!-- jquery.fancybox.pack -->
        
<script src="js/jquery.fancybox.pack.js"></script>
		
<!-- Google Map API -->
		
<script src="http://maps.google.com/maps/api/js?sensor=false"></script>
		
<!-- Owl Carousel -->
        
<script src="js/owl.carousel.min.js"></script>
        
<!-- jquery easing -->
        
<script src="js/jquery.easing.min.js"></script>
        
<!-- Fullscreen slider -->
        
<script src="js/jquery.slitslider.js"></script>
        
<script src="js/jquery.ba-cond.min.js"></script>
		
<!-- onscroll animation -->
        
<script src="js/wow.min.js"></script>
		
<!-- Custom Functions -->
        
<script src="js/main.js"></script>
    
</body>

</html>