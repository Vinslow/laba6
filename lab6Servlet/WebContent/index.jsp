<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lab 6 Servlet</title>

</head>
<body>
<h1 align="center">Loggining Page</h1>
<p style="color:aqua;"></font> <%= new java.util.Date() %></p>
<div id="action">
<form action="ApplicationServlet">
	Login<input type="text" name="login">
	<input type="submit" value="Login">
</form>
</div>


	}
</body>
</html>