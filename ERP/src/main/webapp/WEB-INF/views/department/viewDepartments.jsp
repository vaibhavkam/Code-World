<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Department Details</title>
</head>
<body>
	<h3>Department Details</h3>
	<table style="width: 600;" border="1" align="center">
	
	<c:choose>
    	<c:when test="${fn:length(departments) gt 0}">
    	<tr>
			<th width="20%">Department Name</th>
			<th width="20%">Business Unit</th>
			<th width="20%">Work Description</th>
			<th width="10%">Employees</th>
			<th width="30%">Action</th>			
		</tr>
		<c:forEach items="${departments}" var="department">
		<tr>
			<td>${department.name}</td>
			<td>${department.businessUnit}</td>
			<td>${department.description}</td>
			<td align="center">
				<c:choose>
			    <c:when test="${fn:length(department.employees) gt 0}">
					<c:url var="departmentEmployeeUrl" value="/department/viewDepartmentEmployees" />
					<a href="${departmentEmployeeUrl}?id=${department.id}">${fn:length(department.employees)}</a>
				</c:when>
      			<c:otherwise>
      				No Employee Alloted
      			</c:otherwise>
      			</c:choose>
			</td>
			<td align="center">
				<c:url var="editUrl" value="/department/editDepartment" />
				<a href="${editUrl}?id=${department.id}">Edit</a>
				<c:url var="deleteUrl" value="/department/deleteDepartment" />
				<a href="${deleteUrl}?id=${department.id}">Delete</a>
			</td>
		</tr>
		</c:forEach>
      	</c:when>
      	<c:otherwise>
      	<tr>
			<td>No Department registered</td>
		</tr>
      	
      	</c:otherwise>
	</c:choose>
		<tr>
			<td colspan="5" align="center">
				<sf:form method="POST">
				 	<input type="submit" value="Add New Department" >
				</sf:form>
			</td>		
		</tr>	
	</table>
</body>
</html>