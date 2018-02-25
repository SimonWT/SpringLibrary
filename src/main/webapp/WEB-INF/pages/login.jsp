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
<html xml:lang="en" lang="en">
<head>
    <link rel="icon" href="${contextPath}/favicon.ico" type = "image/x-icon" />

    <!--<title> Authorization | InnoLibrary</title> -->

    <!-- Bootstrap -->
   <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet"/>
    <link href="${contextPath}/resources/css/style2.css" rel="stylesheet"/>

    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans:600'><style>
    body{
       background: url("${contextPath}/resources/img/14.jpg") center;

        -moz-background-size: 120%; /* Firefox 3.6+ */
        -webkit-background-size: 120%; /* Safari 3.1+ и Chrome 4.0+ */
        -o-background-size: 120%; /* Opera 9.6+ */
        background-size: 120%; /* Современные браузеры */
        position:relative;
    }
</style>

</head>
<body>
<div class = "container center-block">
    <div class = "row">
        <div class="col-md-6 col-md-offset-3">
        </div>
        <div class="col-md-6 col-md-offset-3 ">

            <div class = "well span4 offset4">
                <legend><h><label class = "text-center">DeepLib</label> </h>
                    <br>
                    <h4> the most comfortable source for student and professors </h4> </legend>

                <button class="collapsible">
                    Sign in/ Sign up
                </button>
                <div class="content">


                <div class="login-wrap">

                    <div class="login-html">

                        <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
                        <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
                        <div class="login-form">
                            <div class="sign-in-htm">
                                <div class="group">
                                    <%--@declare id="uname"--%><label for="uname"><b>Username</b></label>


                                    <input  class = "input" type="text" onfocus="this.value=''" value="Katukha" placeholder="Enter Username" name="uname" required>
                                </div>
                                <div class="group">



                                        <label for="myInput"><b>Password</b></label>
                                        <input type="password" class = "input" data-type="password" onfocus="this.value=''" value="Katushka_the_best" placeholder="Enter Password" name="psw" id ="myInput" required>
                                    <input type="checkbox" onclick="myFunction()">Show Password
                                </div>

                                <div class="group">
                                    <input type="submit" class="button" value="Sign In">
                                </div>
                                <div class="hr"></div>
                                <br>
                                <br>

                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>


                            </div>

                            <div class="sign-up-htm">
                                <div class="group">
                                    <label for="user" class="label">Username</label>
                                    <input id="user" type="text" class="input">
                                </div>
                                <div class="group">
                                    <label for="pass" class="label">Password</label>
                                    <input id="pass" type="password" class="input" data-type="password">
                                </div>
                                <div class="group">
                                    <label for="pass" class="label">Repeat Password</label>
                                    <input id="pass" type="password" class="input" data-type="password">
                                </div>
                                <div class="group">
                                    <label for="pass" class="label">Email Address</label>
                                    <input id="pass" type="text" class="input">
                                </div>
                                <div class="group">
                                    <input type="submit" class="button" value="Sign Up">
                                </div>
                                <div class="hr"></div>
                                <div class="foot-lnk">
                                    <label for="tab-1">Already Member?</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <legent class = "lovelynames"> by Gfycyd , SimonWT, jenamax, Qualwak</legent>
                </div>



</div>

            </div>
</form>
</form>
            </div>
        </div>
    </div>
</div>






<!-- <script src="https://code.jquery.com/jquery-latest.js"></script>
 <script src ="http://code.jquery.com/jquery-1.9.1.js"></script>
 <script src="b.js"></script> -->
    <script src = "${contextPath}/resources/js/jsmy.js" ></script>
<script>
    var coll = document.getElementsByClassName("collapsible");
    var i;

    for (i = 0; i < coll.length; i++) {
        coll[i].addEventListener("click", function() {
            this.classList.toggle("active");
            var content = this.nextElementSibling;
            if (content.style.display === "block") {
                content.style.display = "none";
            } else {
                content.style.display = "block";
            }
        });
    }
</script>
<script>
    function myFunction() {
        var x = document.getElementById("myInput");
        if (x.type === "password") {
            x.type = "text";
        } else {
            x.type = "password";
        }
    }
</script>

</body>
</html>