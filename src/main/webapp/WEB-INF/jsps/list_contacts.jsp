<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file ="menu.jsp" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>contacts</title>
</head>
<body>

<h2>ALL CONTACTS</h2>

  
  <table>
      <tr>
          <th>FirstName</th>
          <th>LastName</th>
          <th>Email</th>
           <th>Mobile</th>
           <th>Source</th>
           <th>Billing</th>
         
      </tr>
  
  <c:forEach var = "lead" items = "${contacts}">
         <tr>
          <td>${lead.firstName}</td>
          <td>${lead.lastName}</td>
          <td>${lead.email}</td>
          <td>${lead.mobile}</td>
          <td>${lead.source}</td>
          <td><a href = "generateBill?id=${lead.id}">Billing</a></td>
      </tr>
  
 </c:forEach>
  
  </table>
</body>
</html>