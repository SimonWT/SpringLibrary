
<%--
  Created by IntelliJ IDEA.
  Users: Igor
  Date: 04-Mar-18
  Time: 6:45 AM
  To change this template use File | Settings | File Templates.
--%>
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

    <title>New Book | DeepLib</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


</head>


<body>
<nav class="navbar navbar-static-top" style="background-color: #A52A2A;">
    <a href = "/welcome" class="navbar-brand" style="background-color: #A52A2A; " >DeepLib</a>

    <ul class="nav navbar-nav" >
        <li class="divider-vertical"></li>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/listOfAudioVideoMaterialForPatron">Audio/Video File</a></li>
                <li><a href="/listOfArticlesForPatron">Journal Articles</a></li>
                <li><a href="/listOfBooksForPatron">Books</a></li>
                <li class="dropdown" style = "padding-right: 10px;">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"
                       role="button" aria-haspopup="true"
                       aria-expanded="false">${pageContext.request.userPrincipal.name}
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li> <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <a href="/ProfilePage">Profile</a>
                        </c:if>
                        </li>

                        <li>
                            <c:if test="${pageContext.request.userPrincipal.name != null}">
                                <a href="/editUser">Edit Information</a>
                            </c:if>
                        </li>
                        <li><a href="user">My Documents</a></li>
                        <li role="separator" class="divider"></li>
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <form id="logoutForm" method="POST" action="${contextPath}/logout">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                            <li><a onclick="document.forms['logoutForm'].submit()">Logout</a></li>
                        </c:if>
                    </ul>
                </li>
            </ul>
        </div>

    </ul>
</nav>
<div class="container">

    <form:form method="POST" modelAttribute="bookForm" class="form-signin">
        <h2 class="form-signin-heading">Create a new Book</h2>

        <spring:bind path="title">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="title" class="form-control" placeholder="Title"
                            autofocus="true"></form:input>
                <form:errors path="title"></form:errors>
            </div>
        </spring:bind>

          <spring:bind path="author">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="author" class="form-control" placeholder="Author's name"
                            autofocus="true"></form:input>
                <form:errors path="author"></form:errors>
            </div>
        </spring:bind>



        <spring:bind path="year">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="year" class="form-control" placeholder="Month and Year"></form:input>
                <form:errors path="year"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="edition">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="edition" class="form-control" placeholder="Edition"></form:input>
                <form:errors path="edition"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="price">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="price" class="form-control" placeholder="Price"></form:input>
                <form:errors path="price"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="copies">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="copies" class="form-control" placeholder="Copies"></form:input>
                <form:errors path="copies"></form:errors>
            </div>
        </spring:bind>


        <button class="btn btn-block" type="submit">Submit</button>
    </form:form>

</div>

<div style = "z-index: 2;
  background: #000;
  opacity: 0.7;">
    <nav class="text-center" style="margin-top: 562px;z-index: 4;  background: linear-gradient(to right, #f9d423, #ff4e50);opacity: 0.47;">
        <div style="color: #fff; padding-top: 20px; padding-bottom: 20px;">
            <img src="${contextPath}/resources/imgNew/15.jpg"  style="height: 2rem; display: inline-block; margin-bottom: .3125rem;">
            <p>2018,"DeepLib" <br>All rights reserved.</p>
            <div id="use" class="img-rounded text-center col-sm-6 col-sm-offset-3" style="background: #999999; padding-top: .3125rem; padding-bottom: .3125rem; margin-top: .3125rem; margin-bottom: 15px; font-size: .875rem; "> by Maksimychev Evgenij, Uzbekova Ekaterina,
                Yudinskikh Yaroslav, Vakhula Igor
            </div>
        </div>
        <div style="color: #4CAF50;padding-right: 4px;">

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <a href="/admin">ADMINKA</a>
            </c:if>

        </div>
        <div class="clearfix"></div>
    </nav>
</div>
<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
<script src="${contextPath}/resources/jsNew/scripts.js"></script>
</body>
</html>
