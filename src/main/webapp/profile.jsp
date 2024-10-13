<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>profile</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<%
if(session.getAttribute("rollno")==null){
	response.sendRedirect("login.jsp");
}
%> 
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
<div class="profile">
<div class="heading">
<h3>My Profile</h3>
</div>
<hr>
<div class="p-filed">
<label>Name : </label>
<input type=text value="${sname}" disabled>
</div>
<div class="p-filed">
<label>Roll no : </label>
<input type=text value="${rollno}" disabled>
</div>

<div class="p-filed">
<label>gender :</label>
<input type=text value="${gender}" disabled>
</div>

<div class="p-filed">
<label>Course :</label>
<input type=text value="${course}" disabled>
</div>

<div class="p-filed">
<label>Email : </label>
<input type=text value="${email}" disabled>
</div>

<div class="p-filed">
<label>Mobile : </label>
<input type=text value="0987654321" disabled>
</div>

</div>
</div>
</body>
</html>