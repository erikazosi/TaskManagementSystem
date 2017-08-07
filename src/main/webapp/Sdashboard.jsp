<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 7/24/2017
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
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

<html>
<head>
    <title>Dashboard</title>
</head>
<style>
    img {
        transition: all .2s ease-in-out;
    }

    img:hover {
        transform: scale(1.1);
        width: 200px;
    }
</style>
<body>
<%@ include file="Logout.jsp" %>
<h2>Welcome</h2>
<a href="addAdmin.jsp">Add Admin</a><br><br>
<a href="addTask?adminId=<%=request.getParameter("adminId")%>
">Add Task</a>

<%--TABLE FOR PENDING TASKS--%>
<table border=1>
    <caption>PENDING TASKS</caption>
    <tr>

        <th>Created By:</th>
        <th>Created Date:</th>
        <th>Title:</th>
        <th>Task</th>
        <th>Assigned To</th>
        <th>Deadline</th>
        <th>Status</th>
        <th>File</th>
        <th colspan=2>Action</th>
    </tr>
    <c:forEach var="task" items="${list}">
    <tr>
        <td><c:out value="${task.createdBy}"/></td>
        <td><c:out value="${task.createdDate}"/></td>
        <td><c:out value="${task.title}"/></td>
        <td><c:out value="${task.taskDesp}"/></td>
        <td><c:out value="${task.assignedTo}"/></td>
        <td><c:out value="${task.deadline}"/></td>
        <td><c:out value="${task.status}"/></td>
        <div class="image">
            <td><img src="../uploadFiles/<c:out value="${task.fileUpload}"/>" width="50"/></td>
        </div>
        <td>
            <a href="edit?taskId=<c:out value="${task.taskId}"/>&adminId=<%=request.getParameter("adminId")%>">Update</a>
        </td>
        <td>
            <a href="delete.jsp?taskId=<c:out value="${task.taskId}"/>&adminId=<%=request.getParameter("adminId")%>">Delete </a>
        </td>

        </c:forEach>
    </tr>
</table>
<br><br>

<%--TABLE FOR COMPLETED TASKS--%>
<table border=1>
    <caption>COMPLETED TASKS</caption>
    <tr>

        <th>Created By:</th>
        <th>Created Date:</th>
        <th>Title:</th>
        <th>Task</th>
        <th>Assigned To</th>
        <th>Deadline</th>
        <th>Status</th>
        <th colspan=2>Action</th>
        <th>Remark</th>
    </tr>
    <c:forEach var="task" items="${list2}">
    <tr>
        <td><c:out value="${task.createdBy}"/></td>
        <td><c:out value="${task.createdDate}"/></td>
        <td><c:out value="${task.title}"/></td>
        <td><c:out value="${task.taskDesp}"/></td>
        <td><c:out value="${task.assignedTo}"/></td>
        <td><c:out value="${task.deadline}"/></td>
        <td><c:out value="${task.status}"/></td>

        <td>
            <a href="edit?taskId=<c:out value="${task.taskId}"/>&adminId=<%=request.getParameter("adminId")%>">Update</a>
        </td>
        <td>
            <a href="delete.jsp?taskId=<c:out value="${task.taskId}"/>&adminId=<%=request.getParameter("adminId")%>">Delete </a>
        </td>
        <td>

            <form action="/addRemark" method="post">

                <input type="text" name="remark" value="<c:out value="${task.remark}"/>">
                <input type="hidden" name="taskId" value="<c:out value="${task.taskId}"/>">
                <input type="hidden" name="adminId" value="<%=request.getParameter("adminId")%>">
                <input type="submit" name="submit" value="Save">
            </form>
        </td>

        </c:forEach>
    </tr>
</table>
<br>


<%--TABLE FOR INCOMPLETE TASKS--%>
<table border=2>
    <caption>INCOMPLETE TASKS</caption>
    <tr>

        <th>Created By:</th>
        <th>Created Date:</th>
        <th>Title</th>
        <th>Task</th>
        <th>Assigned To</th>
        <th>Deadline</th>
        <th>Status</th>
        <th colspan=2>Action</th>
    </tr>
    <c:forEach var="task" items="${list3}">
    <tr>
        <td><c:out value="${task.createdBy}"/></td>
        <td><c:out value="${task.createdDate}"/></td>
        <td><c:out value="${task.title}"/></td>
        <td><c:out value="${task.taskDesp}"/></td>
        <td><c:out value="${task.assignedTo}"/></td>
        <td><c:out value="${task.deadline}"/></td>
        <td><c:out value="${task.status}"/></td>
        <td>
            <a href="edit?taskId=<c:out value="${task.taskId}"/>&adminId=<%=request.getParameter("adminId")%>">Update</a>
        </td>
        <td>
            <a href="delete.jsp?taskId=<c:out value="${task.taskId}"/>&adminId=<%=request.getParameter("adminId")%>">Delete </a>
        </td>

        </c:forEach>
    </tr>
</table>
</body>
</html>
