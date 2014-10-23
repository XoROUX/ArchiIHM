<%@page import="com.wheretact.models.Address"%>
<%@page import="com.wheretact.service.AddressService"%>
<%@page import="com.wheretact.models.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wheretact.service.ContactService"%>

<%@ include file="/WEB-INF/jsp/include/head.jsp"%>

<%@ include file="/WEB-INF/jsp/include/header.jsp"%>

<%
	ContactService contactService = new ContactService();
	AddressService addressService = new AddressService();
	ArrayList<Contact> contactArray = contactService.readAll();
%>


<body>


	<div class="bodyContent">
		<br>
		<h1>Where Tact Home</h1>
		<br>
		
		<br>
		<h3 class="italic">The time on the server is ${serverTime}.</h3>

		<a href="/sample">Link to sample</a> <br>
		<br>

		<%
			if (contactArray.size() == 0) {
		%>
		<p>No Contact</p>
		<%
			} else {
				for (Contact c : contactArray) {
		%>
		<div class="contact">
			<jsp:include page="/WEB-INF/jsp/include/showContact.jsp">
				<jsp:param name="firstname" value="<%=c.getFirstname()%>" />
				<jsp:param name="lastname" value="<%=c.getLastname()%>" />
				<jsp:param name="email" value="<%=c.getEmail()%>" />
				<jsp:param name="birthdate" value="<%=c.getBirthdate().toString()%>" />
				<jsp:param name="phonenumber"
					value="<%=String.valueOf(c.getPhoneNumber())%>" />
			</jsp:include>
		</div>
		<%--<jsp:param name="billingAddress" value="<%=c.getBillingAddress() %>" />
						<jsp:param name="addresses" value="<%=c.getAddressList().toString() %>" /> --%>
		<%
			for (Address a : c.getAddressList().values()) {
		%>
		<div class="address">
			<jsp:include page="/WEB-INF/jsp/include/showAddress.jsp">
				<jsp:param name="city" value="<%=a.getCity()%>" />
				<jsp:param name="state" value="<%=a.getState()%>" />
				<jsp:param name="country" value="<%=a.getCountry()%>" />
				<jsp:param name="streetnumber" value="<%=String.valueOf(a.getStreetNumber())%>" />
				<jsp:param name="street" value="<%=a.getStreet()%>" />
				<jsp:param name="postcode" value="<%=a.getPostcode()%>" />
				<jsp:param name="contact" value="" />
			</jsp:include>
		</div>
		<%
			}
		%>
		<br><hr><br>
		<%
			}
			}
		%>
		<br>
		<%-- <p id="listContact">${myList}</p> --%>

	</div>
</body>
<%@ include file="/WEB-INF/jsp/include/footer.jsp"%>
</html>