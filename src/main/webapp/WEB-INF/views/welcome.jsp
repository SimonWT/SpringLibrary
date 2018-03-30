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

<div class="topnav" id="myTopnav">
    <a class="navbar-brand" class = "active" href = "/welcome">
            <span>
              <img alt="Brand" style="width: 33.5px"
                   src="http://hasintech.com/favicons/apple-touch-icon-57x57.png">
            </span>
        DeepLib

    </a>
    <div class  = "hell">
    <a href="/listOfAudioVideoMaterialForPatron" style = ""><i class="fa fa-file-audio-o" aria-hidden="true"></i>
        Media</a>
    <a href="/listOfArticlesForPatron" style = ""><i class="fa fa-newspaper-o" aria-hidden="true"></i>
        Journal Article</a>
    <a href="/listOfBooksForPatron" style = ""><i class="fa fa-book" aria-hidden="true"></i> Books</a>
    </div>
    <div class="dropdown2" >
        <button class="dropbtn"><i class="fa fa-user-circle-o" aria-hidden="true"></i>

        ${pageContext.request.userPrincipal.name}
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content2">
            <a href="/ProfilePage" data-toggle="modal" data-target="#largeModal"> <i class="fa fa-address-card-o" aria-hidden="true"></i>
                 Profile</a>
            <a href="/user">
                <i class="fa fa-bookmark" aria-hidden="true"></i>

                My Documents</a>


            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <a href = "#" onclick="document.forms['logoutForm'].submit()"> <i class="fa fa-sign-out" aria-hidden="true"></i>
                        Logout</a>
                </form>


            </c:if>
        </div>
    </div>



    <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
</div>
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
<script>
    function myFunction() {
        var x = document.getElementById("myTopnav");
        if (x.className === "topnav") {
            x.className += " responsive";
        } else {
            x.className = "topnav";
        }
    }
</script>


<div class="modal" id="largeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="cont">
            <div class="modal2">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <i class="fa fa-window-close-o" aria-hidden="true" style = "font-size:45px; padding-right:4px;"></i>
                </button>
                <br>
                <br>
                <div class="row">
                    <div class="cont1">
                        <span class = "photprof">
                    <img src="${contextPath}/resources/imgNew/user2.png" height = "auto"; width = "auto";>

                    <p style = "padding-left:25%; padding-top:5%;">ID: YARIKLOH</p>
                </span>
                    </div>
                    <div class="cont2">
                        <p>Katusha Uzbekova</p>
                        <a href="tel:+79177972480">89177972480</a>
                        <p><a href="mailto:e.uzbekova@innopolis.ru">
                            e.uzbekova@innopolis.ru</a></p>
                        <p>Universitetskaya </p>
                        <p>1-2,325</p>
                        <button  style = "background:#8a6d3b; outline:none; border: none; font-size:25px;"><a href="#" style = "color:#ddd8c4">
                            <i class="fa fa-bookmark" aria-hidden="true" style = "padding-right:5px;"></i>My Documents</a></button>
                    </div>
                </div>
                <div class = "row">
                <div class = "button1">
                    <button> <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                        Edit </button>
                </div>
                    <div class = "button2">
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <form id="logoutForm" method="POST" action="${contextPath}/logout">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <a href = "#" onclick="document.forms['logoutForm'].submit()"> <button ><i class="fa fa-sign-out" aria-hidden="true"></i>
                            Logout </button></a>
                    </form>


                </c:if>
                    </div>
                </div>
                <br>
                <br>
                <br>
                <br>
                <br>


                <br>
            </div>


        </div>
    </div>
</div>

<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
</body>
</html>