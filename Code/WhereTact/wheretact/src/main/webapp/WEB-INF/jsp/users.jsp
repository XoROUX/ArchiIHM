<%@page import="com.wheretact.models.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wheretact.service.ContactService"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- pour faire fonctionner les <c forEach -->

<%@ include file="/WEB-INF/jsp/include/head.jsp"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>		

<body>
<br>
    <table>
      <thead>
        <tr>
          <th>Nom</th>
          <th>prenom</th>
          <th>email</th>
          <th>telephone</th>
          <th>date de naissance</th>
        </tr>
      </thead>

      <tbody>
        <c:forEach items="${contactList}" var="contact">
        <tr>
          <td>${contact.lastname}</td>
          <td>${contact.firstname}</td>
          <td>${contact.email}</td>
          <td>${contact.phoneNumber}</td>
          <td>${contact.birthdate}</td>
          <td><a href="#"> supprimer</a></td>
          <td><a href="#"> voir le contact</a></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>