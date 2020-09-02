<%@page import="com.dxc.dao.ExamJdbcDAO"%>
<%@page import="com.dxc.beans.Exam"%>
<%@page import="org.apache.tomcat.jni.Stdlib"%>
<%@page import="com.dxc.beans.Student"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="NewExam.jsp">add exam</a>


<%
		if(session!=null && session.getAttribute("un")!=null) {

			String username = (String)session.getAttribute("un");
			out.println("<h2>Welcome to "+username+" </h2>");
			
				List<Exam> exams = new ExamJdbcDAO().findAll();
				request.setAttribute("exams", exams);
%>
				<table>
				<tr>
				<th>ID</th>
				<th>Exam Name</th>
				
				</tr>
				<c:forEach items="${exams}" var="u"> 
				
				<tr>
					<td>${u.getId()}</td>
					<td>${u.getExam_name()}</td>
					
					<td><a href="EditExam.jsp?id=${u.getId()}">Edit</a></td>  
					<td><a href="delete?id=${u.getId()}">Delete</a></td>
					</tr>
				</c:forEach> 
				</table>
		<%	}
		else {
			response.sendRedirect("login");
		}%>
<a href=logout>Log Out</a>
</body>
</html>

