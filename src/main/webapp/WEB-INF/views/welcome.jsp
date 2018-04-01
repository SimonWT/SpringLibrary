<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Home page | DeepLib</title>
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/bootstrap.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/font-awesome.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/welcomeform.css">
    <style>

    </style>
</head>
<body>
<%@ include file ="topnav.jsp" %>


<br>
<br>
<br>
<br>
<div class="container">

    <div class="alert" align = "center">
   <strong style = "font-size:37px">
${pageContext.request.userPrincipal.name}</strong>,
        <br>
        Welcome to DeepLib!
    <br>
        <br>
        <input type="search" id="mySearch" name="q"
               placeholder="Search the document..." required>
        <button>Search</button>
        <br>
        <br>
        <h5 style = "font-size:25px;">How to use this sourse:</h5>
        <i class="fa fa-square" aria-hidden="true"></i> Go to Media/Jornal Articles/Books and choose document, which you want.
    <br>
        <i class="fa fa-square" aria-hidden="true"></i> Also you can find documents by using searching .
        <br><i class="fa fa-square" aria-hidden="true"></i>
        The application support different search criteria(e.g., by author, by title)<br> and combinations

        of these search strategies.
        <br><i class="fa fa-square" aria-hidden="true"></i>
        Books are checked out for three weeks, unless:
        <br><i class="fa fa-circle-o-notch" aria-hidden="true"></i>

        they are current best sellers, in which case the limit is two weeks
        <br><i class="fa fa-circle-o-notch" aria-hidden="true"></i>

        they are checked out by a faculty member, in which case
        <br>
        the limit is 4 weeks (regardless the book is best seller)
        <br><i class="fa fa-square" aria-hidden="true"></i>
        AV materials and journals may be checked out for two weeks.
        <br><i class="fa fa-square" aria-hidden="true"></i>
        The overdue fine is a hundred rubles per item per day,<br> but cannot be higher than the value of the overdue item
        <br><i class="fa fa-square" aria-hidden="true"></i>
        You can renew an item once (and only once), unless <br> there is an outstanding request for the item, in which case
       <br> <i class="fa fa-square" aria-hidden="true"></i>
        the item needs to be returned immediately
        <br>
        <br>
        <br>
    </div>
</div>



<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
</body>
</html>