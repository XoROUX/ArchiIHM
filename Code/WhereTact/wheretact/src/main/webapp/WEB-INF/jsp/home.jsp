<%@page import="com.wheretact.models.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wheretact.service.ContactService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Where Tact</title>
</head>
<body>
	<h1>Where Tact Home</h1>
	<br>
	<br>
	<P>The time on the server is ${serverTime}.</P>
	<br>
	<br>
	<p>${randomUserInfo}</p>

	<br>
	<br>

	<h2>Read between the lines</h2>
	<p>Now ... :</p>
	<br>
	<p>${myList}</p>


</body>
</html>