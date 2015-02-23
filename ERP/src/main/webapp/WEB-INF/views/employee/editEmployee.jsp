<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Employee</title>
</head>
<body>
	<h3>Edit Employee Details</h3>
	<sf:form method="POST" commandName="employee">
			<table style="width: 700;" border="1" align="left">
				<tr>
					<td>
						 <table style="width: 400" >
				 			<tr>
				 				<th><label for="firstName">First Name</label></th>
				 				<td>
				 					<sf:input path="firstName" id="firstName"></sf:input>
				 					<sf:errors path="firstName"></sf:errors>
				 				</td>		
				 			</tr>
				 			<tr>
				 				<th><label for="lastName">Last Name</label></th>
				 				<td>
				 					<sf:input path="lastName" id="lastName"></sf:input>
				 					<sf:errors path="lastName"></sf:errors>
				 				</td>		
				 			</tr>
				 			<tr>
				 				<th><label for="mobile">Mobile</label></th>
				 				<td>
				 					<sf:input path="mobile" id="mobile"></sf:input>
				 					<sf:errors path="mobile"></sf:errors>
				 				</td>		
				 			</tr>
				 		</table>	 		
					</td>
					<td>
						<table style="width: 300">
						<thead>
							<tr>
								<th><label for="departments">Departments</label></th>
							</tr>
						</thead>
				 			<tr>
				 				<td>
						 			<sf:checkboxes path="departments" items="${departmentList}" itemLabel="name" itemValue="id"/>
				 				</td>
				 			</tr>
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