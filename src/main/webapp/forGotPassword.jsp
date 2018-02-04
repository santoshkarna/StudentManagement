<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<br>
	<br>
	<div class="container">
		<form class="form-horizontal" action="ForgotPassword" method="post">
			<span style="color: red">${emailNotFound}</span>
			<div class="form-group row">
				<label for="staticEmail1" class="sr-only">Email</label> <input
					type="text" class="form-control" id="staticEmail1" name="email">
			</div>
			<button type="submit" class="btn btn-primary">Send</button>
		</form>
	</div>
</body>
</html>