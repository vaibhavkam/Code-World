<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
	<h3>Employee Details</h3>
	<table style="width: 600;" border="1" align="center">
	
	<c:choose>
    	<c:when test="${fn:length(employees) gt 0}">
    	<tr>
			<th width="20%">First Name</th>
			<th width="20%">Last Name</th>
			<th width="20%">Mobile</th>
			<th width="10%">Departments</th>
			<th width="30%">Action</th>			
		</tr>
		<c:forEach items="${employees}" var="employee">
		<tr>
			<td>${employee.firstName}</td>
			<td>${employee.lastName}</td>
			<td align="center">${employee.mobile}</td>
			<td align="center">
				<c:choose>
			    <c:when test="${fn:length(employee.departments) gt 0}">
					<c:url var="employeeDepartmentUrl" value="/employee/viewEmployeeDepartments" />
					<a href="${employeeDepartmentUrl}?id=${employee.id}">${fn:length(employee.departments)}</a>
				</c:when>
      			<c:otherwise>
      				No Department Alloted
      			</c:otherwise>
      			</c:choose>
			</td>
			<td align="center">
				<c:url var="editUrl" value="/employee/editEmployee" />
				<a href="${editUrl}?id=${employee.id}">Edit</a>
				<c:url var="deleteUrl" value="/employee/deleteEmployee" />
				<a href="${deleteUrl}?id=${employee.id}">Delete</a>
			</td>
		</tr>
		</c:forEach>
      	</c:when>
      	<c:otherwise>
      	<tr>
			<td>No employee registered</td>
		</tr>
      	
      	</c:otherwise>
	</c:choose>
		<tr>
			<td colspan="5" align="center">
				<sf:form method="POST">
				 	<input type="submit" value="Add New Employee" >
				</sf:form>
			</td>		
		</tr>	
	</table>
</body>
</html>