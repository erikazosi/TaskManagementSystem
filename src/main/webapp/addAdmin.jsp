<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 7/23/2017
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file = "Logout.jsp" %>
<%--<%--%>
    <%--Object sessionId = session.getAttribute("sessionId");--%>
    <%--System.out.println(sessionId);--%>
    <%--if (sessionId == null) {--%>

        <%--response.sendRedirect("Login.jsp");--%>
    <%--}--%>
    <%--else {--%>

    <%--}--%>
<%--%>--%>
<html>
<head>
    <title>Add Admin</title>
</head>
<body>
<form action="/addAdmin" method="post">
    <h2>Add Admin </h2>
    <input type="text" name="fullName" placeholder="Enter your fullname"><br><br>
    <input type="text" name="username" placeholder="Enter username"><br><br>
    <input type="password" name="password" placeholder="Enter password"><br><br>
    <label>Admin Type</label>
    <input type="radio" name="adminType" value="Admin"> Admin
    <input type="radio" name="adminType" value="Super Admin"> Super Admin<br><br>
    <input type="hidden" name="createdDate">
    <input type="hidden" name="status">
    <input type="email" name="email" placeholder="Enter Email"><br><BR>
    <input type="submit" name="Add" value="Add User">
</form>

</body>
</html>
