<%@ page import="java.util.List" %>
<%@ page import="com.tms.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 7/24/2017
  Time: 1:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<%@ include file = "Logout.jsp" %>
<%
    Object sessionId = session.getAttribute("sessionId");
    Object adminId = Integer.parseInt(request.getParameter("adminId"));
    if (sessionId == null) {

        response.sendRedirect("Login.jsp");
    } else if (sessionId != adminId) {

        response.sendRedirect("Login.jsp");
    } else {



    }
%>
<html>
<head>
    <title>Add Task</title>
</head>
<body>
<h2>Add Task</h2>
<form method="post" action="/addTask" enctype="multipart/form-data">
    <input type="text" name="title" placeholder="Enter task title"><br><br>
    <input type="text" name="desc" placeholder="Enter task Description"><br><br>
    <label>Deadline:</label>
    <input type="date" name="deadline" placeholder="yyyy-MM-dd"><br><br>


    <label>Assign To: </label>
    <select name="assignTo"
    >
        <c:forEach var="user" items="${list}">

            <option value="<c:out value="${user[1]}"/>"><c:out value="${user[0]}"/></option>

        </c:forEach>
    </select><br><br>
    <input type="hidden" name="createdOn">
    <input type="hidden" name="createdBy" value="<%=request.getParameter("adminId")%>">

    <input type="file" name="fileUpload"><br><br>

    <input type="submit" name="submit" value="Add Task">
</form>

</body>
</html>
