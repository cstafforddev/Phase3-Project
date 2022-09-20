<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home Screen</title>
</head>
<body>	

<h1 align="center">Admin Homescreen</h1>

<p align="center"><a href="./getusers" style="font-size:25px;">View All Users</a></p>
<p align="center"><a href="./purchhist" style="font-size:25px;">View Purchase History</a></p>
<p align="center"><a href="./editinven" style="font-size:25px;">Edit Inventory</a></p>
<p align="center"><a href="./getnewpassword" style="font-size:25px;">Change Password</a></p>

<form align = "center" action="/logout">
<button name = "Logout" type = "submit" >Logout</button>
</form>
</body>
</html>