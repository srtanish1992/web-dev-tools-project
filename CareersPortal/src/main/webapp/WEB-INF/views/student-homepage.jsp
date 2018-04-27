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
<title>Student Homepage</title>
<script type="text/javascript">
function myFunction(jobId) {
	location.href = "jobView.htm?jId=" + jobId; 
	<!--alert("Email sent to the volunteer regarding project assignment");-->
	}
function cancelApplication(jobId) {
	location.href = "cancelApplication.htm?jobId=" + jobId; 
	<!--alert("Email sent to the volunteer regarding project assignment");-->
	}
	</script>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="user" value="${sessionScope.user}" />
	<c:set var="aJobs" value="${sessionScope.aJobs}" />
	<c:set var="pJobs" value="${sessionScope.pJobs}" />
	<c:set var="allJobs" value="${sessionScope.notAppliedJobs}" />
	
	<nav class="navbar navbar-default">
		<a href="${contextPath}/logout.htm">Logout</a>
	</nav>
	
	<h2>Student Homepage</h2>

	<div class="container" style="margin-top: 20px">

		<form:form class="container" action="${contextPath}/search.htm"
			method="get">
			<div>
				<label for="keyword">Keyword: </label> <input type="text"
					name="keywordval" id="keywordval" required /><br> <br>
			</div>
			<div>
				<input type='radio' name='radmovieinfo' value='jobName' required />
				Search by Job Name
			</div>
			<div>
				<input type='radio' name='radmovieinfo' value='location' /> Search
				by City
			</div>
			<div>
				<input type='radio' name='radmovieinfo' value='organizationName' />
				Search by Organization Name
			</div>
			<div>
				<input type="submit" class="btn btn-lg" name="button" value="Search" />
			</div>
		</form:form>

		<h2>List of all jobs</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<td style="color: black;" width="30%">View Job</td>
					<td style="color: black;" width="30%">Job Name</td>
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
				<c:forEach items="${allJobs}" var="job">
					<tr>
						<td><button type="submit" onClick="myFunction(${job.jobId})"
								class="btn btn-lg" value="View job">View Job</button></td>
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

		<form:form class="container" action="${contextPath}/search.htm"
			method="get">
			<div>

				<input type="submit" class="btn btn-lg" name="button" value="Reset" />
			</div>
		</form:form>

	</div>



	<div class="container">
		<h2>List of Jobs Applied by the student</h2>
		<h3>Jobs approval pending</h3>
		<table class="table table-hover">
			<thead>
				<tr>
					<td style="color: black;" width="30%">View Job</td>
					<td style="color: black;" width="30%">Job Name</td>
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
				<c:forEach items="${pJobs}" var="job">
					<tr>
						<td><button type="submit"
								onClick="cancelApplication(${job.jobId})" class="btn btn-lg"
								value="Cancel Application">Cancel Application</button></td>
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
		<h3>Aprooved by faculty</h3>
		<table class="table table-hover">
			<thead>
				<tr>
					<td style="color: black;" width="30%">Job Name</td>
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
				<c:forEach items="${aJobs}" var="job">
					<tr>
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
