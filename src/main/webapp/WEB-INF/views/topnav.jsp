<%--
  Created by IntelliJ IDEA.
  User: Катя
  Date: 01.04.2018
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
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
            </div>
        </c:when>

        <c:when test="${user.type == 'Admin'}">
            <a href="/admin" style = ""><i class="fa fa-user-secret" aria-hidden="true"></i> ADMINKA</a>
            <a href="/logs" style = ""><i class="fa fa-user-secret" aria-hidden="true"></i> Logs</a>
        </c:when>

        <c:otherwise>
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
            <a href="/mydoc">
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

    <form>


        <input type="text" placeholder="Search the document">
        <select id="selcolor">
            <option value=""></option>
            <option value="">By Title</option>
            <option value="">By Authors</option>
            <option value="">By Title and Authors</option>
            <option value="">By Description</option>
        </select>
        <button onclick="ifelsefunction()">Apply</button>

    </form>

    <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
</div>
    <div class="modal" id="largeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="cont">
                <div class="modal2">`
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <i class="fa fa-window-close-o" aria-hidden="true" style = "font-size:45px; padding-right:4px;"></i>
                    </button>
                    <br>
                    <br>
                    <div class="row">
                        <div class="cont1">
                        <span class = "photprof">
                    <img src="${contextPath}/resources/imgNew/user2.png" height = "auto"; width = "auto";>

                    <p style = "padding-left:25%; padding-top:5%;">Deep Library ID: ${user.username}</p>
                </span>
                        </div>
                        <div class="cont2">
                            <p>${user.name}  ${user.surname}</p>
                            <a href="tel:${user.phone}">${user.phone}</a>
                            <p><a href="mailto:${user.email}">
                                ${user.email}</a></p>
                            <p>Type: ${user.type}</p>

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
    <script src="${contextPath}/resources/jsNew/jquery.js"></script>
    <script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
</div>
</body>
</html>
