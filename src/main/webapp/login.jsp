<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="resources/css/login.css">
<script type="text/javascript" src="resources/js/login.js"></script>
<script type="text/javascript">
	function validate() {
		if (document.login_form.uname.value == '') {
			alert("username can not blank!!!!");
			return false;
		} else if (document.login_form.pass.value
				.search(/^(?=.*\d)(?=.*[a-zA-Z])[a-zA-Z0-9]{7,}$/)) {
			alert("Password does not match");
			return false;
		}
	}
</script>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("uname")) {
					request.setAttribute("username", cookie.getValue());
				} else if (cookie.getName().equals("pass")) {
					request.setAttribute("password", cookie.getValue());
				}
			}
		}
	%>
	<div class="container">
		<div class="card card-container">
			<img id="profile-img" class="profile-img-card"
				src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
			<p id="profile-name" class="profile-name-card"></p>
			<form name="login_form" class="form-signin" action="LoginController"
				method="post" onsubmit="return validate()">
				<span style="color: red">${loginFailMsg}</span> <span
					style="color: green">${logOutMsg}</span> <input type="text"
					id="inputEmail" class="form-control" placeholder="Username"
					name="uname" value="${username}" autofocus> <input
					type="password" id="inputPassword" class="form-control"
					placeholder="Password" name="pass" value="${password}" required>
				<div id="remember" class="checkbox">
					<label> <input type="checkbox" value="remember-me"
						name="remember-me"> Remember me
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block btn-signin"
					type="submit">Sign in</button>
			</form>
			<!-- /form -->
			<a href="forGotPassword.jsp" class="forgot-password"> Forgot the
				password? </a>
		</div>
		<!-- /card-container -->
	</div>
	<!-- /container -->
</body>
</html>