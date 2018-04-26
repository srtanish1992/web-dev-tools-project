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
function myFunction(jobId) {
	location.href = "studentApplications.htm?jId=" + jobId; 
	<!--alert("Email sent to the volunteer regarding project assignment");-->
	}
</script>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="user" value="${sessionScope.user}" />
	<c:set var="jobs" value="${sessionScope.jobs}" />
	
	<nav class="navbar navbar-default">
		<a href="${contextPath}/logout.htm">Logout</a>
	</nav>

	<div class="container" style="margin-top: 20px">
	
		<h2>List of all jobs</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<td style="color: black;" width="30%">View Applications</td>
					<td style="color: black;" width="30%">Job Name</td>
					<td style="color: black;" width="30%">City</td>
					<td style="color: black;" width="30%">State</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${jobs}" var="job">
					<tr>
						<td><button type="submit" onClick="myFunction(${job.jobId})"
								class="btn btn-lg" value="View Applications">View Applications</button></td>
						<td style="color: black;">${job.jobName}</td>
						<td style="color: black;">${job.city}</td>
						<td style="color: black;">${job.state}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>	