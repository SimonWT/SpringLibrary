
<%--
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

    <title>All Articles | DeepLib</title>
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/bootstrap.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/font-awesome.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/loginform.css">

</head>

<body>
<%@ include file ="topnav.jsp" %>

<form method="POST">

    <table class="table table-condensed">
        <thead>
        <tr>
            <th>Title</th>
            <th>Journal</th>
            <th>Authors</th>
            <th>Editors</th>
            <th>Date</th>
            <th>Price</th>
            <th>Copies</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${articleList}" var="article">
        <tr>
        <td>${article.title}</td>
        <td>${article.journal}</td>
        <td>${article.authors}</td>
        <td>${article.editors}</td>
        <td>${article.date}</td>
        <td>${article.price}</td>
        <td>${article.copies}</td>
        <td><a href="/editArticle/${article.id}">Edit</a><a href="/deleteArticle/${article.id}">Delete</a></td>
        </tr>
        </c:forEach>

        </tbody>

    </table>


</form>

<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
<script src="${contextPath}/resources/jsNew/scripts.js"></script></body>
</html>
