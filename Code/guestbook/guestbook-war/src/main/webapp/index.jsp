<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="/stylesheets/main.css"/>
</head>

<body>

<% 
	int counter = 0;
	
	
%>

<h1>Where Tact</h1>
<br />
<h2>Counter = <%= counter%></h2>

<form action="/index.jsp" method="get">
    <div><input type="text" name="value" /></div>
    <div><input type="submit" value="Add Value"/></div>
</form>

<!-- value="${fn:escapeXml(guestbookName)}" -->
</body>
</html>