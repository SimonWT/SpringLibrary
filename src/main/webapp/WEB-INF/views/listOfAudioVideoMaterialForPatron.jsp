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

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Audio & Video || DeepLib</title>
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/bootstrap.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/font-awesome.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/welcomeform.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/listbook.css">

</head>
<body>
<%@ include file ="topnav.jsp" %>
<div class = "book">
    <br>
    <div class = "search2">

        <input type="search" id="mySearch" style = "width:80%; font-size:2vw; text-align:center; outline:#d9534f; border:none;
border-radius: 17px;"
               placeholder="Search media by keywords..." required>
        <button style = "">Search</button>
        <br>
    </div>
    <c:forEach items="${audioVideoList}" var="av">
        <c:if test = "${audioVideoList.indexOf(av) % 4 == 0}">

            <button
                    type="button" data-toggle="modal"
                    data-target="#my${av.id}">
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
            </button>
        </c:if>
        <c:if test = "${audioVideoList.indexOf(av) % 4 == 1}">

            <button
                    type="button" data-toggle="modal"
                    data-target="#my${av.id}">
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
            </button>
        </c:if>
        <c:if test = "${audioVideoList.indexOf(av) % 4 == 2}">

            <button
                    type="button" data-toggle="modal"
                    data-target="#my${av.id}">
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
            </button>
        </c:if>
        <c:if test = "${audioVideoList.indexOf(av) % 4 == 3}">

            <button
                    type="button" data-toggle="modal"
                    data-target="#my${av.id}">
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
            </button>
        </c:if>

        <div id="my${av.id}" class="modal fade"  >
            <div class="modal-dialog">
                <div class = "modal-body" style = "width:100%">
                    <div class = "row" >
                        <br>


                        <div style = "float:left; margin-left:6%; width:40%;">
                            <img src = "${contextPath}/resources/imgNew/audio.jpg" style =
                                    "width:150%; height:57%;"></div>
                        <div style = "float:right; width:27%; height:57%;margin-right:4%; color:#d58512; font-size:1vw;">
                            <div style = "margin-top:100%;">
                            Title: ${av.title}
                            <br>
                            Authors: ${av.authors}
                            </div>
                        </div>

                    </div>
                    <br>
                    <div class = "row">

                        <c:if test="${av.status==0}" >
                            <div style = "float:left; margin-left:3%; width:45%">
                                <button style = "width:100%;"><a href="/return/${av.id}" style = "font-size:2vw; text-decoration: none; color:#d58512;" >
                                    Return back </a>
                                </button>

                            </div>
                            <div style = "float:right; margin-right: 3%; width:45%;">
                                <button style = "width:100%; float:right; font-size:2vw; color: #d58512" >
                                    Renew </button>
                            </div>

                        </c:if>

                        <c:if test="${av.status==2}" >
                            <div style = "float:right; margin-right:4%">
                                <form action="/queue/${av.id}">
                                    <button >
                                        Queue  </button>
                                </form>>
                            </div>
                        </c:if>

                        <c:if test="${av.status==3}" >
                            <div style = "text-align: center; font-size:70%;">
                                <button class = "name" style = "width:80%; text-align:center;"><a style = "text-decoration: none;"href="/booking/${av.id}"> Check Out </a>
                                </button>
                            </div>

                        </c:if>
                    </div>

                </div>
            </div>
        </div>

    </c:forEach>
</div>


<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
</body>
</html>