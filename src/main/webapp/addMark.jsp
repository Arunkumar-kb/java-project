<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Marks</title>
</head>
<body>
<%
if(session.getAttribute("rollno")==null){
	response.sendRedirect("login.jsp");
}
%> 
<jsp:include page="adminHeader.jsp"></jsp:include>
<form action="AddMark" method="get">
<div class="container">
<div class="signup">
<div class="title">
<h3>Add Student Mark</h3>
</div>
<div class="i-filed">
<label>Semester :</label>
<select name = "sem" id="dept">
<option value="0" disabled selected></option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
</select>
</div>
<div class="i-filed">
<label>roll number :</label> 
<input type="text" name="rollno" required>
</div>
<div class="i-filed">
<label>sub-code : </label>
<input type="text" name="subcode" required>
</div>
<div class="i-filed">
<label>sub-name : </label>
<input type="text" name="subname" required>
</div>
<div class="i-filed">
<label>test-1 : </label>
<input type="number" name="t1" min="0" max="30">
</div>
<div class="i-filed">
<label>assignment-1 :</label> 
<input type="number" name="a1" min="0" max="10">
</div>
<div class="i-filed">
<label>quiz-1 :</label>
<input type="number" name="q1" min="0" max="10">
</div>
<div class="i-filed">
<label>external :</label>
<input type="number" name="ext" min="0" max="75">
</div>
<div class="btn">
<input type="submit" value="Add Mark">
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