<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Customer</title>
<link type='text/css' rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link type='text/css' rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/addCustomer.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h3>CRM - Customer Relationship Management</h3>
		</div>
	</div>
	<div id="container">
		<h3>Save Customer</h3>
		<form:form modelAttribute="customer" action="saveCustomer"
			method="POST">
			<table>
				<tbody>
					<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Add Customer" class="save">
						</td>
					</tr>
				</tbody>
			</table>
		</form:form>
		
		<div style="clear; both;"></div>
		
		<p><a href="${pageContext.request.contextPath}/customer/list">Return to list</a></p>
	</div>
</body>
</html>