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

<h1 align="center">Purchase History</h1>

<%List<PurchaseHistory> ph=(List<PurchaseHistory>)request.getAttribute("list"); %>
<table align="center" border="1">
<tr><th>category</th><th>size</th><th>name</th><th>email</th><th>date</th></tr>
<%if(ph != null){ %>
<%for(PurchaseHistory phph:ph){ %>
<tr><td><%=phph.getCategory()%></td><td><%=phph.getSize()%></td><td><%=phph.getName()%></td><td><%=phph.getEmail()%></td><td><%=phph.getDate()%></td>
</tr>
<%} %>
<%} %>

<form align = "center" action="adminback">
<button name = "Back" type = "submit" >Back</button>
</form>

</body>
</html>