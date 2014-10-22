<%@page import="com.wheretact.models.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wheretact.service.ContactService"%>

<%@ include file="/WEB-INF/jsp/include/head.jsp"%>

<%@ include file="/WEB-INF/jsp/include/header.jsp"%>


<body>

	<div class="bodyContent">              
		<h2 id="nb">Contacts : ${totalContacts}		      Addresses : ${totalAddresses}</h2>
		<h3 class="italic">Time on server is ${serverTime}.</h3>

		<%-- <p>${randomUserInfo}</p> --%>
		<%-- <p>${angularTestContacts}</p>
		<br>
		<p>${angularTestAddresses}</p> --%>
		
		<br>
		<p id="listContact">${myList}</p>
	</div>
</body>
<%@ include file="/WEB-INF/jsp/include/footer.jsp"%>
</html>