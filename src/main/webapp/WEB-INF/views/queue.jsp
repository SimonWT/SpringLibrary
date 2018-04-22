<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">
<head>

    <title>Queue || DeepLib</title>

    <style>
        .ftable{
            width:60%;
            margin-left:20%;
            margin-top:2%;
            background: #d5d5d5;
        }
        .ftable th{
            color:#337ab7;
            font-size: 1.3vw;
            text-align: center;
        }
        .ftable td{
            color:#d58512;
            font-size:1.3vw;
            text-align: center;
        }
        .ftable a{
            color:#d58512;
        }
        .ftable a:hover{
            outline:none;
            text-decoration: none;
            color:black;
        }
    </style>
</head>
<body>
<%@ include file ="topnav.jsp" %>
<br>
<div style = "font-size:20px; text-align:center">You are on the 2nd place now</div>

<div class = "ftable">


<table class="table table-condensed">
    <thead>
    <tr>
        <th>Number</th>
        <th>Name Surname </th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>

    <!--<c:forEach items="${audioVideoList}" var="av"> -->
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>


        </tr>
    <!--</c:forEach> -->

    </tbody>
</table>
</div>
</body>
</html>
