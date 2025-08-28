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
<title>Todo Form</title>
<style type="text/css">
	#context-up{
		margin-bottom : 80px;
	}
</style>
</head>
<body>
	<%@ include file = "todoheaderfooter.jsp" %>
	<div class="container col-md-5" id="context-up">
		<div class="card">
			<div class="card-body">
				<caption>
					<c:if test="${td == null}">
						<h2>Add New Todo</h2>
					</c:if>
					<c:if test="${td != null}">
						<h2>Edit Todo</h2>
					</c:if>
				</caption>
				
				<c:if test="${td!=null}">
					<form action="<%=request.getContextPath()%>/TodoListServlet/update" method="post">
						<input type="hidden" name="id" value="<c:out value='${td.id}'/>"/>
				</c:if>
				
				<c:if test="${td==null }">
					<form action="<%=request.getContextPath()%>/TodoListServlet/insert" method="post">
				</c:if>		
							
						<fieldset class="form-group">
							<label class="form-label">Todo Title</label>
				<input type="text" class="form-control" value='<c:out value="${td.title}"/>' name="title" required="required">
							
						</fieldset>	
						
						<fieldset class="form-group">
							<label class="form-label">Todo Description</label>
		<input type="text" class="form-control" value='<c:out value="${td.description}"/>' name="description" required="required">
						</fieldset>	
						
						
						
						<fieldset class="form-group">
							<label class="form-label">Todo Status</label>
								<select class="form-control" name="status">
									<option value="true">Completed</option>
									<option value="false">In Progress</option>
								</select>
						</fieldset>	
						
						
						<fieldset class="form-group">
							<label class="form-label">Todo Target Date</label>
				<input type="date" class="form-control" value='<c:out value="${td.targetDate}"/>' name="date" required="required">
						</fieldset>	

						<button class="btn btn-success">Save</button>
					</form>
				
			
			</div>
		</div>
	
	
	
	
	
	</div>
		
	
	
	
</body>
</html>