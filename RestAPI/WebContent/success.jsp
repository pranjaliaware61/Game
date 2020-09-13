<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Stack"%> 
    <%@page import="java.nio.file.Path"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
 <body> 
      <h1>Displaying Last 5 modified files</h1> 
      <table border ="1" width="500" align="center"> 
         <tr bgcolor="00FF7F"> 
         <th><b>Parent</b>
          <th><b>File Name</b></th> 
         </tr> 
        <%-- Fetching the attributes of the request object 
             which was previously set by the servlet  
              "StudentServlet.java" 
        --%>  
        <%Stack<Path> stack =  
            (Stack<Path>)request.getAttribute("stack"); 
        for(int j=stack.size()-1;j>=0;j--){%> 
        <%-- Arranging data in tabular form 
        --%> 
            <tr> 
                <td><%=stack.get(j).getParent()%></td> 
                <td><%=stack.get(j).getFileName()%></td> 
            </tr> 
            <%stack.pop();}%> 
        </table>  
        <hr/> 
    </body>
</html>