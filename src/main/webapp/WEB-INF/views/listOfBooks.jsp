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

    <title>Manage Books || DeepLib</title>

    <link rel="stylesheet" href="${contextPath}/resources/cssNew/bootstrap.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/font-awesome.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/loginform.css"></head>
<style>
    .ftable{
        width:60%;
        margin-left:20%;
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
<body>
<%@ include file ="topnav.jsp" %>

<div class = "ftable">
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
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${bookList}" var="av">
        <tr>
        <td>${av.title}</td>
        <td>${av.authors}</td>
        <td>${av.year}</td>
        <td>${av.publisher}</td>
        <td>${av.edition}</td>
        <td>${av.price}</td>
        <td>${av.copies}</td>
          <td>
              <c:if test="${av.bestSeller == false}" >
            </c:if>
            <c:if test="${av.bestSeller == true}" >
                <i class="fa fa-star" aria-hidden="true" style = "color: yellow; font-size: 2vw;"></i>

            </c:if>
        </td>
            <td><a href="/editBook/${av.id}">Edit</a> </td>
         <td>   <a href="/deleteBook/${av.id}">Delete</a></td>
        </tr>
        </c:forEach>

        </tbody>

    </table>
</div>


<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
<script src="${contextPath}/resources/jsNew/scripts.js"></script></body>
</html>
