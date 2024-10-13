<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel='stylesheet' href='style.css'>
</head>
<body>
<nav class="nav-bar">
		<div class="logo">the american college</div>
		<ul class="nav-links">
			<li><a href="#">Home</a></li>
			<li><a href="register.jsp">Add Student</a></li>
			<li><a href="addMark.jsp">Add Marks</a></li>
			<li><a href='viewStudent'>view Students</a></li>
			<li><a href='ViewMarks'>view marks</a></li>
			<%if(session.getAttribute("rollno")==null){%>
				<li><a href="login.jsp">Login</a></li>
			<%} else {%>
				<li><a href="logout.jsp">Logout</a></li>
				
			<%}%>
		</ul>
	</nav>
</body>
</html>