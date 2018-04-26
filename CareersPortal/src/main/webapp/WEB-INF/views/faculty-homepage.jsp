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
<title>Faculty Homepage</title>
<script type="text/javascript">
function myFunction(employerId) {
	location.href = "facultyJobs.htm?eId=" + employerId; 
	<!--alert("Email sent to the volunteer regarding project assignment");-->
	}
</script>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="user" value="${sessionScope.user}" />
	<c:set var="employers" value="${sessionScope.employers}" />
	
	<nav class="navbar navbar-default">
		<a href="${contextPath}/logout.htm">Logout</a>
	</nav>

	<div class="container" style="margin-top: 20px">
	
		<h2>List of all employers</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<td style="color: black;" width="30%">View Jobs</td>
					<td style="color: black;" width="30%">Organization</td>
					<td style="color: black;" width="30%">Industry</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employers}" var="employer">
					<tr>
						<td><button type="submit" onClick="myFunction(${employer.employerId})"
								class="btn btn-lg" value="View jobs">View Jobs</button></td>
						<td style="color: black;">${employer.organizationName}</td>
						<td style="color: black;">${employer.industry}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>	