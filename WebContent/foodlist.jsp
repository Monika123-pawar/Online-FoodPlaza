<%@page import="com.Foodplaza.pojo.Food"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
tr, th, td {
padding: 15px;
border:1px solid black;
}
}
}
</style>
</head>
<body>
	<div id="templatemo_container">
		<jsp:include page="Header.jsp"></jsp:include>
		<!-- <form action="FoodServlet" method="post"> -->
			<h1 style="text-align: center;">Food Menus List</h1>
			<table style="width: 700px;margin: 70px auto; " align="center" border="1" >
				<tr>
					<th>FoodId</th>
					<th>FoodName</th>
					<th>FoodPrice</th>
					<th>FoodCategory</th>
					<c:if test="${adminname!=null }">
						<th colspan="2">Operation</th>
					</c:if>
					<c:if test="${customername!=null }">
						<th colspan="2">AddToCart</th>
					</c:if>
				</tr>


				<c:forEach var="f" items="${f1}">
					<tr>
						<td>${f.fid }</td>
						<td>${f.fname }</td>
						<td>${f.fprice }</td>
						<td>${f.fcategory}</td>
						<c:if test="${adminname!=null }">
							<td><a href="FoodServlet?action=edit&foodId=${f.fid }">Edit</a></td>
							<td><a href="FoodServlet?action=delete&foodId=${f.fid }">Delete</a></td>
						</c:if>
						<c:if test="${customername!=null }">
							<td><a href=" CartServlet?action=addToCart&foodId=${f.fid }">AddToCart</a></td>
						</c:if>
					</tr>
				</c:forEach>

			</table>
		<!-- </form> -->
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>