<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Page</title>
<!-- <link type="text/css" rel="stylesheet" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="../css/style.css" /> -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - CUSTOMER RELATIONSHIP MANAGER</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<!-- put new button: Add Customer -->
			<!-- <input type="button" value="Add customer"
				onclick="window.location.href='/CRM/customer/showForm'; return false;" class="add-button" />
				works for all and specially needed if jsp:forward is used -->

			<input type="button" value="Add customer"
				onclick="window.location.href='./showForm'; return false;"
				class="add-button" />
			<table border="1">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="customer" items="${customerList}">
					<c:url var="updateLink" value="./showUpdateForm">
						<c:param name="customerId" value="${customer.id}" />
					</c:url>
					<c:url var="deleteLink" value="./showDeleteForm">
						<c:param name="customerId" value="${customer.id}" />
					</c:url>
					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td><a href="${updateLink}">UPDATE</a> | <a
							href="${deleteLink}"
							onclick="if(!confirm('Are you sure you want to delete this customer?')) return false;">DELETE</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>