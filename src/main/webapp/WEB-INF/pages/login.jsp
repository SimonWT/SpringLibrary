<%--
  Created by IntelliJ IDEA.
  User: simon
  Date: 2/12/2018
  Time: 12:24 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>Authorization | InnoLibrary</title>

    <!-- Bootstrap -->
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">


</head>
<body>



<form action="/users/check" method="POST">
    <div class = "container">
        <div class = "row">
            <div class="col-xs-6 col-md-4">
            </div>
            <div class="col-xs-6 col-md-4 ">

                <div class = "well span4 offset4">
                    <legend>Authorization</legend>

                    <form method = "post" action="/user_card.html" accept-charset="UTF-8">
                        <input type="text" name="login" class= "span4 form-control" pattern=".{1,}" required title="" placeholder = "Username">
                        <input type="password" name="password" pattern=".{3,}" required title="3 character minimum" maxlength="20"
                               class="span4 form-control" placeholder="Password">
                        <br>
                        <input type = "submit" name = "submit"
                               class = "btn btn-success btn-block" value = "Sign in">

                    </form>
                </div>
            </div>
        </div>
    </div>

    <!--<script src="https://code.jquery.com/jquery-latest.js"></script>
    <script src ="http://code.jquery.com/jquery-1.9.1.js"></script>-->
    <!--<script src="b.js"></script>-->

</form>

<img src="${contextPath}/resources/img/1.jpg" align="ce">


</body>
</html>