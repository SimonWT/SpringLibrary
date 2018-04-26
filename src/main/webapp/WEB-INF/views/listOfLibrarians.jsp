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
    <title>List of Librarians | Deeplib</title>
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/bootstrap.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/font-awesome.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/welcomeform.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/admin.css">
<style>
    .ftable{
        width:80%;
        margin-left:10%;
        margin-top:4%;
        background: #d5d5d5;
    }
    .ftable th{
        color:#337ab7;
        font-size: 1.3vw;
        text-align: center;
    }
    .ftable td{
        color:#d58512;
        font-size:1.3vw;
        text-align: center;
    }
    .ftable a{
        color:#d58512;
    }
    .ftable a:hover{
        outline:none;
        text-decoration: none;
        color:black;
    }

</style>
</head>
<body>
<%@ include file ="topnav.jsp" %>
<div class = "ftable">
    <table class="table table-condensed">
        <thead>
        <tr>
            <th>ID</th>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Username</th>
            <th>Privilege</th>
            <th>Phone number</th>
            <th>Email</th>
            <th>Privilege</th>
            <th></th>
            <th></th>
        </tr>

        </thead>
        <tbody>

        <c:forEach items="${librarianList}" var="librarian">

        <tr>
        <td>${librarian.id}</td>
        <td>${librarian.name}</td>
        <td>${librarian.surname}</td>
        <td>${librarian.username}</td>
        <td>${librarian.privilege}</td>
        <td>${librarian.phone}</td>
        <td>${librarian.email}</td>
        <td>${librarian.privilege}</td>
            <td><a href="/editLibrarian/${librarian.id}">Edit</a></td>
            <td><a href="/deleteUser/${librarian.id}">Delete</a></td>
        </tr>

        </c:forEach>

        </tbody>

    </table>

</div>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
