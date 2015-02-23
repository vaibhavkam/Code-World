<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Department</title>
</head>
<body>

	<h3>Enter Department Details</h3>
	<sf:form method="POST" commandName="department">
			<table style="width: 700;" border="1" align="left">
				<tr>
					<td>
						 <table style="width: 400" >
				 			<tr>
				 				<th><label for="name">Department Name</label></th>
				 				<td>
				 					<sf:input path="name" id="name"></sf:input>
				 					<sf:errors path="name"></sf:errors>
				 				</td>		
				 			</tr>
				 			<tr>
				 				<th><label for="businessUnit">Business Unit</label></th>
				 				<td>
				 					<sf:input path="businessUnit" id="businessUnit"></sf:input>
				 					<sf:errors path="businessUnit"></sf:errors>
				 				</td>		
				 			</tr>
				 			<tr>
				 				<th><label for="description">Work Description</label></th>
				 				<td>
				 					<sf:input path="description" id="description"></sf:input>
				 					<sf:errors path="description"></sf:errors>
				 				</td>		
				 			</tr>
				 		</table>	 		
					</td>
					<td>
						<table style="width: 300">
						<thead>
							<tr>
								<th><label for="employees">Employees</label></th>
							</tr>
						</thead>
				 			<c:forEach items="${employees}" var="employee">
				 			<tr>
				 				<td>
				 					<sf:checkbox value="${employee.id}" path="employees" label="${employee.firstName} ${employee.lastName}" id="employees"/>
				 				</td>
				 			</tr>
				 			</c:forEach>
						</table>
					</td>
				</tr>
				<tr>
				 	<td colspan="2" align="center">
				 		<input type="submit" value="Submit">
				 	</td>		
				 </tr>	
			</table>	 	
	</sf:form>
</body>
</html>