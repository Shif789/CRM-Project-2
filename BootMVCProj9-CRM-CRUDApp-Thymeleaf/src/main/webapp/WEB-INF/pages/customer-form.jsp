<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Save Customer Page</title>
<!-- <link type="text/css" rel="stylesheet" href="../css/style.css" />
<link type="text/css" rel="stylesheet"
	href="../css/add-customer-style.css" /> -->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/add-customer-style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - CUSTOMER RELATIONSHIP MANAGER</h2>
		</div>
	</div>
	<div id="container">
		<h3>ADD NEW CUSTOMER</h3>
		<!-- action="/CRM/customer/saveCustomer"  //both are same-->
		<form:form action="./saveCustomer" method="post" modelAttribute="cstmr">
			
			<!-- need to associate this data with customer id -->
			<form:hidden path="id"/>
			
			<table>
				<tbody>
					<tr>
						<td><label for="firstName">First Name:</label></td>
						<td><form:input path="firstName"
								placeholder="enter string firstname" /></td>
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="lastName"
								placeholder="enter string lastname" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" placeholder="enter string email" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>
	
	<div style="clear: both;">
		<p>
		<a href="./list">Back to List</a>
		</p>
	</div>
</body>
</html>