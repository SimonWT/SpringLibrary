    xmlns:c="http://www.hibernate.org/xsd/hibernate-mapping" xmlns:c="http://www.hibernate.org/xsd/hibernate-mapping"
        xmlns:c="http://www.w3.org/1999/XSL/Transform"
        xmlns:c="http://www.w3.org/1999/XSL/Transform"
        xmlns:c="http://www.w3.org/1999/XSL/Transform"
        xmlns:c="http://www.w3.org/1999/XSL/Transform"
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

        <title>Books | DeepLib</title>
        <link rel="stylesheet" href="${contextPath}/resources/cssNew/bootstrap.css">
        <link rel="stylesheet" href="${contextPath}/resources/cssNew/font-awesome.css">
        <link rel="stylesheet" href="${contextPath}/resources/cssNew/welcomeform.css">
        <link rel="stylesheet" href="${contextPath}/resources/cssNew/listbook.css">


        </head>
        <body>
        <%@ include file="topnav.jsp" %>

        <form method="GET">
        <br>
        <br>
        <div class = "row">
        <div class = "one" style = "float:left; margin-left:2%;">

        </div>

        <c:forEach items="${bookList}" var="book">

            <button style = "background: #f44444; border:1px; height: 90px; text-align: center; width:50%;
            margin-left:calc(50%- 200px); color: #ddd8c4; font-size:13px;"
            type="button" data-toggle="modal"
            data-target="#my${book.id}">${book.title}</button>
            <br><br>

            <div id="my${book.id}" class="modal fade" >
            <div class="modal-dialog" style = "margin-left:calc(50%- 8px); width: 470px;">
            <div class="modal-content" >
            <div class="modal-body" style = "height:410px; background:#9d9d9d">
            <div class = "row" >
            <button class="close" type="button" data-dismiss="modal"><i class="fa fa-window-close-o" aria-hidden="true"
            style = "font-size:45px; padding-right:4px;"></i></button>
            <br>
            <br>
            <br>

            <div style = "float:left; margin-left:4px;"> <img src = "${contextPath}/resources/imgNew/images.png" style =
            "width:160px; height:200px;"></div>
            <div style = "float:right; margin-right:20%;">
            <p>ID: ${book.id}</p>
            <p>Title: ${book.title}</p>
            <p>Edition: ${book.edition} </p>
            <p>Authors: ${book.authors}</p>
            <p>Publisher: ${book.publisher} </p>
            <p>Publish Year: ${book.yearString} </p>
            </div>
            </div>
            <br>
            <br>
            <br>
            <div class = "row">

            <c:if test="${book.status==0}">
                <div style = "float:left; margin-left:4%;">
                <button><a href="/return/${book.id}">
                    Return back </a>
                </button>

                </div>
                <div style = "float:left; margin-left:4%">
                <button>
                Renew </button>
                </div>
            </c:if>

            <c:if test="${book.status==2}">
                <div style = "float:right; margin-right:4%">
                <button> Queue </button>
                </div>

            </c:if>

            <c:if test="${book.status==3}">
                <div style = "float:right; margin-right:4%">
               <button type="submit" ><a href="/booking/${book.id}"> Book </a></button>
                </div>

            </c:if>

            </div>

            </div>
            </div>
            </div>
            </div>

        </c:forEach>

        </form>
        <script src="${contextPath}/resources/jsNew/jquery.js"></script>
        <script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
        </body>
        </html>
