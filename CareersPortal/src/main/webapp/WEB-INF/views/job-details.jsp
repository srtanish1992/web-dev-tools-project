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
<title>Student Job Details Page</title>
<script type="text/javascript">
function myFunction(jobId) {
	location.href = "applyJobs.htm?jId=" + jobId; 
	<!--alert("Email sent to the volunteer regarding project assignment");-->
	}
	</script>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="user" value="${sessionScope.user}" />
	<c:set var="job" value="${sessionScope.job}" />
	
	<nav class="navbar navbar-default">
		<a href="${contextPath}/logout.htm">Logout</a>
	</nav>
	
	<div class="container" style="margin-top: 20px">
		<h2>Job Details</h2>
		<table class="table table-hover">
			<tbody>
				<tr>
					<td><button type="submit"
							onClick="myFunction(${job.jobId})" class="btn btn-lg"
							value="Apply">Apply</button></td>
				</tr>			
					<tr><td style="color: black;">Job Name:${job.jobName}</td></tr>
					<tr><td style="color: black;">Organization Name: ${job.employer.organizationName}</td></tr>
					<tr><td style="color: black;">Industry Name: ${job.employer.industry}</td></tr>
					<tr><td style="color: black;">No of Openings: ${job.openings}</td></tr>
					<tr><td style="color: black;">Available Status: ${job.availStatus}</td></tr>
					<tr><td style="color: black;">State: ${job.state}</td></tr>
					<tr><td style="color: black;">City: ${job.city}</td></tr>
					<tr><td style="color: black;">Deadline: ${job.deadline}</td></tr>
			</tbody>
		</table>
	</div>
</body>
</html>	