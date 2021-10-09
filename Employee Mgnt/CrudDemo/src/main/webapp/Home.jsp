<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet,com.CrudDemo.dao.EmpDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<input type="button" onclick="window.location.href='Add-Employee.jsp';return false;" value="Add Employee"><br>
<br>
<table border="1">
<tr>
<th>Id</th>
<th>Name</th>
<th>City</th>
<th>Salary</th>
<th>Action</th>
</tr>
<%
EmpDao dao = new EmpDao();
ResultSet rs1 = dao.getEmployee();
while(rs1.next()){
%>
<tr>
<td><%= rs1.getInt(1) %></td>
<td><%= rs1.getString(2) %></td>
<td><%= rs1.getString(3) %></td>
<td><%= rs1.getFloat(4) %></td>
<td><a href="BeforeUpdate?id=<%=rs1.getInt(1)%>">Update</a></td>|<td><a href="DeleteEmp?id=<%=rs1.getInt(1)%>">Delete</a></td>
</tr>
<% } %>
</table>
</body>
</html>