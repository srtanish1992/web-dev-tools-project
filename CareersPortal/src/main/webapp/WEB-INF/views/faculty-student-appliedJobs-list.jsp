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
<title>Jobs student applied for</title>
<script type="text/javascript">
function approve(studentId) {
	location.href = "ApproveStudents.htm?sId=" + studentId; 
	<!--alert("Email sent to the student regarding the job application");-->
	}
function disapprove(studentId) {
	location.href = "DisapproveStudents.htm?sId=" + studentId; 
		alert("Email sent to the student regarding the job application");
	}	
</script>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="pendingStudents" value="${sessionScope.pendingStudents}" />
	<c:set var="approvedStudents" value="${sessionScope.approvedStudents}" />
	
	<nav class="navbar navbar-default">
		<a href="${contextPath}/logout.htm">Logout</a>
	</nav>
	
	<div class="container">
		<h2>New Applications</h2>
		<table class="table table-hover">
			<tbody>
				<tr>
				  <th>First Name :</th>
				  <th>Last Name :</th>
				</tr>
				<c:forEach items="${pendingStudents}" var="student">
					
					<tr>
						<td style="color: black;">${student.user.firstName}</td>
						<td style="color: black;">${student.user.lastName}</td>
						<td><button type="submit"
								onClick="approve(${student.user.userId})" class="btn btn-lg"
								value="Approve">Approve</button></td>
						<td><button type="submit"
								onClick="disapprove(${student.user.userId})" class="btn btn-lg"
								value="Disapprove">Disapprove</button></td>		
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<h2>Approved Applications</h2>
		<table class="table table-hover">
			<tbody>
				<tr>
				  <th>First Name :</th>
				  <th>Last Name :</th>
				</tr>
				<c:forEach items="${approvedStudents}" var="student">
					
					<tr>
						<td style="color: black;">${student.user.firstName}</td>
						<td style="color: black;">${student.user.lastName}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</body>
</html>