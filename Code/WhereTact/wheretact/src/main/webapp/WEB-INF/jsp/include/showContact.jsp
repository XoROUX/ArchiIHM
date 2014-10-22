<div class="contactBox border">
	<h4>CONTACT TEST</h4>
	<h5 class="contactTitle">${param.firstname} ${param.lastname}</h5>
	<p> Phone: ${param.phonenumber} </p>
	<p> E-mail: ${param.email}</p><br>
	<p> Born: ${param.birthdate}</p><br>
	
	<%
		String billingAddress = request.getParameter("billingAddress");
		if(billingAddress != null && billingAddress != ""){
	%>
		<p> Billing Address : <%= billingAddress %> </p>
	<%
	
		}
	%>
	
	
	<%
		String addresses = request.getParameter("addresses");
		if(addresses != null && addresses != ""){
	%>
		<p> Addresses : <%= addresses %> </p>
	<%
	
		}
	%>
</div>