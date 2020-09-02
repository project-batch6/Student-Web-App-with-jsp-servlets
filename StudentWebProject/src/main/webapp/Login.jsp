<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<form action="loginValidate" method="post">
	<table>
	<tr><td>User Name </td><td><input type="text" name="username"></td></tr>
	<tr><td>Password </td><td><input type="password" name="password"><br></td></tr>
	<tr><td><input type="submit" value="Login"></td>
	<td><input type="reset" value="Cancel"></td></tr>
	</table>
	</form>
</body>
</html>