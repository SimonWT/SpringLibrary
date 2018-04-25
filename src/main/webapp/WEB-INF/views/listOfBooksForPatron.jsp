
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
            <div class = "now">
                <c:if test="${empty bookList}">
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
            <c:if test="${not empty bookList}">
                <div  class = "search2">
                    <p>Click on the book to get more information about it</p>
                    <!--<input type="search" id="mySearch" style = "width:80%; font-size:2vw; text-align:center; outline:#d9534f; border:none;
        border-radius: 17px;"
                           placeholder="Search book by keywords..." required>
                    <button style = "">Search</button> !-->
                    <br>
                </div></c:if>

        <c:forEach items="${bookList}" var="av">
            <c:if test = "${bookList.indexOf(av) % 3 == 0}">

            <button
            type="button" data-toggle="modal" class = "need"
            data-target="#my${av.id}">
            <div class = "insi" style = " border:none; border-radius:14px; text-align:center;background:white; margin-top:37%; height:80px; margin-bottom:32%;">
                <p style = ""> ${av.title} </p>
            </div>
            </button>
            </c:if>
            <c:if test = "${bookList.indexOf(av) % 3 == 1}">

                <button
                        type="button" data-toggle="modal" class = "need"
                        data-target="#my${av.id}">
                    <div class = "insi" style = " border:none; border-radius:14px;  text-align:center;background:white; margin-top:37%; height:80px; margin-bottom:32%;">
                        <p> ${av.title} </p>
                    </div>
                </button>
            </c:if>
            <c:if test = "${bookList.indexOf(av) % 3 == 0}">

                <button
                        type="button" data-toggle="modal" class = "need"
                        data-target="#my${av.id}">
                    <div class = "insi" style = " border:none; border-radius:14px;  text-align:center;background:white; margin-top:37%; height:80px; margin-bottom:32%;">
                        <p> ${av.title} </p>
                    </div>
                </button>
            </c:if>
            <div id="my${av.id}" class="modal fade"  >
                <div class="modal-dialog">

                    <div class = "modal-body" style = "width:100%; border:none; border-radius:20px;">
                            <br>

                            <div class = "hate" style = "">
                                <br>
                                <p>ID: <p1>${av.id}</p1></p>
                                <p>Title: <p1>${av.title}</p1></p>
                                <p>Authors:<p1>${av.authors}</p1></p>
                                <p>Price: <p1>${av.price}</p1></p>
                                <p>Copies: <p1>${av.copies}</p1></p>
                                <br>
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
                                    <button style = "width:100%; float:right; font-size:2vw; color: #d58512"><a href="/renew/${book.id}" style = "font-size:2vw; text-decoration:none; color:#d58512">
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

