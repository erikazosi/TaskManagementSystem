<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 7/24/2017
  Time: 1:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
    <form action="/login" method="post">
        <input type="text" name="username" placeholder="Enter username">
        <input type="password" name="password" placeholder="Enter password">
        <input type="submit" name="submit" value="Login">
    </form>



</body>
</html>
