<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%@ include file = "todoheaderfooter.jsp" %>
	<div class="container pt-3 col-md-4" style="overflow: auto">
		<h2>Login Form</h2>
		<form action="<%= request.getContextPath()%>/loginValidate" method="post">
			<label class="form-label">User Name:</label>
			<input class="form-control" type="text" name="username" placeholder="Username" required><br>
			<label class="form-label">Password:</label>
			<input class="form-control" type="password" name="password" placeholder="Password" required><br>
			<button class="btn btn-primary">Submit</button>
			
	        <c:if test="${not empty errorMsg}">
			    <div class="alert alert-danger mt-3">
			        <p>${errorMsg}</p>
			    </div>
			</c:if>
			
		</form>
	</div>
</body>
</html>