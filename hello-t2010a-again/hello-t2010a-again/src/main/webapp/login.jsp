<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/19/2022
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1> Login page</h1>
<form action="admin/login" method="post">
    <div>
        Username <input type="text" name="username">
    </div>
    <div>
        Password<input type="password" name="password">
    </div>
    <div>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </div>
</form>
</body>
</html>
