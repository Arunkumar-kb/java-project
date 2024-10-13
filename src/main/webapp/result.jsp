<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>student marks</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="t-body">
<div class="t-content">
<div class="t-title">
<h1>student marks</h1>
</div>
<div class="sem">
<form action="showResult">
<label>Semester</label>
<%
String option = (String) request.getAttribute("sem");
%>
<select name="sem" onchange="this.form.submit()">
<option value="" selected disabled>Select</option>
<option value="1" <%= "1".equals(option) ? "selected" : "" %>>1</option>
<option value="2" <%= "2".equals(option) ? "selected" : "" %>>2</option>
<option value="3" <%= "3".equals(option) ? "selected" : "" %>>3</option>
<option value="4" <%= "4".equals(option) ? "selected" : "" %>>4</option>
</select>
</form>
</div>
<% 
String s = request.getAttribute("Listsize").toString();
int lsize = Integer.parseInt(s);
if(lsize > 0){
%>
<div class="t-data">
<table border="1">
<tr>
<th>SUB-CODE</th>
<th>SUB-NAME</th>
<th>T-1</th>
<th>Q-1</th>
<th>A-1</th>
<th>TOTAL</th>
<th>EXT</th>
</tr>
<c:forEach var="mark" items="${Marklist}">
<tr>
<td>${mark.sub_code}</td>
<td>${mark.sub_name}</td>
<td>${mark.t_1}</td>
<td>${mark.q_1}</td>
<td>${mark.a_1}</td>
<td>${mark.total}</td>
<td>${mark.ext}</td>
</tr>
</c:forEach>
</table>
</div>
<%} else { %>
<% if(!"0".equals(option)){ %>
<p class="msg">No data found...</p>
<%}%><%} %>
</div>
</div>
</body>
</html>