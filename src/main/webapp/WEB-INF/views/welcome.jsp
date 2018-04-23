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
        #animat {
            position: relative;
            cursor: pointer;
        }
    </style>
    <script src="https://js.cx/libs/animate.js"></script>

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

        <br>
        <br>
        <div id = "animat" style = "position:fixed;">
             <textarea
             style = "background: none; border:none; border-radius:17px; font-size:2vw; display:none;  outline:none; color:darkred;"
             id="textExample" rows="4" cols="21"> Mrrrrrr, Hello in DeepLib.     It is the most credible source. I love it!
             </textarea>
            <p id = "serd" style = "color:red;"><i class="fa fa-heart" aria-hidden="true"></i>
            <i class="fa fa-heart" aria-hidden="true"></i>

                <i class="fa fa-heart" aria-hidden="true"></i></p>


            <img style = "position:fixed" id="train" src="${contextPath}/resources/imgNew/99-animals-cat-2.jpg">


        </div>

        <script>
            function animateText(textArea) {

                var text = textArea.value;
                var to = text.length,
                    from = 0;

                animate({
                    duration: 4000,
                    timing: bounce,
                    draw: function(progress) {
                        var result = (to - from) * progress + from;
                        textArea.value = text.substr(0, Math.ceil(result))
                    }
                });
            }


            function bounce(timeFraction) {
                for (var a = 0, b = 1, result; 1; a += b, b /= 2) {
                    if (timeFraction >= (7 - 4 * a) / 11) {
                        return -Math.pow((11 - 6 * a - 11 * timeFraction) / 4, 2) + Math.pow(b, 2)
                    }
                }
            }
            function demoDisplay(textArea,p) {
                textArea.style.background= "white";
                textArea.style.display = "block";
                p.style.display = "none";



            }
            animat.onclick = function fr() {
                var start = Date.now();

                var timer = setInterval(function() {
                    var timePassed = Date.now() - start;
                    animat.style.left = timePassed / 5 + 'px';

                    if (timePassed > 5500) { clearInterval(timer); demoDisplay(textExample,serd); animateText(textExample);
                    }


                }, 20);



            };
            function fr2() {
                var start = Date.now();

                var timer = setInterval(function() {
                    var timePassed = Date.now() - start;

                    animat.style.right = timePassed / 5 + 'px';

                    if (timePassed > 6200){
                        clearInterval(timer);

                    }

                }, 20);
            }
        </script>
        <h5 style = "font-size:25px;">How to use this source:</h5>
        <i class="fa fa-square" aria-hidden="true"></i> Go to Media/Journal Articles/Books and choose document, which you want.
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
        You can text to support service: <button style = "background: none"><a style = "outline:none; text-decoration:none;">i.vakhula@innopolis.ru</a></button>
        <br>
    </div>
</div>



<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
</body>
</html>