<%@page import="com.Foodplaza.pojo.Cart"%>
<%@page import="com.Foodplaza.pojo.Food"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
tr,th, td {
padding: 15px;
border:1px green solid;
}
</style>
</head>
<body>
<div id="templatemo_container">
<jsp:include page="Header.jsp"></jsp:include>
<h1 align="center">Show Cart</h1>
<form action="CartServlet" method="post">
<table style="width: 900px;margin: 50px auto; " align="center" border="1" bordercolor="red">
<tr>
<th>Cart Id</th>
<th>FoodName</th>
<th>FoodPrice</th>
<th>Quantity</th>
<th colspan="2">Operation</th>
</tr>
<c:forEach var="c" items="${c}">
<tr>
<td>${c.cartid }</td>
<td>${c.fname }</td>
<td>${c.fprice }</td>
<input type="hidden" name="price" value="${c.fprice }">
<td><input type="number" name="qty" value="1"></td>
<td><a href="CartServlet?action=delete&cartId=${c.cartid }">Delete</a></td>
</tr>
</c:forEach>
<tr></tr>
<tr><td colspan="5" align="center"><input type="submit" value="placeOrder"></td></tr>

</table>
</form>
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>