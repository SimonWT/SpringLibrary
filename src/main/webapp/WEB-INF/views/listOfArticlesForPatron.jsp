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

    <title>Articles || DeepLib</title>
    <link href="${contextPath}/resources/cssNew/listbook.css" rel="stylesheet">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/bootstrap.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/font-awesome.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/listbook.css">

</head>

<body>
<%@ include file ="topnav.jsp" %>

<div class = "book">
    <div class = "now">
    <c:if test="${empty articleList}">
        <div  class = "vp" style = "background:#d5d5d5; margin-top:5%; font-size:3vw; color: #d58512;  margin-left:3%; margin-right:3%; margin-bottom:5%;">
            <p> Now you can't access to  have documents.</p>
            <p> Choose new category of  document:</p>
            <br>
            <div class = "formoc">
                <a href="/listOfAudioVideoMaterialForPatron" style = ""><i class="fa fa-file-audio-o" aria-hidden="true"></i>
                    Media</a>
                <a href="/listOfBooksForPatron" style = ""><i class="fa fa-book" aria-hidden="true"></i> Books</a>
            </div>
            <br>
            <br>
        </div>

    </c:if>

        </div>
    <c:if test="${not empty articleList}">
    <br>
        <div  class = "search2">
            <p>Click on the article to get more information about it</p>
            <!--<input type="search" id="mySearch" style = "width:80%; font-size:2vw; text-align:center; outline:#d9534f; border:none;
border-radius: 17px;"
                   placeholder="Search book by keywords..." required>
            <button style = "">Search</button> !-->
        </div></c:if>
    <c:forEach items="${articleList}" var="article">
        <c:if test = "${articleList.indexOf(article) % 3 == 0}">

        <button
                type="button" data-toggle="modal" class = "need2"
                data-target="#my${article.id}">
            <div class = "insi" style = " border:none; border-radius:14px;background:white; text-align:center;margin-top:37%; height:80px; margin-bottom:32%;">
                <p style = ""> ${article.title} </p>

            </div>
        </button>
        </c:if>
    <c:if test = "${articleList.indexOf(article) % 3 == 1}">

        <button
                type="button" data-toggle="modal" class = "need2"
                data-target="#my${article.id}">
            <div class = "insi" style = " border:none; border-radius:14px;background:white;text-align:center;margin-top:37%; height:80px; margin-bottom:32%;">
                <p> ${article.title}  </p>
            </div>
        </button>
    </c:if>
    <c:if test = "${articleList.indexOf(article) % 3 == 2}">

        <button
                type="button" data-toggle="modal" class = "need2"
                data-target="#my${article.id}">
            <div class = "insi" style = " border:none; border-radius:14px; text-align:center;background:white; margin-top:37%; height:80px; margin-bottom:32%;">
                <p> ${article.title} </p>
            </div>
        </button>
    </c:if>

        <div id="my${article.id}" class="modal fade"  >
            <div class="modal-dialog">

                <div class = "modal-body" style = "width:100%; border:none; border-radius:20px;">

                            <div class = "hate">
                                <br>
                                <p>ID: <p1> ${article.id}</p1> </p>
                                <p>Title:<p1> ${article.title}</p1> </p>
                                <p>Authors: <p1> ${article.authors}</p1> </p>
                                <p>Journal: <p1>${article.journal}</p1> </p>
                                <p>Editors: <p1> ${article.editors}</p1> </p>
                                <p>Date: <p1> ${article.dateString}</p1> </p>
                                <p>Price: <p1> ${article.price}</p1></p>
                                <p>Copies:<p1> ${article.copies}</p1></p>
                                <br>
                            </div>

                        <br>
                        <div class = "row">
                            <c:if test="${article.status==0 || article.status==2}">
                                <div style = "width:45%;float:left; margin-left:4%;">
                                    <button style = "width:100%;"><a href="/return/${article.id}" style = "font-size:2vw; text-decoration: none; color:#d58512;" >
                                        Return back </a>
                                    </button>

                                </div>
                                <div style = "width:45%;float:right; margin-right:4%">
                                    <button style = "width:100%;  color: #d58512"><a href="/renew/${article.id}" style = "font-size:2vw; text-decoration:none; color:#d58512">
                                        Renew </a></button>
                                </div>
                            </c:if>

                            <c:if test="${article.status==4}" >
                                <div style = "text-align: center; font-size:70%;">
                                    <button class = "name" style = "width:80%;"><a  style = "text-decoration: none;" href = "/queue/${article.id}">
                                        Queue </a>  </button>
                                </div>
                            </c:if>

                            <c:if test="${article.status==1}" >
                                <div style = "text-align: center; font-size:70%;">
                                    <button class = "name" style = "width:80%;  text-align:center;"><a style = "text-decoration: none;"href="/booking/${article.id}"> Check Out </a>
                                    </button>
                                </div>
                            </c:if>

                        <c:if test="${article.status == 3}">
                            Here list of <a class = "ab" href = "/viewQueue/${article.id}" style = ""> Queue </a>
                        </c:if>

                        </div>

                    </div>
            </div>
        </div>

    </c:forEach>
</div>




<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
<script src="${contextPath}/resources/jsNew/scripts.js"></script>
</body>
</html>
