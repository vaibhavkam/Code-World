<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Departments alloted to ${employee.firstName}</title>
</head>
<body>

	<h3>Departments alloted to ${employee.firstName}</h3>

	<table style="width: 600" border="1">
	
	<c:choose>
    	<c:when test="${fn:length(employee.departments) gt 0}">
    	<tr>
			<th width="30%">Department Name</th>
			<th width="30%">Business Unit</th>
			<th width="40%">Work Description</th>
			
		</tr>
		<c:forEach items="${employee.departments}" var="department">
		<tr>
			<td>${department.name}</td>
			<td>${department.businessUnit}</td>
			<td>${department.description}</td>
		</tr>
		</c:forEach>
      	</c:when>
      	<c:otherwise>
      	<tr>
			<td>No department alloted</td>
		</tr>
      	</c:otherwise>
	</c:choose>
	</table>
</body>
</html>