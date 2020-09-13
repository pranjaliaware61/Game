<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
<div class="container">
<form:form method="post" class="form-group" modelAttribute="samp">
<h1>Sample Form</h1>
<fieldset>
<form:label path="id">Id</form:label>
<form:input type="text" path="id" class="form-control" required="required"></form:input>
<form:label path="name">Name</form:label>
<form:input type="text" path="name" class="form-control" required="required"></form:input>
<br>
<button type="submit" class="btn btn-success">Submit</button>
</fieldset>


</form:form>
</div>
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>