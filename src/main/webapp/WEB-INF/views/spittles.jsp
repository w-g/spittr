<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Spittr</title>
</head>
<body>
	<h1>Recent Spittles</h1>
	<ul>
		<c:forEach items="${spittleList}" var="spittle">
			<li id="spittle_<c:out value="spittle.id" />">
				<div>
					<c:out value="${spittle.message}" />
				</div>
				<div>
					<span><c:out value="${spittle.time}" /></span>
					<span>
						(<c:out value="${spittle.latitude}" />,
						<c:out value="${spittle.longitude}" />)
					</span>
				</div>
			</li>
		</c:forEach>
	</ul>
</body>
</html>
