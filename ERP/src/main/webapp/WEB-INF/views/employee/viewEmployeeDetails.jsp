<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Information</title>
</head>
<body>
	<h2>Hello ${employee.firstName} !!! information details are successfully saved </h2>
	<table>
		<tr>
			<th>First Name</th>
			<td>${employee.firstName}</td>
		</tr>
		<tr>
			<th>Last Name</th>
			<td>${employee.lastName}</td>
		</tr>
		<tr>
			<th>Mobile</th>
			<td>${employee.mobile}</td>
		</tr>
	</table>
</body>
</html>