<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration Form</title>
<script type="text/javascript" src="resources/js/customValidation.js"></script>
<%@ include file="header.jsp"%>
</head>
<body>
	<br>
	<br>
	<div class="container">
		<fieldset>
			<legend align="top">Student Registration Form</legend>
			<form class="form-horizontal" action="StudentController"
				method="post" enctype="multipart/form-data">
				<span><input type="hidden" name="id" value="${student.id}"></span>
				<div class="form-group row">
					<label for="exampleFormControlInput1"
						class="col-sm-2 col-form-label">Student Name</label>
					<div class="col-sm-6">
						<input type="text" class="form-control"
							id="exampleFormControlInput1" value="${student.studentName}"
							name="sname" onkeypress="return alphabetsOnly(event)">
						<div id="name_error" style="color: red"></div>
					</div>
				</div>
				<div class="form-group row">
					<label for="exampleFormControlInput1"
						class="col-sm-2 col-form-label">College Name</label>
					<div class="col-sm-6">
						<input type="text" class="form-control"
							id="exampleFormControlInput1" value="${student.collegeName}"
							name="cname">
					</div>
				</div>
				<div class="form-group row">
					<label for="exampleFormControlInput1"
						class="col-sm-2 col-form-label">Roll</label>
					<div class="col-sm-6">
						<input type="number" class="form-control"
							id="exampleFormControlInput1" value="${student.roll}" name="roll">
					</div>
				</div>
				<div class="form-group row">
					<label for="exampleFormControlInput1"
						class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-6">
						<input type="email" class="form-control"
							id="exampleFormControlInput1" value="${student.email}"
							name="email">
					</div>
				</div>
				<div class="form-group row">
					<label for="exampleFormControlInput1"
						class="col-sm-2 col-form-label">DOB</label>
					<div class="col-sm-6">
						<input type="date" class="form-control"
							id="exampleFormControlInput1" value="${student.dob}" name="dob">
					</div>
				</div>
				<div class="form-group row">
					<label for="exampleFormControlInput1"
						class="col-sm-2 col-form-label">Gender</label>
					<div class="form-check form-check-inline">
						<label class="form-check-label"> <input
							class="form-check-input" type="radio" name="gender"
							id="inlineRadio1" value="Male"
							${student.gender=='Male'?'checked':''}> Male
						</label>
					</div>
					<div class="form-check form-check-inline">
						<label class="form-check-label"> <input
							class="form-check-input" type="radio" name="gender"
							id="inlineRadio2" value="Female"
							${student.gender=='Female'?'checked':''}> Female
						</label>
					</div>
				</div>

				<div class="form-group row">
					<label for="exampleFormControlInput1"
						class="col-sm-2 col-form-label">Subject</label>
					<div class="form-check form-check-inline">
						<label class="form-check-label"> <input
							class="form-check-input" type="checkbox" id="inlineCheckbox1"
							value="Java"
							<c:if test="${fn:contains(student.subject,'Java')}">checked</c:if>
							name="subject"> Java
						</label>
					</div>
					<div class="form-check form-check-inline">
						<label class="form-check-label"> <input
							class="form-check-input" type="checkbox" id="inlineCheckbox2"
							value="Php"
							<c:if test="${fn:contains(student.subject,'Php')}">checked</c:if>
							name="subject"> Php
						</label>
					</div>
					<div class="form-check form-check-inline">
						<label class="form-check-label"> <input
							class="form-check-input" type="checkbox" id="inlineCheckbox1"
							value="Android"
							<c:if test="${fn:contains(student.subject,'Android')}">checked</c:if>
							name="subject"> Android
						</label>
					</div>
					<div class="form-check form-check-inline">
						<label class="form-check-label"> <input
							class="form-check-input" type="checkbox" id="inlineCheckbox2"
							value=".Net"
							<c:if test="${fn:contains(student.subject,'.Net')}">checked</c:if>
							name="subject"> .Net
						</label>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label"
						for="inlineFormCustomSelectPref">Departments</label> <select
						class="custom-select mb-2 mr-sm-2 mb-sm-0"
						id="inlineFormCustomSelectPref" name="departments">
						<option selected>Choose...</option>
						<option value="IT" ${student.departments=='IT'?'selected':''}>IT</option>
						<option value="Computer"
							${student.departments=='Computer'?'selected':''}>Computer</option>
						<option value="Electrical"
							${student.departments=='Electrical'?'selected':''}>Electrical</option>
						<option value="Electronics"
							${student.departments=='Electronics'?'selected':''}>Electronics</option>
					</select>
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