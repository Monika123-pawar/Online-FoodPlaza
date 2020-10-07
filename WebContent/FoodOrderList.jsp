<%@page import="com.Foodplaza.pojo.FoodOrder"%>
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

<h1 align="center">Food Order List</h1>
<table style="width: 1000px;margin: 15px;" align="center">

<tr>
<th>Order Id</th>
<th>Total Bill</th>
<th>Customer email</th>
<th>Order Date</th>
<th>Status</th>
<th colspan="2">Operation</th>
</tr>


<c:forEach var="f" items="${f1}">
<tr>
<td>${f.orderid }</td>
<td>${f.totalbill}</td>
<td>${f.cemail }</td>
<td>${f.orderdate}</td>
<td>${f.status}</td>
<td><a href="FoodOrderServlet?action=delete&orderId=${f.orderid }">Delete</a></td>
</tr>
</c:forEach>

</table>
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>