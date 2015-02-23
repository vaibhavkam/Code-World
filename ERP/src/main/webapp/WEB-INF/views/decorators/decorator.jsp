<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link rel="stylesheet" type="text/css" href="/ERP/resources/styles/style.css"/>
        <link rel="stylesheet" type="text/css" href="/ERP/resources/styles/themes/base/jquery-ui.css" />
        <script type="text/javascript" src="/ERP/resources/javascript/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="/ERP/resources/javascript/jquery-ui.1.8.2.min.js"></script>
        <sitemesh:write property='head' />
    </head>
    <body>
		<div id="bodyWrapper">
		    <div id="header">
		        Enterprise Resource Planning
		    </div>
		    <div id="navigation">
		        <a href="#">HOME</a>
		        <a href="#">ABOUT</a>
		    </div>
		    <div id="pageBody">
		        <div id="sidebar">
		            <a href="/ERP/employee/viewAll">Manage Employees</a><br/>
		            <a href="/ERP/department/viewAll">Manage Departments</a><br/>
		        </div>
		        <div id="content">
					<sitemesh:write property='body' />
				</div>
		    </div>
		    <div id="footer">
		        By Vaibhav
		    </div>
		</div>
    </body>
</html> 