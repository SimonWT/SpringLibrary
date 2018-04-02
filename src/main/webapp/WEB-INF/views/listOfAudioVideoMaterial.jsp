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
    <title>Manage Users | Deeplib</title>

    <link rel="stylesheet" href="${contextPath}/resources/cssNew/bootstrap.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/font-awesome.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/loginform.css"></head>
<body>
<%@ include file ="topnav.jsp" %>

<form method="POST">
    <table class="table table-condensed">
        <thead>
        <tr>
            <th>Author</th>
            <th>Title</th>
            <th>Price</th>
            <th>Copies</th>
            <th>View</th>
        </tr>
        </thead>
        <tbody>


        <c:forEach items="${audioVideoList}" var="av">
        <tr>
        <td>${av.authors}</td>
        <td>${av.title}</td>
        <td>${av.price}</td>
        <td>${av.copies}</td>
        <td><a href="/editAudioVideo/${av.id}">Edit</a><a href="/deleteAudioVideo/${av.id}">Delete</a></td>
        </tr>
        </c:forEach>

        </tbody>

    </table>

</form>


<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
<script src="${contextPath}/resources/jsNew/scripts.js"></script>
</body>
</html>
