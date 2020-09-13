<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
<div class="container">
<h1>Welcome to ToDos ${username}</h1>
<h2>To List ToDos<a type="button" class="btn btn-success" href="/list-todos">Click here</a></h2>
</div>
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>