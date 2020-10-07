<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Food </title>
</head>
<style type="text/css">
table,th, td {
padding: 15px;
border:1px solid black;
}
}
</style>
<body>
<div id="templatemo_container">
<jsp:include page="Header.jsp"></jsp:include>
<div align="center"> <h1>Add Food</h1></div>
<form action="FoodServlet" method="post">
<input type="hidden" name="action" value="addfood">
<table style="width: 500px;margin: 15px;" align="center">

<tr>
<td>Food Name:</td><td><input type="text" name="food_name" required></td>
</tr>
<tr>
<td>Food Price:</td><td><input type="text"name="food_price" required></td>
</tr>
<tr>
<td>Food Category:</td><td><input type="text"name="food_category" required></td>
</tr>
<tr><td>

<input type="submit"name="submit"value="submit"/>
</td>
<td>
<input type="reset"name="reset"value="reset"/>
</td></tr>
</table>

</form>
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>