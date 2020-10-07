<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#username").blur(function(){
		var v=$("#username").val();
        if(v==null||v=="")
        	{
        	//alert();
        	$("span").text("username is must");
        	}
	});
	
	$("#password").blur(function(){
		var v=$("#password").val();
        if(v==null||v=="")
        	{
        	//alert();
        	$("span").text("password is must");
        	}
	});
});
</script>
<style type="text/css">
table, th, td {
  border: 1px solid black;
}
}
</style>
</head>
<body>
<div id="templatemo_container">
<jsp:include page="Header.jsp"/>
<form action="Login" method="post"> 
<h1 align="center">Login </h1>
<!-- <table align="center" cellpadding="10" cellspacing="6" border="4" style="width:70%"> -->
<table style="width: 500px;margin: 15px;"   border="4" align="center">

<tr><td>Type</td><td><!-- <input type="text" id="select" name="select" required>  -->
<input list="selects" name="select">
<datalist id="selects">
<option value="admin" >
<option  value="customer">
</datalist> 
<!-- <select name="select" >
 <option >select</option>
<option value="admin" >Admin</option>
<option  value="customer">Customer</option> 
</select> -->
</td></tr>
<tr><td>UserName</td><td><input type="text" id="username" name="username" required><span></span></td></tr>
<tr><td>Password</td><td><input type="password" id="password" name="password"  required ></td></tr>
<tr><td><input  type="submit" name="submit" value="submit"/></td>
<td><input  type="reset" name="reset" value="reset"/></td></tr>
</table>
</form>
<jsp:include page="Footer.jsp"/>
</div>
</body>
</html>