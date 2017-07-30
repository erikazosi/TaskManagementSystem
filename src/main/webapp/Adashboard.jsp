<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="Logout.jsp" %>
<html>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 7/24/2017
  Time: 1:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    Object sessionId = session.getAttribute("sessionId");
    Object adminId = Integer.parseInt(request.getParameter("adminId"));
    if (sessionId == null) {

        response.sendRedirect("Login.jsp");
    } else if (sessionId != adminId) {

        response.sendRedirect("Login.jsp");
    } else {

        System.out.println((int) sessionId);

    }
%>

<head>
    <title>Dashboard</title>
</head>
<body>
<h2>Welcome</h2>


<table border=1>
    <tr>

        <th> Title</th>
        <th>Task</th>
        <th>Deadline</th>
        <th>Status</th>
        <th>Remark</th>
        <th colspan=2>Action</th>
    </tr>


    <c:forEach var="user" items="${list}">
    <tr>
        <td><c:out value="${user.title}"/></td>
        <td><c:out value="${user.taskDesp}"/></td>
        <td><c:out value="${user.deadline}"/></td>
        <td><c:out value="${user.status}"/>
        </td>
        <td><c:out value="${user.remark}"/></td>

        <td>
            <form action="/status" method="post">
                <input type="hidden" name="taskId" value="<c:out value="${user.taskId}"/>">
                <input type="hidden" name="adminId" value="<%=request.getParameter("adminId")%>">
                    <%--<input type="submit" name="status" value="Pending" >Pending--%>
                <input type="submit" name="status" value="Completed">
                <input type="submit" name="status" value="Incomplete">

            </form>
        </td>
    </tr>
    </c:forEach>


</body>
</html>


</body>
</html>
