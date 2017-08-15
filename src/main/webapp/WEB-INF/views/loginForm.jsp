<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Spittr</title>
</head>
<body>
	<h1>Register</h1>
	<div>
		<form method="POST">
			<div>
				Username: <input type="text" name="username" />
			</div>
			<div>
				Password: <input type="password" name="password" />
			</div>
			<div>
				<input type="checkbox" name="rememberMe" value="true"/>Remember Me?
			</div>
			<div>
				<button type="submit">Register</button>
			</div>
		</form>
	</div>
</body>
</html>
