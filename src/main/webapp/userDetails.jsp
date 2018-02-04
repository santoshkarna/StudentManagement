<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Details</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<a href="UserController?actions=user_new">New User</a>
	<c:if test="${!empty users}">
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">User Id</th>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Dob</th>
					<th scope="col">Email</th>
					<th scope="col">userName</th>
					<th scope="col">password</th>
					<th scope="col">Gender</th>
					<th scope="col">Photo</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<th scope="row">1</th>
						<td><c:out value="${user.id}" /></td>
						<td><c:out value="${user.firstName}" /></td>
						<td><c:out value="${user.lastName}" /></td>
						<td><c:out value="${user.dob}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td><c:out value="${user.userName}" /></td>
						<td><c:out value="${user.password}" /></td>
						<td><c:out value="${user.gender}" /></td>
						<td><img src="ImageDisplay?userId=${user.id}"
							alt="profile pic" width="50px" height="50px"></td>
						<td><a
							href="UserController?actions=user_edit&userId=${user.id}">Edit</a>

							|<a href="UserController?actions=user_delete&userId=${user.id}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>