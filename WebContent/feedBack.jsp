<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>feed back</title>
</head>
<body>
<div id="templatemo_container">
		<jsp:include page="Header.jsp"></jsp:include>
<h1 align="center" ><b>Feed Back</b></h1>
<form action="FeedBackServlet" method="post">
<input type="hidden"name ="action" value="InsertFeedBack">
<table style="width: 700px;margin: 50px auto; " align="center" border="1" bordercolor="red"><tr><td>Leave FeedBack</td><td><textarea rows="6" cols="21" name="feedback"></textarea></td></tr>
<tr><td>Enter Name</td><td><input type="text" name="name" required></td></tr>
<tr><td>Enter Email Id</td><td><input type="text" name="emailid" required></td></tr>
<tr><td><input type="submit" value="submit"></td>
<td><input type="reset" name="reset" value="reset" /></td>
</tr>
</table>
</form>
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>