<%@page import="com.Foodplaza.pojo.Customer"%>
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
<%Customer c=(Customer)session.getAttribute("selectBy");%>
<form action="CustomerServlet" method="post">
<input type="hidden" name="action" value="updateCust">
<table style="width: 700px;margin: 50px auto; " align="center" border="1" bordercolor="red">

<tr><td>CustomerId</td><td><input type="text" name="cid" value="<%=c.getCid()%>" readonly="readonly"></td></tr>
<tr><td>CustomerName</td><td><input type="text" name="customer_name" value="<%=c.getCname()%>"></td></tr>
<tr><td>CustomerAddress</td><td><input type="text" name="customer_address" value="<%=c.getCaddress()%>"></td></tr>
<tr><td>CustomerContact</td><td><input type="text" name="customer_contact" value="<%=c.getCcontact()%>"></td></tr>
<tr><td>CustomerEmail</td><td><input type="text" name="customer_email" value="<%=c.getCemail()%>"></td></tr>
<tr><td>CustomerPassword</td><td><input type="text" name="customer_password" value="<%=c.getCpassword()%>"></td></tr>
<tr><td align="center" colspan="2"><input type="submit" value="update"></td></tr>
</table>
</form>
<jsp:include page="Footer.jsp"></jsp:include>
</div>
<br>
<br>
<br>
</body>
</html>