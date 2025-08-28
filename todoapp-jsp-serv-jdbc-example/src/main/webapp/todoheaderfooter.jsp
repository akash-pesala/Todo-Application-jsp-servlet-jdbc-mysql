<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>To Do List App</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark bg-dark">
			<div>
				<a href="" class="navbar-brand">Todo App</a>
			</div>
			<ul class="navbar-nav">
				<li><a class="nav-link" href="<%=request.getContextPath()%>/TodoListServlet/list">Todos</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li><a class="nav-link" href="<%=request.getContextPath()%>/showloginValidate">LogIn</a></li>
				<li><a class="nav-link" href="<%=request.getContextPath()%>/showRegister">Signup</a></li>
			</ul>
		</nav>	
	</header>
	
	<footer>
		<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-bottom">
			<span class="navbar-brand mx-auto">© 2025 copyright <a href="">Java Guides</a></span>
		</nav>
	</footer>
</body>
</html>