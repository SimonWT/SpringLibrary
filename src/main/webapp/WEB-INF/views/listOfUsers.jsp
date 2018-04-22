<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="org.springframework.jdbc.datasource.DriverManagerDataSource" %><%--
  Created by IntelliJ IDEA.
  Users: Igor
  Date: 02-Mar-18
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>List of users</title>
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/bootstrap.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/font-awesome.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/welcomeform.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/admin.css">

    </head>
<body>
<%@ include file ="topnav.jsp" %>

<form method="POST">
<table class="table table-condensed">
    <thead>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Phone number</th>
        <th>Email</th>
        <th>adress</th>
        <th>Type</th>
        <th>View</th>
    </tr>
    </thead>
    <tbody>

<c:forEach items="${listUser}" var="user">

    <tr>
    <td>${user.id}</td>
    <td>${user.username}</td>
    <td>${user.name}</td>
    <td>${user.surname}</td>
    <td>${user.phone}</td>
    <td>${user.email}</td>
    <td>${user.address}</td>
    <td>${user.type}</td>
    <td>

    <td><a href="/editUser/${user.id}">Modify</a><a href="/deleteUser/${user.id}">Delete</a></td>

    </tr>
</c:forEach>
    </tbody>

</table>
</form>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
