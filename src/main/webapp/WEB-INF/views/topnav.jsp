<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/listbook.css">

    <script src="${contextPath}/resources/jsNew/jquery.js"></script>
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

    <c:choose>


        <c:when test="${user.type=='Librarian'}">
            <div class  = "hell2">
                <a href="/listOfAudioVideoMaterial" style = ""><i class="fa fa-file-audio-o" aria-hidden="true"></i>
                    Media</a>
                <a href="/listOfArticles" style = ""><i class="fa fa-newspaper-o" aria-hidden="true"></i>
                    Journal Article</a>
                <a href="/listOfBooks" style = ""><i class="fa fa-book" aria-hidden="true"></i> Books</a>
                <a href="/admin" style = ""><i class="fa fa-user-secret" aria-hidden="true"></i> ADMINKA</a>
                <a href="/listOfAllDocuments" style = ""><i class="fa fa-user-secret" aria-hidden="true"></i> Outstanding</a>

            </div>
        </c:when>

        <c:when test="${user.type == 'Admin'}">
            <div class = "hell">
                <a href="/registerLibrarian" style = ""><i class="fa fa-plus" aria-hidden="true"></i>
                    Add new Librarian</a>
                <a href="/Logs" style = ""><i class="fa fa-history" aria-hidden="true"></i>
                    Logs</a>
                <a href = "/listOfLibrarians"><i class = "fa fa-users"></i>Admins</a>
            </div>
        </c:when>
        <c:otherwise>
                <form:form method="POST">
                     <input type="search" class = "t" id="search" style = "float:top" placeholder="Search..." />
                    <div class = "col">
                    <button name="full"   style = "float:top; border:none;border-radius: 10px;" type="submit">Full Search</button>
                    <button name="part" type="submit" style = "border-radius: 10px; float:bottom; border:none;">By Title</button>
                    </div>
                </form:form>
                    <script>
                        $("form#command button[name=full]").click(function(e){
                            e.preventDefault();
                            if ($("form#command input#search").val() == "") return;
                            window.location.href="/search/"+$("form#command input#search").val();
                        });
                        $("form#command button[name=part]").click(function(e){
                            e.preventDefault();
                            if ($("form#command input#search").val() == "") return;
                            window.location.href="/searchPart/"+$("form#command input#search").val();
                        });
                    </script>
            <div class  = "hell">

                <a href="/listOfAudioVideoMaterialForPatron" style = ""><i class="fa fa-file-audio-o" aria-hidden="true"></i>
                    Media</a>
                <a href="/listOfArticlesForPatron" style = ""><i class="fa fa-newspaper-o" aria-hidden="true"></i>
                    Journal Article</a>
                <a href="/listOfBooksForPatron" style = ""><i class="fa fa-book" aria-hidden="true"></i> Books</a>
            </div>
        </c:otherwise>
    </c:choose>

    <div class="dropdown3" >
        <button class="dropbtn3">
            <i class="fa fa-envelope" aria-hidden="true"></i>

        </button>
        <div class="dropdown-content3" >

            <p><a href="http://38.mchs.gov.ru/document/1396914" style = "width:100%;color:darkred">
                <i class="fa fa-fire" aria-hidden="true"></i>

                What to Do: Fire Emergency
                <i class="fa fa-exclamation" aria-hidden="true" style = "color:red;"></i>

            </a>
            <p style = "font-size:1.5vw;width:100%;color:darkred; margin-left:10%;">

                What happened with telegram?
            <i class="fa fa-telegram" aria-hidden="true"></i>


        </p>
        </div>
    </div>
    <div class="dropdown2" >
        <button class="dropbtn"><i class="fa fa-user-circle-o" aria-hidden="true"></i>

            ${pageContext.request.userPrincipal.name}
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content2">
            <a href="/ProfilePage" data-toggle="modal" data-target="#largeModal"> <i class="fa fa-address-card-o" aria-hidden="true"></i>
                Profile</a>
            <c:choose>
                <c:when test="${user.type == 'Admin'}">

                </c:when>
                <c:otherwise>
                    <a href="/mydoc">
                        <i class="fa fa-bookmark" aria-hidden="true"></i>

                        My Documents</a>
                </c:otherwise>
            </c:choose>


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

<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
<div class="modal" id="largeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="cont">
            <div class="modal2">`
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <i class="fa fa-window-close-o" aria-hidden="true" style = "font-size:45px; padding-right:4px;"></i>
                </button>

            </div>
            <p style = "margin-left:7%; font-size: 2vw;">${user.type}</p>

            <div class = "hatep">
                <p>${user.name}</p>
                <p>${user.surname}</p>
                <p>${user.address}</p>
                <p>${user.id}</p>
                <p>                            <a href="tel:${user.phone}">${user.phone}</a>
                </p>
                <p>  <a href="mailto:${user.email}">
                    ${user.email}</a> </p>
            </div>

            <div class = "button2">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <form id="logoutForm" method="POST" action="${contextPath}/logout">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button > <a href = "#" onclick="document.forms['logoutForm'].submit()"><i class="fa fa-sign-out" aria-hidden="true"></i>
                            Logout </a></button>
                    </form>


                </c:if>
                <br>
            </div>
        </div>


    </div>
</div>
</body>
</html>
