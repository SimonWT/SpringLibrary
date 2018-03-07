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

    <title>Home page|DeepLib</title>

    <link rel="stylesheet" href="${contextPath}/resources/cssNew/bootstrap.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/font-awesome.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/styles.css">
</head>
<body>
<div class="container">

    <!--  <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
        </h2>
        <a href="/admin">ADMINKA</a>
        <a href="/user">USERKA</a>
    </c:if> -->
</div>
<div class="hero">

    <div class="hero-bg-wrapper">
        <nav class="navbar navbar-static-top" style="background-color: #A52A2A;">
            <a class="navbar-brand" style="background-color: #A52A2A; " >DeepLib</a>

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
                        <li><a href="#">Audio/Video File</a></li>
                        <li><a href="#">Journal Articles</a></li>
                        <li><a href="#">Books</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${pageContext.request.userPrincipal.name} <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">My Profile</a></li>
                                <li><a href="#">Edit Information</a></li>
                                <li><a href="#">My Documents</a></li>
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

        <div style = "z-index: 2;
  background: #000;
  opacity: 0.7;">
            <nav class="text-center" style="margin-top: 600px;z-index: 4;  background: linear-gradient(to right, #f9d423, #ff4e50);opacity: 0.47;">
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
                        <a href="/user">USERKA</a>
                    </c:if>

                </div>
                <div class="clearfix"></div>
            </nav>
        </div>
        <div class="hero-bg-gradient-mask"></div>
        <div class="hero-bg-mask"></div>
    </div>

</div>






<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
<script src="${contextPath}/resources/jsNew/scripts.js"></script>
</body>
</html>