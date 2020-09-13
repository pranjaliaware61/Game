<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.io.File"%>
<%@page import="java.nio.file.Files"%>
<%@page import="java.nio.file.Path"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.attribute.BasicFileAttributes"%>
<%@page import="java.nio.file.attribute.FileOwnerAttributeView"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!--  <link href="${contextPath}/resource/bootstrap-4.0.0-dist/css/bootstrap.min.css" rel="stylesheet">-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<!-- 	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" -->

</head>

<body>

	<div class="container">
		<!--  <h1>Displaying Last 5 modified files</h1> -->
		<table class="table table-hover">
			<tr >
				<th><b>Parent</b></th>
				<th><b>File Name</b></th>
				<th><b>Owner</b></th>
				<th><b>Last Modified</b></th>
				<th><b>File Size</b></th>
				<th><b>View</b></th>
				<th><b>Download</b></th>
			</tr>
			<%
        File [] fiction =(File[])request.getAttribute("fiction"); 
        for(int i=0;i<5;i++){
        	    Path path =Paths.get(fiction[i].toString());
        	    BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
        	    FileOwnerAttributeView view = Files.getFileAttributeView(path,FileOwnerAttributeView.class);
				%>
			<tr>
				<td><%=path.getParent()%></td>
				<td><%=path.getFileName()%></td>
				<td><%=view.getOwner()%></td>
				<td><%=attr.lastModifiedTime().toString().substring(0, 10)%></td>
				<td><%=attr.size() %></td>
				<td><a href=<%=path%>> <button type="button">View</button> </a></td>
			    <td>
			    <a href="<%=path%>" download="abc"> 
			    <button type="button" >Download</button>
			    </a>
			    </td>
			</tr>
			<%}%>
		</table>
		<hr />
	</div>
</body>

</html>