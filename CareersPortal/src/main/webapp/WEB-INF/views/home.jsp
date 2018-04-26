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
<title>Careers Portal</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<br />
	<div class="container">
		<div class="jumbotron">
			<h2>NUCareers Portal</h2>
			<p>Welcome to NUcareers - Northeastern University's database of career and cooperative education job opportunities.</p>
			<p>What is NUcareers about and who uses it?</p>
			<ol>
				<li>Co-op jobs are posted in NUcareers and listed separately from internships and after-graduation jobs.  Application to co-op jobs will be available to most full-time, undergraduate Northeastern students, as well as those students who participate in graduate level co-op programs. Students will research and rank available positions in consultation with their co-op coordinator.</li>
				<li>Staff and faculty use NUcareers to communicate with students, alumni and employers to promote and manage career-related events sponsored by Northeastern.</li>
				<li>Employers use NUcareers to post/promote after-graduation and co-op jobs, review job applications, and manage their participation in career-related events sponsored by Northeastern.</li>
			</ol>
		</div>
	</div>
	<br />
	<div class="container">
		<a href="${contextPath}/register.htm"><span
			style="text-decoration: underline;">New Employer?</span>
		</a><br />
	</div>
	<div class="container">
		<h2>Login</h2>
		<form action="${contextPath}/login.htm" method="post">
			<div class="form-group">
				<label for="username" style="color: black;">User name:</label> <input class="form-control"
					id="username" name="username" size="30" required="required" />
			</div>
			<div class="form-group">
				<label for="password" style="color: black;">Password:</label> <input type="password"
					class="form-control" id="password" name="password" size="30"
					required="required" />
			</div>
			<input type="submit" class="btn btn-lg" value="Login" />
		</form>
	</div>
</body>
</html>

