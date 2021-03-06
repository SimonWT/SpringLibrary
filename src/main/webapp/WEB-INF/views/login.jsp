<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 02-Mar-18
  Time: 12:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<head>
    <meta charset="utf-8">

    <title>Login Form | DeepLib</title>
    <link href="${contextPath}/resources/cssNew/bootstrap.css" rel="stylesheet">
    <link href="${contextPath}/resources/cssNew/font-awesome.css" rel="stylesheet">
    <link href="${contextPath}/resources/cssNew/loginform.css" rel="stylesheet">

</head>
<body>
<div class="hero">
    <div class="hero-content col-md-9">
        <div class="hero-bg-wrapper">
            <div class="hero-bg-mask"></div>
            <div class="hero-bg-gradient-mask"></div>
        </div>
        <div class="hero-caption">
            <h1 class="hero-caption-title">Welcome to DeepLib</h1>
            <p class="hero-caption-text">DeepLib is the most comfortable source for students and professors</p>
        </div>
    </div>
    <div class="hero-login col-md-3">
        <div class="hero-login-tabs">
            <ul class="nav nav-tabs nav-justified" role="tablist">
                <li role="presentation" class="active">
                    <a href="#loginTab" aria-controls="loginTab" role="tab" data-toggle="tab">Sign in</a>
                </li>
                <li role="presentation">
                    <a href="#registerTab" aria-controls="registerTab" role="tab" data-toggle="tab">Sign up</a>
                </li>
            </ul>
            <!-- /Tab navigation -->

            <!-- Tab content -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="loginTab">
                    <form method="POST" action="${contextPath}/login">
                        <span>${error}</span>

                        <div class="form-group ${error != null ? 'has-error' : ''}">
                            <label for="loginInputEmail">Email address/Login</label>
                            <i class="fa fa-at"></i>
                            <input name="username" class = "form-control" type="text"  id="loginInputEmail"  required>
                        </div>
                        <div class="form-group ${error != null ? 'has-error' : ''}">
                            <label for="loginInputPwd">Password</label>
                            <i class="fa fa-lock"></i>
                            <input name="password" type="password" class = "form-control" data-type="password"  id ="loginInputPwd" required>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </div>


                        <button type="submit" class="btn btn-block btn-default hero-btn">Sign in</button>

                    </form>
                </div>
                <div role="tabpanel" class="tab-pane" id="registerTab">
                    <form>
                        <div class="form-group">
                            <label for="registerInputEmail">Email address</label>
                            <i class="fa fa-at"></i>
                            <input type="text" class="form-control" id="registerInputEmail">
                        </div>
                        <div class="form-group">
                            <label for="registerInputPwd">Password</label>
                            <i class="fa fa-lock"></i>
                            <input type="password" class="form-control" id="registerInputPwd">
                        </div>
                        <div class="form-group">
                            <label for="registerInputPwdConfirm">Confirm Password</label>
                            <i class="fa fa-lock"></i>
                            <input type="password" class="form-control" id="registerInputPwdConfirm">
                        </div>
                        <script type="text/javascript">
                            function show(state){

                                document.getElementById('window').style.display = state;
                                document.getElementById('wrap').style.display = state;
                            }

                        </script>
                        <div onclick="show('none')" id="wrap"></div>
                        <div id="window">
                            <img class="close" onclick="show('none')" src="http://sergey-oganesyan.ru/wp-content/uploads/2014/01/close.png">
                            <br>
                            <p>Please, ask about registration admins of this library
                                or you can write to support service <button style = "border:none; background: none;outline:none;"><a style = "text-decoration: none;">i.vakhula@innopolis.ru</a></button></p>
                        </div>
                        <button type="submit"  onclick="show('block')" class="btn btn-block btn-default hero-btn">Sign up</button>
                    </form>
                </div>
            </div>
            <!-- /Tab content -->

        </div>
        <!-- /Actions tabs -->

    </div>
</div>

<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
<script src="${contextPath}/resources/jsNew/scripts.js"></script>

</body>
</html>