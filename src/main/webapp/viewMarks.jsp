<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("rollno")==null){
	response.sendRedirect("login.jsp");
}
%> 
<jsp:include page="adminHeader.jsp"></jsp:include>
<div class="t-body">
<div class="std-content">
<div class="t-title">
<h1>Students Mark List</h1>
</div>
<div class="t-data">
<table border=1>
<tr>
<th>Roll Number</th>
<th>SUB-CODE</th>
<th>SUB-NAME</th>
<th>T-1</th>
<th>Q-1</th>
<th>A-1</th>
<th>TOTAL</th>
<th>EXT</th>
<th>SEM</th>
<th>ACTION</th>
</tr>
<c:forEach var="mark" items="${markList}">
<tr>
<td>${mark.rollno}</td>
<td>${mark.subcode}</td>
<td>${mark.subname}</td>
<td>${mark.t1}</td>
<td>${mark.q1}</td>
<td>${mark.a1}</td>
<td>${mark.total}</td>
<td>${mark.ext}</td>
<td>${mark.sem}</td>
<td><form action="DeleteStd">
<input type="hidden" name="id" value="${mark.subcode}">
<input type="hidden" name="tname" value="marks">
<input type="submit" value="Delete" class="dte">
</form></td>
</tr>
</c:forEach>
</table>
</div>
</div>
</div>
</body>
</html>