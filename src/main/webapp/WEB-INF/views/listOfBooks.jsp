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

    <title>All Books | DeepLib</title>

    <link rel="stylesheet" href="${contextPath}/resources/cssNew/bootstrap.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/font-awesome.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/loginform.css"></head>
<body>
<%@ include file ="topnav.jsp" %>

<form method="POST">
    <table class="table table-condensed">
        <thead>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Publication Date</th>
            <th>Publisher</th>
            <th>Edition</th>
            <th>Price</th>
            <th>Copies</th>
            <th></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${bookList}" var="book">
        <tr>
        <td>${book.title}</td>
        <td>${book.authors}</td>
        <td>${book.year}</td>
        <td>${book.publisher}</td>
        <td>${book.edition}</td>
        <td>${book.price}</td>
        <td>${book.copies}</td>
          <td>  <c:if test="${book.bestSeller == true}" >
            </c:if>
            <c:if test="${book.bestSeller == false} " >
                <i class="fa fa-star" aria-hidden="true" style = "background: yellow"></i>

            </c:if>
        </td
        <td><a href="/editBook/${book.id}">Edit</a>
            <a href="/deleteBook/${book.id}">Delete</a></td>
        </tr>
        </c:forEach>

        </tbody>

    </table>

</form>


<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
<script src="${contextPath}/resources/jsNew/scripts.js"></script></body>
</html>
