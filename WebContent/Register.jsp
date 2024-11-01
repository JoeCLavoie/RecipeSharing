<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<form action="UserServlet" method="post">
    <input type="hidden" name="action" value="register">
    Username: <input type="text" name="username">
    Password: <input type="password" name="password">
    Email: <input type="email" name="email">
    <input type="submit" value="Register">
</form>

</body>
</html>