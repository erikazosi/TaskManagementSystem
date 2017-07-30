<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 7/24/2017
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<%@ include file="Logout.jsp" %>

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
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Edit</title>
</head>
<body>

<h1>Edit Form</h1>
<form action="/edit" method="post">

    <c:forEach var="task" items="${list}">
        <input type="hidden" name="adminId" value="<%=request.getParameter("adminId")%>"/>
        <input type="hidden" name="taskId" value="<%=request.getParameter("taskId")%>"/>
        <label>Title:</label><input type="text" name="title" value="<c:out value="${task[1]}"/>"/><br><br>
        <label>Task:</label><input type="text" name="taskDesp" value="<c:out value="${task[0]}"/>"/><br><br>
        <%--<label>Deadline:</label><input type="date" name="Deadline" value="<c:out value="${task[2]}"/>"/><br><br>--%>

    </c:forEach>

    <input type="submit" value="Edit Task"/></td>


</form>
</body>

</html>
