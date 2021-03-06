<%--
  Created by IntelliJ IDEA.
  User: Катя
  Date: 01.04.2018
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/bootstrap.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/font-awesome.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/welcomeform.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/admin.css">
    <title>Add New Document | DeepLib</title>
</head>
<body style = "height:700px;">

<%@ include file ="topnav.jsp" %>

<br>

<br>
<br>
<div class="container">

    <div class="alert2" align = "center">
        <sec:csrfMetaTags/>
        <div class = "row" >
            <a href="/addArticle" > <button style = "border: none !important;
  border-radius: 17px;text-decoration:none;" class = "form1" > New Article </button></a>
             <button class = "form2" style = "border: none !important;
  border-radius: 17px; text-decoration:none"> <a  style = "text-decoration: none; color:black; outline:none;" href="/addBook"> New Book </a> </button>
            <br>
            <br>
            <a href="/addAudioVideoMaterial"> <button class = "form4" style = "border: none !important;
  border-radius: 17px; text-decoration:none;"> New Media </button></a>
        </div>
    </div>
</div>

</div>



<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>

<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
<script src="${contextPath}/resources/jsNew/scripts.js"></script>
</body>
</html>
