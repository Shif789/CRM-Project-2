<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Page</title>
</head>
<body>
	<!-- <a href="./list">click the link</a> -->
	<%-- <jsp:forward page="/customer/list" /> for add button in "list-customers" page if full path url is not given then it adds up--%>
	<% response.sendRedirect("customer/list"); %>
</body>
</html>