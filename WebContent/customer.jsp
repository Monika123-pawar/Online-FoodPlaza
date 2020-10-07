<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer</title>


<script type="text/javascript">
			function validation() {
	
				var cname=document.getElementById("cname").value;
				var caddress=document.getElementById("caddress").value;
				var ccontact=document.getElementById("ccontact").value;
				var cemail=document.getElementById("cemail").value;
				var cpass=document.getElementById("cpass").value;
				//var conpass=document.getElementById("conpass").value;
				if(cname=="")
				{
				document.getElementById("cnameError").innerHTML="please enter name";
				return false;
				}
				if(caddress=="")
				{
				document.getElementById("caddressError").innerHTML="please enter name";
				return false;
				}
				if(ccontact=="")
				{
				document.getElementById("ccontactError").innerHTML="please enter contact";
				return false;
				}
				if(isNaN(ccontact))
				{
				document.getElementById("ccontactError").innerHTML="please enter contact number in number";
				return false;
				}
				if(ccontact.length!=10)
				{
				document.getElementById("ccontactError").innerHTML="please enter contact number greater than 10 digit";
				return false;
				}
				if(cemail=="")
				{
				document.getElementById("cemailError").innerHTML="please enter email";
				return false;
				}
				if(cpass=="")
				{
				document.getElementById("cpassError").innerHTML="please enter password";
				return false;
				}
				/* if(conpass=="")
				{
				document.getElementById("conpassError").innerHTML="please enter confirm password";
				return false;
				}
				if(conpass!=cpass)
				{
				document.getElementById("conpassError").innerHTML="confirm password and password must be same";
				return false; */
				}  
				return true;
			}
		</script>
</head>

<body>

	<%
		String checkEmail = (String) request.getAttribute("checkEmail");
	%>

	<div id="templatemo_container">
		<jsp:include page="Header.jsp"></jsp:include>
		<div align="center" >
			<h1>Customer</h1>
		</div>
		<%
			if (checkEmail != null) {
		%>
		<script type="text/javascript">
			alert("Email Id Already Exist");
		</script>
		<%
			}
		%>

	
		<form action="CustomerServlet" method="post">

			<input type="hidden" name="action" value="addCust">
			<table style="width: 500px;margin: 15px;" align="center">

				<tr>
					<td>Customer Name:</td>
					<td><input type="text" name="customer_name" id="cname" required>
					<span id="cnameError" style="color: red"></span></td>


				</tr>

				<tr>
					<td>Customer Address:</td>
					<td><textarea rows="6" cols="21" name="customer_address" id="caddress" required></textarea>
					<span id="caddressError" style="color: red"></span></td>
				</tr>

				<tr>
					<td>Customer Contact:</td>
					<td><input type="text" name="ccontact" pattern="[789][0-9]{9}"  id="ccontact" required="color: red">
					<span id="ccontactError" style="color: red"></span></td>	
				</tr>

				<tr>
					<td>Customer Email:</td>
					<td><input type="email" name="customer_email"  id="cemail" autocomplete="off" required>
						<span id="cemailError" style="color: red"></span></td>
				</tr>

				<tr>
					<td>Customer Password:</td>
					<td><input type="password" name="customer_password" pattern=".{6,}" title="six or more characters" id="cpass" required>
						<span id="cpassError" style="color: red"></span></td>
				</tr>

				<tr>
					<td><input type="submit" value="submit" 
						></td>

					<td><input type="reset" name="reset" value="reset" /></td>
				</tr>

			</table>
		</form>
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
	
</body>
</html>