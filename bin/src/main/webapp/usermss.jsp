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

<h1 align="center">Mens Stylish Shoes</h1>
<h2 align="center">Choose a shoe to buy</h2>

<%List<Mens_Stylish_Shoes> ms=(List<Mens_Stylish_Shoes>)request.getAttribute("list"); %>
<table align="center" border="1">
<tr><th>size</th><th>quantity</th></tr>
<%if(ms != null){ %>
<%for(Mens_Stylish_Shoes msms:ms){ %>
<tr><td><%=msms.getSize() %></td><td><%=msms.getQuantity() %></td><td><form action="purchase/mss/<%=msms.getSize()%>">
<button name = "Buy" type = "submit" >Buy</button>
</form></td></tr>
<%} %>
<%} %>

<form align = "center" action="userback">
<button name = "Back" type = "submit" >Back</button>
</form>

</body>
</html>