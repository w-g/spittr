<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Spittr</title>
</head>
<body>
	<h1>Your Profile</h1>
	<div>
		<div>
			Username: <c:out value="${spitter.username}" />
		</div>
		<div>
			Name:
			<span><c:out value="${spitter.firstName}" /></span> 
			<span><c:out value="${spitter.lastName}" /></span>
		</div>
	</div>
</body>
</html>