<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
  .content-area {
     margin-bottom: 100px;
  }
</style>
</head>
<body>
	<%@ include file="todoheaderfooter.jsp" %>
	<div class="container content-area">
	
		<div class="col-md-6 col-md-offset-3">
			<h2>User Register Form</h2>
			<c:if test="${not empty notification}">
			    <div class="alert alert-success center" role="alert">
			        <p>${notification}</p>
			    </div>
			</c:if>
	
			<form action="<%=request.getContextPath()%>/register" method="post">
				<label class="form-label">First Name:</label>
				<input type="text" class="form-control" name="firstname" required="required">
				<label class="form-label">Last Name:</label>
				<input type="text" class="form-control" name="lastname" required="required">
				<label class="form-label">User Name:</label>
				<input type="text" class="form-control" name="username" required="required">
				<label class="form-label">Password:</label>
				<input type="password" class="form-control" name="password" required="required">
				<br>
				<button class="btn btn-primary">Submit</button>
				<br>
			</form>
			
		</div>
	
	</div>
	
	
</body>
</html>