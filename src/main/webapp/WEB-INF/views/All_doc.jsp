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

    <title>All_doc || DeepLib</title>
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/bootstrap.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/font-awesome.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/welcomeform.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/listbook.css">

</head>

<body>
<%@ include file="topnav.jsp" %>
<div class = "book">
    <br>
    <c:forEach items="${bookList}" var="av">

            <button
                    type="button" data-toggle="modal" class = "need"
                    data-target="#my${av.id}">
                <div class = "insi" style = " border:none; border-radius:14px; text-align:center;background:white; margin-top:37%; height:80px; margin-bottom:32%;">
                    <p style = ""> ${av.title} </p>
                </div>
            </button>
        <div id="my${av.id}" class="modal fade"  >
            <div class="modal-dialog">

                <div class = "modal-body" style = "width:100%; border:none; border-radius:20px;">
                    <br>

                    <div class = "hate" style = "">
                        <br>
                        <p><a href="/editArticle/${article.id}">Edit</a></p>
                        <p><a href="/deleteArticle/${article.id}">Delete</a></p>
                        <p>ID: <p1>${av.id}</p1></p>
                        <p>Title: <p1>${av.title}</p1></p>
                        <p>Authors:<p1>${av.authors}</p1></p>
                        <p>Price: <p1>${av.price}</p1></p>
                        <p>Copies: <p1>${av.copies}</p1></p>
                        <br>
                    </div>
                    <br>

        </div>
            </div>
        </div>

    </c:forEach>
<c:forEach items="${articleList}" var="article">

        <button
                type="button" data-toggle="modal" class = "need2"
                data-target="#my${article.id}">
            <div class = "insi" style = " border:none; border-radius:14px;background:white;text-align:center;margin-top:37%; height:80px; margin-bottom:32%;">
                <p> ${article.title}  </p>
            </div>
        </button
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
            </div>
        </div>
    </div>
</c:forEach>
    <c:forEach items="${audioVideoList}" var="av">
    <button
            type="button" data-toggle="modal" class = "need3"
            data-target="#my${av.id}">
        <div class = "insi" style = " border:none; border-radius:14px; text-align:center;background:white; margin-top:30%; height:80px; margin-bottom:40%;">
            <p> ${av.title} </p>
        </div>
    </button>

    <div id="my${av.id}" class="modal fade"  >
        <div class="modal-dialog">
            <div class = "modal-body" style = "width:100%; border:none; border-radius:20px;">

                <div class = "hate" style = "border-radius:7px;margin-top:2%;">
                    <p>Title: <p1>${av.title}</p1> </p>
                    <br>
                    <p>Authors: <p1>${av.authors}</p1></p>
                </div>



                <br>
            </div>
        </div>

        </c:forEach>
</div>



<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
<script src="${contextPath}/resources/jsNew/scripts.js"></script></body>
</html>
