<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/WEB-INF/jsp/include/head.jsp"%>
<body>
	<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
	<div class="bodyContent">
		<form action="/addresses/createAddress" method="post">
			<h1>Create Address</h1>

			<p>Number :</p>
			<input maxlength="50" name="streetNumber" size="20" type="text" />
			<p>Street :</p>
			<input maxlength="50" name="street" size="20" type="text" />
			<p>Postcode :</p>
			<input maxlength="50" name="birthdate" size="20" type="text" />
			<p>City :</p>
			<input maxlength="50" name="city" size="20" type="text" />
			<p>State:</p>
			<input maxlength="50" name="phoneNumber" size="20" type="text" />
			<p>Country:</p>
			<input maxlength="50" name="birthdate" size="20" type="text" /> <input
				class="ok" name="commit" type="submit" value="OK" />
		</form>
	</div>
</body>
</html>
