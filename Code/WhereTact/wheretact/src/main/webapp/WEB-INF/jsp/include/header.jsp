<%@page import="com.wheretact.service.AddressService"%>
<%@page import="com.wheretact.service.ContactService"%>
<header class="">
	<%
		ContactService headerContactService = new ContactService();
		AddressService headerAddressService = new AddressService();

		int totalContacts = headerContactService.getMapping().size();
		int totalAddresses = headerAddressService.getMapping().size();
	%>
	<div class="bannerBox">
		<img class="bannerLogo" src="/images/logo0_1.jpg">
		<h1 class="bannerTitle bannerBlock">Where Tact</h1>
		<p class="bannerSubtitle bannerBlock italic">Contacts and
			Addresses</p>
		<div class="dataInfo">
			<h5>
				Contacts :
				<%=String.valueOf(totalContacts)%></h5>
			<h5>
				Addresses :
				<%=String.valueOf(totalAddresses)%></h5>
		</div>
		
		<a href="/" class="divLink"></a>
	</div>

	<%@ include file="/WEB-INF/jsp/include/menu.jsp"%>

	
</header>