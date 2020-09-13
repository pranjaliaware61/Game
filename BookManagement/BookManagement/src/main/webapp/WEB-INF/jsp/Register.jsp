<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
<title>Form</title>
</head>
<body>
<div class="container">
<form:form method="post" class="form-group" modelAttribute="user">
<h1>User Registration</h1>
<fieldset>
<form:label path="userName">Username</form:label>
<form:input type="text" path="userName" class="form-control" placeholder="Username" required="required"></form:input>
<form:errors path="userName" cssStyle="color: #ff0000;"/>
</fieldset>
<br>
<fieldset>
<form:label path="password">Password</form:label>
<form:password path="password" class="form-control" required="required"></form:password>
<form:errors path="password" cssStyle="color: #ff0000;"/>
</fieldset>
<br>
<fieldset>
<form:label path="email">Email</form:label>
<form:input type="text" path="email" class="form-control" required="required" ></form:input>
<form:errors path="email" cssStyle="color: #ff0000;"/>
</fieldset>
<br>
<fieldset>
<form:label path="dob">DOB</form:label>
<form:input type="text" path="dob" class="form-control" required="required" ></form:input>
<form:errors path="dob" cssStyle="color: #ff0000;"/>
</fieldset>
<br>
<fieldset>
<form:label path="address">Address</form:label>
<form:input type="text" path="address" class="form-control" required="required" ></form:input>
<form:errors path="address" cssStyle="color: #ff0000;"/>
</fieldset>
<br>
<fieldset>
<form:label path="mobileNumber">Mobile No.</form:label>
<form:input type="text" path="mobileNumber" class="form-control" required="required" ></form:input>
<form:errors path="mobileNumber" cssStyle="color: #ff0000;"/>
</fieldset>
<br>
<fieldset>
<button type="submit" class="btn btn-success">Register</button>
</fieldset>


</form:form>
</div>
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	    <script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
	    
	    <script>
	    $('#dob').datepicker({
   	    format: 'dd/mm/yyyy'
        });
	    </script>
</body>

</html>