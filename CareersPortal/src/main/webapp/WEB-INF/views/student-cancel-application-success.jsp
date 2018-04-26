<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>

a {
	font-size: 20px;
	color: black;
}

h2 {
	color: black;
}

p {
	color: black;
}

label {
	font-size: 20px;
}
</style>
<title>Success Job Application</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="job" value="${sessionScope.removedJob}" />
	
	<nav class="navbar navbar-default">
		<a href="${contextPath}/logout.htm">Logout</a>
	</nav>
	
	<form:form action="${contextPath}/goBackJobsList.htm" method="post">
		<h1>${job.jobName} cancelled successfully</h1>
		<input type="submit" class="btn btn-lg"
							value="Go back to Jobs List" />
	</form:form>

</body>
</html>