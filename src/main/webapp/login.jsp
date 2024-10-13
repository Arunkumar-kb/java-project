<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel='stylesheet' href='style.css'>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form action="logIn" method="get">
<div class="container">
<div class="sign-in">
<div class="title">
<h3>login</h3>
</div>
<div class="i-filed">
<select name='utype'>
<option value='student'>student</option>
<option value='admin'>admin</option>
</select>
</div>

<div class="i-filed">
<label>user name : </label>
<input type="text" name="uname">
</div>

<div class="i-filed">
<label>password : </label>
<input type="password" name="pwd">
</div>
<div class="btn">
<input type="submit" value="login">
</div>
<div class="msg">
<%-- Retrieve the error parameter from the URL --%>
<% String errorMessage = request.getParameter("error"); %>

<%-- If there is an error message, display it --%>
<% if (errorMessage != null) { %>
    <p style="color: red;"><%= errorMessage %></p>
<% } %>

<!-- <a href="register.jsp">Register now....</a> -->
</div>
</div>
</div>
</form>
</body>
</html>