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
            background:#d4d4d4;
            color: #d58512;
            width:65%;
            margin-left:17.5%;
            font-size:1.3vw;
            margin-top:3%;
            margin-bottom:10%;
        }
        .vn{
            width:95%;
            border:none;
            border-radius: 10px;
            text-align:center;
            margin-top:2%;
            margin-left: 2.5%;

        }
        p{
            text-align: center;
            font-size:2vw;
        }
    </style>
</head>
<body>
<%@ include file ="topnav.jsp" %>

<div class = "block">
    <p>History of Library</p>
    <c:forEach items="${logs}" var="log">

    <div class = "vn">
        <i class="fa fa-hand-o-right" aria-hidden="true"></i>
            ${log}
    </div>

    </c:forEach>
</div>
</body>
</html>
