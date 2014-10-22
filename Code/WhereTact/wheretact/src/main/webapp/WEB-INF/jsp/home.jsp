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
		<h4 id ="list">  <br>
		<%-- <p>${randomUserInfo}</p> --%>
		<br>
		<%-- <p>${angularTestContacts}</p>
		<br>
		
		<p>${angularTestAddresses}</p> --%>
		<br>
		
		<h2>Test Contacts</h2>
		<br>
		<p>${myList}</p>
		</h4>
	</div>

</body>
<%@ include file="/WEB-INF/jsp/include/footer.jsp"%>
</html>