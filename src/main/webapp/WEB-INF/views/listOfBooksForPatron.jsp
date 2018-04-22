
        <%@ page import="java.sql.Connection" %>
        <%@ page import="java.sql.DriverManager" %>
        <%@ page import="java.sql.Statement" %>
        <%@ page import="java.sql.ResultSet" %>
        <%@ page import="org.springframework.jdbc.datasource.DriverManagerDataSource" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>

        <!DOCTYPE html>
        <html lang="en">
        <csrf disabled="true" />
        <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Books || DeepLib</title>
        <link rel="stylesheet" href="${contextPath}/resources/cssNew/bootstrap.css">
        <link rel="stylesheet" href="${contextPath}/resources/cssNew/font-awesome.css">
        <link rel="stylesheet" href="${contextPath}/resources/cssNew/welcomeform.css">
        <link rel="stylesheet" href="${contextPath}/resources/cssNew/listbook.css">


        </head>
        <body>
        <%@ include file="topnav.jsp" %>
        <div class = "book">
            <br>
            <div class = "search2">

            <input type="search" id="mySearch" style = "width:80%; font-size:2vw; text-align:center; outline:#d9534f; border:none;
border-radius: 17px;"
                   placeholder="Search book by keywords..." required>
            <button style = "">Search</button>
            <br>
            </div>
        <c:forEach items="${bookList}" var="book">
            <c:if test = "${bookList.indexOf(book) % 4 == 0}">

            <button
            type="button" data-toggle="modal"
            data-target="#my${book.id}">
                    <br>
                    <br>
                <br>
            <br>
                <br>
            <br>
                <br>
            </button>
            </c:if>
            <c:if test = "${bookList.indexOf(book) % 4 == 1}">

                <button
                        type="button" data-toggle="modal"
                        data-target="#my${book.id}">
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                </button>
            </c:if>
            <c:if test = "${bookList.indexOf(book) % 4 == 2}">

                <button
                        type="button" data-toggle="modal"
                        data-target="#my${book.id}">
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                </button>
            </c:if>
            <c:if test = "${bookList.indexOf(book) % 4 == 3}">

                <button
                        type="button" data-toggle="modal"
                        data-target="#my${book.id}">
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                </button>
            </c:if>
            <div id="my${book.id}" class="modal fade"  >
                <div class="modal-dialog">

                    <div class = "modal-body" style = "width:100%">
                        <div class = "row" >
                            <br>


                            <div style = "float:left; margin-left:6%; width:40%;">
                                <img src = "${contextPath}/resources/imgNew/viewb.jpg" style =
                                        "width:150%; height:57%;"></div>
                            <div style = "float:right; margin-right:4%; color:#d58512; font-size:1vw;">
                                <br>
                                <p>ID: ${book.id}</p>
                                <p>Title: ${book.title}</p>
                                <p>Authors: ${book.authors}</p>
                                <p>Price: ${book.price}</p>
                                <p>Copies: ${book.copies}</p>
                            </div>
                        </div>
                        <br>
                        <div class = "row">

                            <c:if test="${book.status==0 || book.status==2}">
                                <div style = "width:45%;float:left; margin-left:4%;">
                                    <button style = "width:100%;"><a href="/return/${book.id}" style = "font-size:2vw; text-decoration: none; color:#d58512;" >
                                        Return back </a>
                                    </button>

                                </div>
                                <div style = "width:45%;float:right; margin-right:4%">
                                    <button style = "width:100%; float:right; font-size:2vw; color: #d58512"><a href="/renew/${book.id}" style = "font-size:2vw; text-decoration:none; color:#d58512">
                                        Renew </a></button>
                                </div>
                            </c:if>

                            <c:if test="${book.status==4}" >
                                <div style = "float:right; margin-right: 3%; width:45%;">
                                    <button><a href = "/queue/${book.id}">
                                        Queue </a>  </button>
                                </div>
                            </c:if>

                            <c:if test="${book.status==1}" >
                                <div style = "text-align: center; font-size:70%;">
                                    <button class = "name" style = "width:80%; text-align:center;"><a style = "text-decoration: none;"href="/booking/${book.id}"> Check Out </a>
                                    </button>
                                </div>
                            </c:if>

                            <c:if test="${book.status == 3}">
                                Here list of <a class = "ab" href = "/viewQueue/${book.id}" style = ""> Queue </a>
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

