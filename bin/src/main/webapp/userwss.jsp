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

<h1 align="center">Womens Stylish Shoes</h1>
<h2 align="center">Choose a shoe to buy</h2>

<%List<Womens_Stylish_Shoes> ws=(List<Womens_Stylish_Shoes>)request.getAttribute("list"); %>
<table align="center" border="1">
<tr><th>size</th><th>quantity</th></tr>
<%if(ws != null){ %>
<%for(Womens_Stylish_Shoes wsws:ws){ %>
<tr><td><%=wsws.getSize() %></td><td><%=wsws.getQuantity() %></td><td><form action="purchase/wss/<%=wsws.getSize()%>">
<button name = "Buy" type = "submit" >Buy</button>
</form></td></tr>
<%} %>
<%} %>

<form align = "center" action="userback">
<button name = "Back" type = "submit" >Back</button>
</form>

</body>
</html>