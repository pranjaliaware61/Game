<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="<c:url value="/resources/css/welcomeToBookManagement.css"/>">
<style>

</style>
</head>
<body>
<form>
<div class="bg-img">
  <div class="container">
    <div class="topnav">
      <a href="/welcome">Home</a>
      <a href="/signIn">Sign In</a>
      <a href="/signUp">Sign Up</a>
      <a href="/searchBooks">Search Books</a>
      <a href="/about">About</a>
    </div>
       <h3 class="registered">${registered}</h3>
     <div class="centered">Book Management System</div>
   </div>
 </div>

</form>
</body>
</html>