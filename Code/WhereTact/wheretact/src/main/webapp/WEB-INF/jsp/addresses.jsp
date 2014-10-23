<%@page import="com.wheretact.models.Address"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wheretact.service.AddressService"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- pour faire fonctionner les <c forEach -->

<%@ include file="/WEB-INF/jsp/include/head.jsp"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>

<body>
	<div class="bodyContent">
		<div class="leftContent">

			<a href="/addresses/formCreateAddress" class="">Add Address</a> <br>
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
					<c:forEach items="${addressList}" var="address">
						<tr id="${address.addressId}">
							<td>${address.streetNumber}</td>
							<td>${address.street}</td>
							<td>${address.postcode}</td>
							<td>${address.city}</td>
							<td>${address.state}</td>
							<td>${address.country}</td>
							<td><a href="#"> supprimer</a></td>
							<td><a href="#"> voir le lieu</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="rightContent">
			<div class="address">

				<jsp:include page="/WEB-INF/jsp/include/showAddress.jsp">
					<jsp:param name="city" value="Paris" />
					<jsp:param name="state" value="Texas" />
					<jsp:param name="country" value="United States" />
					<jsp:param name="streetnumber" value="Joconde Street" />
					<jsp:param name="street" value="105" />
					<jsp:param name="postcode" value="77777" />
					<jsp:param name="contact" value="" />
				</jsp:include>
			</div>
		</div>
	</div>
	</div>
</body>
</html>