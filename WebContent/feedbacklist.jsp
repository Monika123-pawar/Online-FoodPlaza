<%@page import="com.Foodplaza.pojo.FeedBack"%>
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
<%-- <%
List<FeedBack> c1=(List<FeedBack>)session.getAttribute("c1");
//out.println(f1);
%> --%>
<h1 align="center">Show Feed Back</h1>
<table align="center" cellpadding="6" cellspacing="6" border="3" style="width: 1000px;margin: 15px;" align="center">
<tr>
<th>FeedBackId</th><th>CustomerName</th><th>CustomerEmail</th><th>FeedBack</th><th>Delete</th></tr>
<tr>
<%-- <% for(FeedBack c:c1){ %> --%>
<c:forEach var="c" items="${c1}">

<tr>
<%-- <td><%=c.getFeedid() %></td>
<td><%=c.getFeedback()%></td>
<td><%=c.getName()%></td>
<td><%=c.getCemail() %></td>
 --%>
 <td>${c.feedid }</td>
<td>${c.feedback }</td>
<td>${c.name}</td>
<td>${c.cemail}</td>
 <td><a href="FeedBackServlet?action=delete&feedid=${c.feedid }">Delete</a></td>
</tr>
<%-- <%} %> --%>
</c:forEach>
</tr>
</table>
<jsp:include page="Footer.jsp"></jsp:include>
</div>
<br>
<br>


</body>
</html>