<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(session!=null && session.getAttribute("un")!=null) {
%>
	<form action = "addExam" method = "post">
	<h1>New Student Form</h1>
			<table>
					<tr><td>ID</td><td><input type="text" name="id" /></td></tr>
					<tr><td>Exam Name</td><td><input type = "text" name="exam_name" /></td></tr>
					<tr><td><input type="submit" value="save"/></td></tr>
			</table>
		
		</form>
		<% }
		else {
			response.sendRedirect("login");
		}%>
<a href=logout>Log Out</a>
	
	
</body>
</html>