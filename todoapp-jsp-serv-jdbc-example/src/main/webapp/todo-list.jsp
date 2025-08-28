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
<title>Todo list</title>
<style type="text/css">
	.content-txt{
		margin-bottom : 80px
	}
</style>
</head>
<body>
	<%@ include file = "todoheaderfooter.jsp" %>
	
	<div class="row">
		<div class="container content-txt">
			<h2 align="center">List of Todos</h2>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/TodoListServlet/new" class="btn btn-primary">Add Todo</a>
				
			</div>
			<table class="mt-3 table table-bordered">
				<thead>
					<tr>
						<td>Title</td>
						<td>Target Date</td>
						<td>Todo Status</td>
						<td>Actions</td>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="td" items="${listingtodo}">
						<tr>
							<td><c:out value="${td.title }"></c:out></td>
							<td><c:out value="${td.targetDate }"></c:out></td>
							<td><c:out value="${td.status }"></c:out></td>
							<td>
								<a href="<%=request.getContextPath()%>/TodoListServlet/edit?id=<c:out value='${td.id }'/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="<%=request.getContextPath()%>/TodoListServlet/delete?id=<c:out value='${td.id }'/>">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	
	
</body>
</html>