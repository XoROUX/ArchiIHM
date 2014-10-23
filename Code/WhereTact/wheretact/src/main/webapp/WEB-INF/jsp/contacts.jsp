<%@page import="com.wheretact.models.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wheretact.service.ContactService"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- pour faire fonctionner les <c forEach -->

<%@ include file="/WEB-INF/jsp/include/head.jsp"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>

<%-- <script>
	rowClick(<%=request.getAttribute("contact.contactId")%>);
</script> --%>

<body>
	<br>
	<div class="bodyContent">
		<div class="leftContent">
			<table>
				<thead>
					<tr>
						<th>Lastname</th>
						<th>Firstname</th>
						<th>Email</th>
						<th>Phone</th>
						<th>Born</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${contactList}" var="contact">

						<tr class="contactRow" id="${contact.contactId}">

							<td class="lastname">${contact.lastname}</td>
							<td>${contact.firstname}</td>
							<td>${contact.email}</td>
							<td>${contact.phoneNumber}</td>
							<td>${contact.birthdate}</td>
							<td><a href="#"> supprimer</a></td>
							<td><a href="#"> voir le contact</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="rightContent">
			<div class="contact">

				<jsp:include page="/WEB-INF/jsp/include/showContact.jsp">
					<jsp:param name="firstname" value="Alban" />
					<jsp:param name="lastname" value="Mani" />
					<jsp:param name="email" value="Alban.Mani@mail.com" />
					<jsp:param name="birthdate"
						value="08/08/90" />
					<jsp:param name="phonenumber"
						value="0600000000" />
				</jsp:include>
			</div>
		</div>
	</div>
</body>
</html>