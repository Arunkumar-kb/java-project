<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<%
if(session.getAttribute("rollno")==null){
	response.sendRedirect("login.jsp");
}
%> 
<jsp:include page="adminHeader.jsp"></jsp:include>
<form action="Register" method="get">
<div class="container">
<div class="signup">
<div class="title">
<h3>Register</h3>
</div>

<div class="i-filed">
<label>student name :</label> 
<input type="text" name="sname">
</div>
<div class="i-filed">
<label>roll number :</label> 
<input type="text" name="rollno">
</div>
<div class="i-filed">
<label>email : </label>
<input type="email" name="email">
</div>
<div class="i-filed">
<label>mobile number :</label> 
<input type="text" name="mobile">
</div>
<div class="i-filed">
<label for="dept">course :</label> 
<select name="dept" id="dept">
<option value="MCA">MCA</option>
<option value="BCA">BCA</option>
</select>
</div>
<div class="i-filed">
<label>gender :</label> 
<div class="radio">
<input type="radio" name="gender" id="male" value="male">
<label for="male">Male</label>
<input type="radio" name="gender" id="female" value="female">
<label for="female">female</label>
</div>
</div>
<div class="i-filed">
<label>password :</label>
<input type="password" name="pwd">
</div>
<div class="btn">
<input type="submit" value="Add Student">
</div>
<div class="msg">
<% String errorMessage = request.getParameter("error"); %>
<% if (errorMessage != null) { %>
    <p style="color: red;"><%= errorMessage %></p>
<% } %>

<!-- <a href = "login.jsp">Already have an account ?</a> -->
</div>
</div>
</div>
</form>
</body>
</html>