<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees alloted to ${department.name}</title>
</head>
<body>

	<h3>Employees alloted to ${department.name} department</h3>
	<table style="width: 600" border="1">
	
	<c:choose>
    	<c:when test="${fn:length(department.employees) gt 0}">
    	<tr>
			<th width="30%">First Name</th>
			<th width="30%">Last Name</th>
			<th width="40%">Mobile</th>
		</tr>
		<c:forEach items="${department.employees}" var="employee">
		<tr>
			<td>${employee.firstName}</td>
			<td>${employee.lastName}</td>
			<td>${employee.mobile}</td>
			
		</tr>
		</c:forEach>
      	</c:when>
      	<c:otherwise>
      	<tr>
			<td>No employee alloted</td>
		</tr>
      	</c:otherwise>
	</c:choose>
	</table>
</body>
</html>