

<%@page import="com.dxc.beans.Exam"%>
<%@page import="com.dxc.dao.ExamJdbcDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page isELIgnored="false"%>
<%
	if (request.getMethod().equalsIgnoreCase("get")) {
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%  
ExamJdbcDAO exm = new ExamJdbcDAO();
String id=request.getParameter("id");  
Exam exam = exm.find(Integer.parseInt(id));  
if(session!=null && session.getAttribute("un")!=null) {
%>
	<h1>Edit Exam with id : <%=exam.getId() %></h1> 
		<form action = "updateExam" method = "post">
			<table>
					<tr><td><input type="hidden" name="id" value="<%=exam.getId() %>"/></td></tr>
					<tr><td>Name:</td><td><input type = "text" name="exam_name" value="<%=exam.getExam_name()%>"/></td></tr>
					
					<tr><td><input type="submit" value="Edit Exam"/></td></tr>
			</table>
		
		</form>
		<%	}
		else {
			response.sendRedirect("login");
		}%>
<a href=logout>Log Out</a>
</body>
</html>
<% }else if(request.getMethod().equalsIgnoreCase("post")){
		response.sendRedirect("Login.jsp");
	}
%>