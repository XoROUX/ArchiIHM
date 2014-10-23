<%@page import="com.wheretact.models.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wheretact.service.ContactService"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- pour faire fonctionner les <c forEach -->

<%@ include file="/WEB-INF/jsp/include/head.jsp"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>

<body>
	<div class="bodyContent">
		<br>
		<table>
			<thead>
				<tr>
					<th>Number</th>
					<th>Street</th>
					<th>Postcode</th>
					<th>City</th>
					<th>State</th>
					<th>Country</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${contactList}" var="contact">
					<tr>
						<td>${contact.streetNumber}</td>
						<td>${contact.street}</td>
						<td>${contact.postcode}</td>
						<td>${contact.city}</td>
						<td>${contact.state}</td>
						<td>${contact.coutry}</td>
						<td><a href="#"> supprimer</a></td>
						<td><a href="#"> voir le lieu</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>