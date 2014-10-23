<div class="contactBox">
	<h4 class="contactTitle">${param.firstname} ${param.lastname}</h4>
	<p> Phone: ${param.phonenumber} </p>
	<p> E-mail: ${param.email}</p><br>
	<p> Born: ${param.birthdate}</p><br>
	
	<%
		String billingAddress = request.getParameter("billingAddress");
		if(billingAddress != null && billingAddress != "" && billingAddress != "null"){
	%>
		<p> Billing Address : <%= billingAddress %> </p>
	<%
	
		}
	%>
	
	
	<%
		String addresses = request.getParameter("addresses");
		if(addresses != null && addresses != "" && addresses != "null"){
	%>
		<p> Addresses : <%= addresses %> </p>
	<%
	
		}
	%>
</div>