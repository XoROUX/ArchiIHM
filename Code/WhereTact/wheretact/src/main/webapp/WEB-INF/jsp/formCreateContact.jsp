<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/WEB-INF/jsp/include/head.jsp"%>
<body>
	<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
	<div class="bodyContent">
		<form action="/contacts/createContact" method="post">
			<h1>Create Contact</h1>

			<p>First Name :</p>
			<input maxlength="50" name="firstname" size="20" type="text" />
			<p>Last Name :</p>
			<input maxlength="50" name="lastname" size="20" type="text" />
			<p>Email :</p>
			<input maxlength="50" name="email" size="20" type="text" />
			<p>Phone Number :</p>
			<input maxlength="50" name="phoneNumber" size="20" type="text" />
			<p>Birthdate :</p>
			<input maxlength="50" name="birthdate" size="20" type="text" /> <input
				class="ok" name="commit" type="submit" value="OK" />
		</form>
	</div>
</body>
</html>
