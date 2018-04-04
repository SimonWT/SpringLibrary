<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin Page | DeepLib</title>
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/bootstrap.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/font-awesome.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/welcomeform.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/admin.css">


</head>
<body style = "height:320px;">
<%@ include file ="topnav.jsp" %>

<br>

<div class="search">
    <input type="search" id="mySearch" name="q"
           placeholder="Search the document..." required>
    <button>Search</button>
</div>
<br>
<br>
<div class="container">

    <div class="alert2" align = "center">

        <div class = "row" >
           <a href="/registration" > <button  class = "form1" >Register somebody  </button></a>
            <a href="/listOfUsers"> <button class = "form2">View users</button> </a>
        </div>
        <br>
        <div class = "row" >
            <a href="/addnewdocument"> <button  class = "form3" >Add New Document  </button></a>
        </div>
        </div>
    </div>
</div>

<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
<script src="${contextPath}/resources/jsNew/scripts.js"></script>
</body>
</html>