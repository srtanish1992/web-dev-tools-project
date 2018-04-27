<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style>
body {
	background-image:
		url(https://www.myscbc.org/wp-content/uploads/2013/03/background-images-for-websites-hd-background-wallpaper-40.jpg);
}

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
<script type="text/javascript">
	$(function() {
		$('#idDateField').datepicker();
	});
</script>
<title>New Job Post</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<br />
	
	<nav class="navbar navbar-default">
		<a href="${contextPath}/logout.htm">Logout</a>
	</nav>
	
	<div class="container">
		<h2>Post a New Job</h2>
		<form:form action="${contextPath}/postJob.htm" modelAttribute="job"
			enctype="multipart/form-data" method="post">
			<div class="container">
				<table class="table table-hover">

					<tr>
						<td style="color: black;">Job Name:</td>
						<td><form:input path="jobName" pattern="^[a-zA-Z ]{2,30}$"
								size="30" /> <font color="red"><form:errors
									path="jobName" /></font></td>
					</tr>
					<tr>
						<td style="color: black;">Job Description:</td>
						<td><form:textarea path="jobDesc" size="150"
								pattern="^[A-z0-9À-ž\s]{2,150}$" /> <font color="red"><form:errors
									path="jobDesc" /></font></td>
					</tr>

					<tr>
						<td style="color: black;">No of Openings:</td>
						<td><form:input path="openings" pattern="^\d$" size="30" /> <font
							color="red"><form:errors path="openings" /></font></td>
					</tr>
					<tr>
						<td style="color: black;">Available Status:</td>
						<td><form:select path="availStatus">
								<form:option value="Availabe" />
								<form:option value="Unavailable" />
							</form:select></td>
					</tr>
					<tr>
						<td style="color: black;">City</td>
						<td><form:input path="city" size="30"
								pattern="^[A-z0-9À-ž\s]{2,150}$" /> <font color="red"><form:errors
									path="city" /></font></td>
					</tr>
					<tr>
						<td style="color: black;">State:</td>
						<td><form:select path="state">
								<form:option value="MA" />
								<form:option value="CT" />
								<form:option value="DC" />
								<form:option value="LA" />
							</form:select></td>
					</tr>
					<tr>
						<td style="color: black;">Deadline:</td>

						<td> <form:input
								id="idDateField" path="deadline" value="${vacancyDate}" type="text"/><font
							color="red"><form:errors path="deadline" /></font></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" class="btn btn-lg"
							value="Post" /></td>
					</tr>
				</table>
			</div>
		</form:form>

</div>

</body>
</html>