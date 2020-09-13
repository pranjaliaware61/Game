<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<title>ToDos</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
<div class="container">
<h1>Welcome ToDos for  ${username} </h1>
<table class="table table-striped">
<caption>Table of Added Todos</caption>
	<thead>
		<tr>
			<th>Description</th>
			<th>isDone</th>
			<th>TargetDate</th>
			<th>UpdateButton</th>
			<th>DeleteButton</th>
		</tr>
	</thead>
	
	<tbody>
	
	<c:forEach items="${todos}" var="todo">
	<tr>
	<td>${todo.desc}</td>
	<td>${todo.isDone}</td>
	 <td><f:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
	<td><a type="button" class="btn btn-success" href="/update?id=${todo.id}">Update</a></td>
	<td><a type="button" class="btn btn-warning" href="/delete?id=${todo.id}"> Delete</a></td>
	</tr>
	</c:forEach>
	
	</tbody>

</table>
</div>
<!--  <h2> ${todos} </h2>-->
<div><h2><a href="/add-todo">Add ToDo</a></h2></div>
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>