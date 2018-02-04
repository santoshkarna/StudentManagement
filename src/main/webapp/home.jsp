<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="javax.swing.JFrame"%>
<%@page import="javax.swing.JButton"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<%@ include file="header.jsp"%>
<style type="text/css">
body {
	background-image: url('resources/images/university.jpg');
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<div class="alert alert-warning alert-dismissible fade show"
		role="alert">
		<strong>Welcome to my page!</strong> ${username}
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
</body>
</html>