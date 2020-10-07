<%@page import="com.Foodplaza.pojo.Customer"%>
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

<h1 align="center"> Customer List</h1>
<table style="width: 1000px;margin: 50px auto; " align="center" border="1" bordercolor="red">
<tr>
<th>CustomerId</th><th>CustomerName</th><th>CustomerAddress</th><th>CustomerContact</th><th>CustomerEmail</th><th>CustomerPassword</th><th>Edit</th><th>Delete</th>
</tr>
<tr>

<c:forEach var="c" items="${c1}">
<tr>
<td>${c.cid }</td>
<td>${c.cname }</td>
<td>${c.caddress }</td>
<td>${c.ccontact}</td>
<td>${c.cemail}</td>
<td>${c.cpassword}</td>
<td><a href="CustomerServlet?action=edit&customerId=${c.cid }">Edit</a></td>
<td><a href="CustomerServlet?action=delete&customerId=${c.cid }">Delete</a></td>
</tr>
</c:forEach>
</tr>
</table>
<jsp:include page="Footer.jsp"></jsp:include>
</div>
<br>
<br>
</body>
</html>