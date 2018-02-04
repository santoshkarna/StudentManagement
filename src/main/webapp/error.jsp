<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
<%@ page isErrorPage="true"%>
<%@ include file="header.jsp"%>
</head>
<body>
	<%
		out.println("<h1>");
		out.println("Exception is: " + exception);
		out.println("</h1>");
	%>
</body>
</html>