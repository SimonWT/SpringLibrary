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

    <title>Logs || DeepLib</title>
    <style>
        .block{
            background:#c4e3f3;
            color: #d58512;
            width:65%;
            margin-left:17.5%;
            font-size:2vw;
            margin-top:3%;
            margin-bottom:10%;
        }
        .vn,.vn2{
            background: #9d9d9d;
            width:45%;
            margin-bottom:4%;
            border:none;
            border-radius: 10px;
            height:100px;
            text-align:center;
            margin-top:4%;
        }
        .vn2{
            float:right;
        }
        .vn{
            float:left;
        }
        p{
        }
    </style>
</head>
<body>
<%@ include file ="topnav.jsp" %>

<div class = "block">
<br>
    <c:forEach items="${logs}" var="log">
        <c:if test = "${logs.indexOf(log) % 2 == 0}">
    <div class = "vn">
    <p>${log}</p>
    </div>
    </c:if>
        <c:if test = "${logs.indexOf(log) % 2 == 1}">
            <div class = "vn2">
                <p>${log}</p>
            </div>
        </c:if>
    </c:forEach>
</div>
</body>
</html>
