<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Spice Multi purpose HTML5 Template</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="http://webthemez.com" />
<!-- css --> 
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="materialize/css/materialize.min.css" media="screen,projection" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/fancybox/jquery.fancybox.css" rel="stylesheet"> 
<link href="css/flexslider.css" rel="stylesheet" /> 
<link href="css/style.css" rel="stylesheet" />
 
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>
<body>
<%String customername=(String)session.getAttribute("customername");
String adminname=(String)session.getAttribute("adminname");%>
<div id="wrapper" class="home-page"> 
	<!-- start header -->
	<header>
        <div class="navbar navbar-default navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html"><i class="icon-info-blocks material-icons">location_on</i>FOODPLAZA</a>
                </div>
                <div class="navbar-collapse collapse "> 
                    <ul class="nav navbar-nav">
                               <li><a href="FoodServlet"><b>Food Menus</b></a></li>
            					<%if(customername==null && adminname==null){ %>
					            <li><a href="login.jsp"><b>Login</b></a></li>
					             <li><a href="customer.jsp"><b>Register</b></a></li>
					            <li><a href="aboutus.jsp"><b>About Us</b></a></li>
					            <%} %> 
					            
					            <%if(customername!=null && adminname==null){ %>
					            <li ><a href="CustomerServlet?action=editProfile"><b>Edit Profile</b></a></li>
					             <li><a href="CartServlet"><b>Show Cart</b></a></li>
					            <li><a href="feedBack.jsp"><b>Feed Back</b></a></li>
					             <%} %>
					             
					             <%if(customername==null && adminname!=null){ %>
					            <li><a href="addfoood.jsp"><b>Add Food</b></a></li>
					            <li><a href="CustomerServlet"><b>Customer List</b></a></li>
					            <li ><a href="FoodOrderServlet"><b>Food Order List</b></a></li>
					             <li><a href="FeedBackServlet"><b>Show Feed Back</b></a></li>
					             <%} %>
					             
					              <%if(customername!=null || adminname!=null){ %>
					            <li ><a href="Login"><b>Log Out</b></a></li>
					              <%} %>
                    </ul>
                </div>
            </div>
        </div>
	</header>