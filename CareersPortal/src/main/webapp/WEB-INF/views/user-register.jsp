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
<title>Register New User</title>
</head>
<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<br />
	<div class="container">
		<h2>Register as a New User</h2>
		<form:form action="${contextPath}/register.htm" commandName="employer"
			enctype="multipart/form-data" method="post">
			<div class="container">
				<table class="table table-hover">
					<tr>
						<td style="color: black;">Photo:</td>
						<td><form:input type="file" class="filestyle" path="user.photo" /></td>
					</tr>
					<tr>
						<td style="color: black;">First Name:</td>
						<td><form:input path="user.firstName" pattern="" id="firstName" name="firstName"	
								size="30" /> <font color="red"><form:errors
									path="user.firstName"/></font></td>
					</tr>
					<tr>
						<td style="color: black;">Last Name:</td>
						<td><form:input path="user.lastName" pattern="^[a-zA-Z ]{2,30}$" name="lastName"
								size="30" /> <font color="red"><form:errors
									path="user.lastName" /></font></td>
					</tr>
					<tr>
						<td style="color: black;">Middle Name:</td>
						<td><form:input path="user.middleName" pattern="^[a-zA-Z ]{2,30}$" name="lastName"
								size="30" /> <font color="red"><form:errors
									path="user.middleName" /></font></td>
					</tr>
					<tr>
						<td style="color: black;">User Name:</td>
						<td><form:input path="user.userName" pattern="^[A-z0-9À-ž\s]{2,}$" name="userName"
								size="30" /> <font color="red"><form:errors
									path="user.userName" /></font></td>
					</tr>
					<tr>
						<td style="color: black;">Password:</td>
						<td><form:password path="user.password" size="30" pattern=".{6,}" name="password" />
							<font color="red"><form:errors path="user.password" /></font></td>
					</tr>
					<tr>
						<td style="color: black;">Email Id:</td>
						<td><form:input path="user.email.emailAddress" size="30"
								pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" type="email" name="emailAddress" />
							<font color="red"><form:errors path="user.email.emailAddress" /></font></td>
					</tr>
					<tr>
						<td style="color: black;">Organization Name:</td>
						<td><form:input path="organizationName" pattern="^[a-zA-Z ]{2,30}$" name="organizationName"
								size="30" /> <font color="red"><form:errors
									path="organizationName" /></font></td>
					</tr>
					<tr>
						<td style="color: black;">Industry:</td>
						<td>
							<form:select path="industry">
					            <form:option value="Technology"/>
					            <form:option value="Consulting"/>
					            <form:option value="Healthcare"/>
					            <form:option value="Internet"/>
					        </form:select>
						</td>
					</tr>
					<tr>
						<td style="color: black;">Address:</td>
						<td><form:textarea path="user.address" size="150"
								pattern="^[A-z0-9À-ž\s]{2,150}$" name="address" /> <font color="red"><form:errors
									path="user.address" /></font></td>
					</tr>
					<tr>
						<td style="color: black;">City</td>
						<td><form:input path="user.city" size="30"
								pattern="^[A-z0-9À-ž\s]{2,150}$" name="city" /> <font color="red"><form:errors
									path="user.city" /></font></td>
					</tr>
					<tr>
						<td style="color: black;">State:</td>
						<td>
							<form:select path="user.state">
					            <form:option value="MA"/>
					            <form:option value="CT"/>
					            <form:option value="DC"/>
					            <form:option value="LA"/>
					        </form:select>
						</td>
					</tr>
					<tr>
						<td style="color: black;">Phone Number:</td>
						<td><form:input path="user.phoneNumber" size="30"
								pattern="^\d{10}$"  name="phoneNumber" /> <font color="red"><form:errors
									path="user.phoneNumber" /></font></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" class="btn btn-lg"
							value="Register User" /></td>
					</tr>
				</table>
			</div>
		</form:form>
		
		
		
	</div>
</body>
</html>