<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.CrudDemo.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Details</title>
</head>
<body>
<%
Employee e = new Employee();
e = (Employee) request.getAttribute("EmpDetails");
%>
<form action="UpdateEmp" method="get">
<input type="hidden" name="id" value="<%= e.getId()%>"><br>
<br>
Update Name:<input type="text" name="name" value="<%= e.getName()%>"><br>
<br>
Update City:<input type="text" name="city" value="<%= e.getCity()%>"><br>
<br>
<input type="submit" value="Update">
</form>
</body>
</html>