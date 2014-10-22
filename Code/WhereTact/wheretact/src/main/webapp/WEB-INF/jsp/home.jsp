<%@page import="com.wheretact.models.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wheretact.service.ContactService"%>

<%@ include file="/WEB-INF/jsp/include/head.jsp"%>

<%@ include file="/WEB-INF/jsp/include/header.jsp"%>


<body>

	<div class="bodyContent">
		<br>
		<h1>Where Tact Home</h1>
		<br>
		<h2>Contacts : ${totalContacts}</h2>
		<br>
		<h2>Addresses : ${totalAddresses}</h2>
		<br>
		<h3 class="italic">The time on the server is ${serverTime}.</h3>

		<a href="/sample">Link to sample</a> <br>
		<h4 id="list"></h4>
		<br>
		<%-- <p>${randomUserInfo}</p> --%>
		<br>
		<%-- <p>${angularTestContacts}</p>
		<br>
		
		<p>${angularTestAddresses}</p> --%>
		<br>

		<h2>Test Zone</h2>
		<br>
		<%-- <p>${myList}</p> --%>

		<jsp:include page="/WEB-INF/jsp/include/showContact.jsp">
			<jsp:param name="firstname" value="John" />
			<jsp:param name="lastname" value="Snow" />
			<jsp:param name="phonenumber" value="0101010101" />
			<jsp:param name="email" value="3" />
			<jsp:param name="birthdate" value="06/06/06" />
			<jsp:param name="billingAddress" value="bill" />
			<jsp:param name="addresses" value="addr" />
		</jsp:include>
		
		<jsp:include page="/WEB-INF/jsp/include/showAddress.jsp">
			<jsp:param name="city" value="The Wall" />
			<jsp:param name="state" value="" />
			<jsp:param name="country" value="North" />
			<jsp:param name="streetnumber" value="3" />
			<jsp:param name="street" value="Wall street" />
			<jsp:param name="postcode" value="90001" />
			<jsp:param name="contact" value="testContact" />
		</jsp:include>

	</div>

</body>
<%@ include file="/WEB-INF/jsp/include/footer.jsp"%>
</html>