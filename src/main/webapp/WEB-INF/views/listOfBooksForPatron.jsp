<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="org.springframework.jdbc.datasource.DriverManagerDataSource" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
    <csrf disabled="true" />
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Books | DeepLib</title>
    <style>
        .popup {
            position: relative;
            display: inline-block;
            cursor: pointer;
        }

        /* The actual popup (appears on top) */
        .popup .popuptext {
            visibility: hidden;
            width: 160px;
            background-color: #555;
            color: #fff;
            text-align: center;
            border-radius: 6px;
            padding: 8px 0;
            position: absolute;
            z-index: 1;
            bottom: 125%;
            left: 50%;
            margin-left: -80px;
        }

        /* Popup arrow */
        .popup .popuptext::after {
            content: "";
            position: absolute;
            top: 100%;
            left: 50%;
            margin-left: -5px;
            border-width: 5px;
            border-style: solid;
            border-color: #555 transparent transparent transparent;
        }

        /* Toggle this class when clicking on the popup container (hide and show the popup) */
        .popup .show {
            visibility: visible;
            -webkit-animation: fadeIn 1s;
            animation: fadeIn 1s
        }

        /* Add animation (fade in the popup) */
        @-webkit-keyframes fadeIn {
            from {opacity: 0;}
            to {opacity: 1;}
        }

        @keyframes fadeIn {
            from {opacity: 0;}
            to {opacity:1 ;}
        }
    </style>
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/bootstrap.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/font-awesome.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/welcomeform.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/listbook.css">



</head>
<body>
<%@ include file ="topnav.jsp" %>

<form method="GET">
    <br>
    <br>
    <div class = "row">
        <div class = "one" style = "float:left; margin-left:2%;">

    </div>

    <c:forEach items="${bookList}" var="book">

    <button style = "background: #f44444; border:1px; height: 90px; text-align: center; width:50%;
    margin-left:calc(50%- 200px); color: #ddd8c4; font-size:13px;"
            type="button" data-toggle="modal"
            data-target="#my${book.id}">${book.title}</button>
        <br><br>

        <div id="my${book.id}" class="modal fade"  >
            <div class="modal-dialog" style = "margin-left:calc(50%- 8px); width: 470px;">
                <div class="modal-content" >
                    <div class="modal-body" style = "height:320px; background:#9d9d9d">
                        <div class = "row" >
                            <button class="close" type="button" data-dismiss="modal"><i class="fa fa-window-close-o" aria-hidden="true" style = "font-size:45px; padding-right:4px;"></i></button>
                            <br>


                            <div style = "float:left; margin-left:4px;">  <img src = "${contextPath}/resources/imgNew/images.png" style = "width:200px; height:260px;"></div>
                            <br>
                            <div style = "float:right; margin-right:20%;">
                                <p>ID: ${book.id}</p>
                                <p>Title: ${book.title}</p>
                                <p>Edition: ${book.edition} </p>
                                <p>Authors: ${book.authors}</p>
                                <p>Publisher: ${book.publisher} </p>
                                <p>Publish Year: ${book.yearString} </p>
                            </div>
                        </div>
                        <div class = "row">

                            <c:if test="${book.status==0}" >
                            <div style = "float:left; margin-left:4%;">
                                <a href="/return/${book.id}"><button>
                                    Return back




                                </button></a>
                            </div>
                            <div style = "float:left; margin-left:4%">
                                <button type="button" data-toggle="modalren" data-target="renew">
                                    Renew  </button>
                            </div>
                            </c:if>

                            <c:if test="${book.status==2}">
                            <div style = "float:right; margin-right:4%">
                                <button> Queue  </button>
                            </div>

                            </c:if>

                            <c:if test="${book.status==3}" >

                            <div style = "float:right; margin-right:10%">
                                <div class="popup" href = "/booking/${book.id}" onclick="myFunction()">Book
                                <span class="popuptext" id="myPopup">Check out successful!</span>
                            </div>
                                <script>
                                    function myFunction() {
                                        var popup = document.getElementById("myPopup");
                                        popup.classList.toggle("show");
                                    }
                                </script>
                            </div>

                            </c:if>

                        </div>

                    </div>
                </div>
            </div>
        </div>

    </c:forEach>

</form>

<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
</body>
</html>
