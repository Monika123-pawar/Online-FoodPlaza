<%@page import="com.Foodplaza.pojo.Food"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="templatemo_container">
<jsp:include page="Header.jsp"></jsp:include>
<%Food f=(Food)session.getAttribute("selectbyId"); %>
<form action="FoodServlet" method="post">
<input type="hidden" name="action" value="updateFood">
<table style="width: 700px;margin: 50px auto; " align="center" border="1" bordercolor="red">

<tr><td>FoodId</td><td><input type="text" name="foodId"  value="<%=f.getFid()%>" readonly="readonly"></td></tr>
<tr><td>FoodName</td><td><input type="text" name="food_name" value="<%=f.getFname()%>"></td></tr>
<tr><td>FoodPrice</td><td><input type="text" name="food_price"  value="<%=f.getFprice()%>"></td></tr>
<tr><td>FoodCategory</td><td><input type="text" name="food_category" value="<%=f.getFcategory()%>"></td></tr>
<tr><td align="center" colspan="2"><input type="submit" value="update"></td></tr>
</table>

</form>
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>