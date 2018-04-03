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


        <c:forEach items="${audioVideoList}" var="av">
            <div style = "background: #ddd8c4; margin-left:calc(50%- 6px);width:50%">
                <img src ="${contextPath}/resources/imgNew/logo7.png" width = 20% height = 10%>
        <p>${av.authors}</p>
        <p>${av.title}</p>
        <p>${av.price}</p>
        <p>${av.copies}</p>
        <p><a href="/editAudioVideo/${av.id}">Edit</a><a href="/deleteAudioVideo/${av.id}">Delete</a></p>
            </div>
            <br>
        </c:forEach>
</form>


<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
<script src="${contextPath}/resources/jsNew/scripts.js"></script>
</body>
</html>
