<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
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
<h1>Student Details</h1>
</div>
<div class="t-data">
<table border=1>
<tr>
<th>Student Name</th>
<th>Roll Number</th>
<th>Email</th>
<th>Mobile</th>
<th>Course</th>
<th>Gender</th>
<th>Action</th>
</tr>
<c:forEach var="student" items="${studentList}">
<tr>
<td>${student.sname}</td>
<td>${student.rollno}</td>
<td>${student.email}</td>
<td>${student.mobile}</td>
<td>${student.course}</td>
<td>${student.gender}</td>
<td><form action="DeleteStd">
<input type="hidden" name="id" value="${student.rollno}">
<input type="hidden" name="tname" value="student">
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