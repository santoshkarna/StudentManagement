<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Form</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<br>
	<br>
	<div class="container">
		<fieldset>
			<legend align="top">User Registration Form</legend>
			<form class="form-horizontal" action="UserController" method="post"
				enctype="multipart/form-data">
				<span><input type="hidden" name="id" value="${user.id}"></span>
				<div class="form-group row">
					<label for="exampleFormControlInput1"
						class="col-sm-2 col-form-label">First Name</label>
					<div class="col-sm-6">
						<input type="text" class="form-control"
							id="exampleFormControlInput1" value="${user.firstName}"
							name="fname">
					</div>
				</div>
				<div class="form-group row">
					<label for="exampleFormControlInput1"
						class="col-sm-2 col-form-label">Last Name</label>
					<div class="col-sm-6">
						<input type="text" class="form-control"
							id="exampleFormControlInput1" value="${user.lastName}"
							name="lname">
					</div>
				</div>
				<div class="form-group row">
					<label for="exampleFormControlInput1"
						class="col-sm-2 col-form-label">DOB</label>
					<div class="col-sm-6">
						<input type="date" class="form-control"
							id="exampleFormControlInput1" value="${user.dob}" name="dob">
					</div>
				</div>

				<div class="form-group row">
					<label for="exampleFormControlInput1"
						class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-6">
						<input type="email" class="form-control"
							id="exampleFormControlInput1" value="${user.email}" name="email">
					</div>
				</div>
				<div class="form-group row">
					<label for="exampleFormControlInput1"
						class="col-sm-2 col-form-label">User Name</label>
					<div class="col-sm-6">
						<input type="text" class="form-control"
							id="exampleFormControlInput1" value="${user.userName}"
							name="username">
					</div>
				</div>
				<div class="form-group row">
					<label for="exampleFormControlInput1"
						class="col-sm-2 col-form-label">password</label>
					<div class="col-sm-6">
						<input type="password" class="form-control"
							id="exampleFormControlInput1" value="${user.password}"
							name="password">
					</div>
				</div>
				<div class="form-group row">
					<label for="exampleFormControlInput1"
						class="col-sm-2 col-form-label">Gender</label>
					<div class="form-check form-check-inline">
						<label class="form-check-label"> <input
							class="form-check-input" type="radio" name="gender"
							id="inlineRadio1" value="Male"
							${user.gender=='Male'?'checked':''}> Male
						</label>
					</div>
					<div class="form-check form-check-inline">
						<label class="form-check-label"> <input
							class="form-check-input" type="radio" name="gender"
							id="inlineRadio2" value="Female"
							${user.gender=='Female'?'checked':''}> Female
						</label>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label"
						for="exampleFormControlFile1">Upload Image</label> <input
						type="file" class="form-control-file" id="exampleFormControlFile1"
						name="photo">
				</div>
				<div class="form-group row">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</form>
		</fieldset>
	</div>
</body>
</html>