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
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/mydoc.css"></head>
<body>
<%@ include file ="topnav.jsp" %>
<br>
<br>
<div class = "table">
<div class = "now">
<div class = "b" style = "">My Documents</div>
    <c:if test= "${empty openHistories}">
        <div style = "background: #d4d4d4">
            <br>
            <br>
        </div>
        <div  class = "vp" style = "background:#d5d5d5; margin-top:5%;  margin-left:3%; margin-right:3%; margin-bottom:5%;">
            <p> Now you don't have documents.</p>
            <p> Choose new document:</p>
            <br>
            <div class = "formoc">
                <a href="/listOfAudioVideoMaterialForPatron" style = ""><i class="fa fa-file-audio-o" aria-hidden="true"></i>
                    Media</a>
                <a href="/listOfArticlesForPatron" style = ""><i class="fa fa-newspaper-o" aria-hidden="true"></i>
                    Journal Article</a>
                <a href="/listOfBooksForPatron" style = ""><i class="fa fa-book" aria-hidden="true"></i> Books</a>
            </div>
            <br>
            <br>
        </div>
    </c:if>
    <c:forEach items="${openHistories}" var="history">
        <c:if test="${openHistories.indexOf(history) % 2 == 0}">
            <div style = "background: #d4d4d4">
                <br>
                <br>
            </div>
        </c:if>
        <c:if test = "${openHistories.indexOf(history) % 2 == 0}">
            <div style = "float:left; margin-left:5%; width:43%; border: none; border-radius:17px;background: #d4d4d4; margin-top:5%; margin-bottom:5%;">
        <br>
        <p>Title: ${history.document.title}</p>
        <p>Authors: ${history.document.authors}</p>
        <p>Check out date: ${history.checkOutDate}</p>
        <p>Deadline of return: ${history.returnDate}</p>

        <c:if test="${history.penaltyDays > 0}">
            <p>Penalty days: ${history.penaltyDays}</p>
            <p>Fine: </p>
        </c:if>
                <div class = "b2">
        <button><a href="/return/${history.document.id}">
            Return back </a>
        </button>
                </div>

<br>
            </div>
        </c:if>
        <c:if test = "${openHistories.indexOf(history) % 2 == 1}">
            <div style = "float:right; margin-right:5%;width:43%; border:none; border-radius: 17px; background: #d4d4d4; margin-top:5%; margin-bottom:5%;">
                <br>
                <p>Title: ${history.document.title}</p>
                <p>Authors: ${history.document.authors}</p>
                <p>Check out date: ${history.checkOutDate}</p>
                <p>Deadline of return: ${history.returnDate}</p>

                <c:if test="${history.penaltyDays > 0}">
                    <p>Penalty days: ${history.penaltyDays}</p>
                    <p>Fine: </p>
                </c:if>
                <div class = "b2">
                <button ><a href="/return/${history.document.id}">
                    Return back </a>
                </button>
                </div>
                <br>
            </div>
        </c:if>
    </c:forEach>
</div>

<div class = "after" style = "">
    <div class = "b" style = "font-family: 'Cambria Math'">History</div>
    <c:if test= "${empty closeHistories}">
        <div style = "background: #d4d4d4">
            <br>
            <br>
        </div>
        <div  class = "vp" style = "background:#d5d5d5; margin-top:5%;  margin-left:3%; margin-right:3%; margin-bottom:5%;">
            <br>
            <br>
            <p> User story is empty</p>
            <br>
            <br>
        </div>
    </c:if>
    <c:forEach items="${closeHistories}" var="history">
        <div style = "background: #d4d4d4">
            <br>
            <br>
        </div>
        <div class = "closeh">
            <br>
        <p>Title: ${history.document.title}</p>
        <p>Authors: ${history.document.authors}</p>
        <p>Check out date: ${history.checkOutDate}</p>
        <p>Returned date: ${history.returnDate}</p>
        <c:if test="${history.penaltyDays > 0}">
            <p>Penalty days: ${history.penaltyDays}</p>
            <p>Fine: ${history.document.fine} </p>
        </c:if>
        <div class = "b2">
            <button  type="submit"><a style = "outline:none;" href="/booking/${history.document.id}"> Check Out </a></button>
        </div>
        <br>
        </div>

    </c:forEach>

</div>
<br>
<br>

                <div>

                </div>











<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
<script src="${contextPath}/resources/jsNew/scripts.js"></script></body>
</html>