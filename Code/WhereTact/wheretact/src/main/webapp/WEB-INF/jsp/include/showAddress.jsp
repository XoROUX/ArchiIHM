<div class="addressBox">
	<h4 class="addressTitle">${param.city} ${param.state} ${param.country}</h4>
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
