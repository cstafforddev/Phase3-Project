<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.example.demo.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 align="center">Display Users</h1>

<%List<User> u=(List<User>)request.getAttribute("list"); %>
<table align="center" border="1">
<tr><th>name</th><th>email</th><th>password</th></tr>
<%if(u != null){ %>
<%for(User uu:u){ %>
<tr><td><%=uu.getName() %></td><td><%=uu.getEmail() %></td><td><%=uu.getPassword() %></td></tr>
<%} %>
<%} %>
</table>

<form align = "center" action="adminback">
<button name = "Back" type = "submit" >Back</button>
</form>

</body>
</html>