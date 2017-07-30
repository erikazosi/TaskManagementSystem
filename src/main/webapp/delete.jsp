<%@ page import="org.hibernate.Query" %>
<%@ page import="com.tms.utils.Connect" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.cfg.AnnotationConfiguration" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 7/27/2017
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>

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
<%

    SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
    org.hibernate.Session s = sf.openSession();
    s.beginTransaction();

    System.out.println(request.getParameter("taskId"));
    Query query=s.createQuery("delete from Task where id="+request.getParameter("taskId"));

    query.executeUpdate();

    response.sendRedirect("/Sdashboard?adminId=" + request.getParameter("adminId"));

    s.getTransaction().commit();
    s.close();

%>

</body>
</html>
