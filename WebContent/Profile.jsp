<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body>
<h1>Profile</h1>
<form action="UserServlet" method="post">
    <input type="hidden" name="action" value="updateProfile">
    Username: <input type="text" name="username" value="${user.username}">
    Email: <input type="email" name="email" value="${user.email}">
    <input type="submit" value="Update">
</form>

</body>
</html>