<div class="addressBox">
	<h4>ADDRESS TEST</h4>
	<h5 class="addressTitle">${param.city} ${param.state} ${param.country}</h5>
	<p> ${param.streetnumber}, ${param.street} </p>
	<p> ${param.postcode}</p><br>
	
	<%
		String contactParam = request.getParameter("contact");
		if(contactParam != null && contactParam != ""){
	%>
		<p> <%= contactParam %> </p>
	<%
	
		}
	%>
</div>
