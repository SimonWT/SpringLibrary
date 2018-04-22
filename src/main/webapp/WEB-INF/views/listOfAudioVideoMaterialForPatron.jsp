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
    <div class = "now">
        <c:if test="${empty audioVideoList}">
            <div  class = "vp" style = "background:#d5d5d5; margin-top:5%; font-size:3vw; color: #d58512;  margin-left:3%; margin-right:3%; margin-bottom:5%;">
                <p> Now you can't access to  have documents.</p>
                <p> Choose new category of  document:</p>
                <br>
                <div class = "formoc">
                    <a href="/listOfAudioVideoMaterialForPatron" style = ""><i class="fa fa-file-audio-o" aria-hidden="true"></i>
                        Media</a>
                    <a href="/listOfArticlesForPatron" style = ""><i class="fa fa-newspaper-o" aria-hidden="true"></i>
                        Journal Article</a>
                </div>
                <br>
                <br>
            </div>

        </c:if>

    </div>
    <c:if test="${not empty audioVideoList}">
    <br>
    <div  class = "search2">

        <p>Click on the av to get more information about it</p>
        <!--<input type="search" id="mySearch" style = "width:80%; font-size:2vw; text-align:center; outline:#d9534f; border:none;
border-radius: 17px;"
               placeholder="Search book by keywords..." required>
        <button style = "">Search</button> !-->
        <br>
    </div></c:if>

    <c:forEach items="${audioVideoList}" var="av">
    <c:if test = "${audioVideoList.indexOf(av) % 3 == 0}">

    <button
            type="button" data-toggle="modal" class = "need3"
            data-target="#my${av.id}">
        <div class = "insi" style = " border:none; border-radius:14px;background:white; margin-top:44%; margin-bottom:44%">
            <p style = ""> ${av.title} </p>
        </div>
    </button>
    </c:if>
    <c:if test = "${audioVideoList.indexOf(av) % 3 == 1}">

    <button
            type="button" data-toggle="modal" class = "need3"
            data-target="#my${av.id}">
        <div class = "insi" style = " border:none; border-radius:14px;background:white; margin-top:44%; margin-bottom:44%">
            <p> ${av.title} </p>
        </div>
    </button>
    </c:if>
    <c:if test = "${audioVideoList.indexOf(av) % 3 == 2}">

    <button
            type="button" data-toggle="modal" class = "need3"
            data-target="#my${av.id}">
        <div class = "insi" style = " border:none; border-radius:14px;background:white; margin-top:44%; margin-bottom:44%">
            <p> ${av.title} </p>
        </div>
    </button>
    </c:if>

        <div id="my${av.id}" class="modal fade"  >
            <div class="modal-dialog">
                <div class = "modal-body" style = "width:100%; border:none; border-radius:20px;">

                        <div class = "hate" style = "border-radius:7px;margin-top:2%;">
                            <p>Title: <p1>${av.title}</p1> </p>
                            <br>
                            <p>Authors: <p1>${av.authors}</p1></p>
                            </div>



                    <br>
                    <div class = "row">

                        <c:if test="${av.status==0 || av.status==2}">
                            <div style = "width:45%;float:left; margin-left:4%;">
                                <button style = "width:100%;"><a href="/return/${av.id}" style = "font-size:2vw; text-decoration: none; color:#d58512;" >
                                    Return back </a>
                                </button>

                            </div>
                            <div style = "width:45%;float:right; margin-right:4%">
                                <button style = "width:100%;  color: #d58512"><a href="/renew/${av.id}" style = "font-size:2vw; text-decoration:none; color:#d58512">
                                    Renew </a></button>
                            </div>
                        </c:if>

                        <c:if test="${av.status==4}" >
                            <div style = "text-align: center; font-size:70%;">
                                <button class = "name" style = "width:80%;"><a  style = "text-decoration: none;" href = "/queue/${av.id}">
                                    Queue </a>  </button>
                            </div>
                        </c:if>

                        <c:if test="${av.status==1}" >
                            <div style = "text-align: center; font-size:70%;">
                                <button class = "name" style = "width:80%;  text-align:center;"><a style = "text-decoration: none;"href="/booking/${av.id}"> Check Out </a>
                                </button>
                            </div>
                        </c:if>

                        <c:if test="${av.status == 3}">
                            Here list of Queue
                        </c:if>


                                </div>
                            </div>
                        </div>

    </c:forEach>
</div>


<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
</body>
</html>