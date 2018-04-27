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
<title>Employer Homepage</title>
<script type="text/javascript">
function myFunction(jobId) {
	location.href = "studentJobs.htm?jId=" + jobId; 
	<!--alert("Email sent to the volunteer regarding project assignment");-->
	}
	</script>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="user" value="${sessionScope.user}" />
	<c:set var="employer" value="${sessionScope.employer}" />
	<c:set var="jobs" value="${sessionScope.jobs}" />
	<nav class="navbar navbar-default">
		<a href="${contextPath}/logout.htm">Logout</a>
	</nav>
	<h2>Employer Homepage</h2>
	<div class="form-group">
		<label for="pic" style="color: linen;"></label> <img
			name="pic" id="pic" height="50" width="50"
			src="${user.filename}" />
	</div>
	
	<div class="container">
		<a href="${contextPath}/postJob.htm"><span
			style="text-decoration: underline;">POST A NEW JOB</span>
		</a><br />
	</div>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<td style="color: black;" width="30%">View Applications</td>
					<td style="color: black;" width="30%">Job Title</td>
					<td style="color: black;" width="30%">Organization</td>
					<td style="color: black;" width="30%">Industry</td>
					<td style="color: black;" width="30%">Openings</td>
					<td style="color: black;" width="30%">Avail Status</td>
					<td style="color: black;" width="30%">State</td>
					<td style="color: black;" width="30%">City</td>
					<td style="color: black;" width="30%">Deadline</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${jobs}" var="job">
					<tr>
						<td><button type="submit"
								onClick="myFunction(${job.jobId})" class="btn btn-lg"
								value="Click to Edit">View</button></td>
						<td style="color: black;">${job.jobName}</td>
						<td style="color: black;">${job.employer.organizationName}</td>
						<td style="color: black;">${job.employer.industry}</td>
						<td style="color: black;">${job.openings}</td>
						<td style="color: black;">${job.availStatus}</td>
						<td style="color: black;">${job.state}</td>
						<td style="color: black;">${job.city}</td>
						<td style="color: black;">${job.deadline}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>	