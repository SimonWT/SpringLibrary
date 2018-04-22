<%--
  Created by IntelliJ IDEA.
  User: Катя
  Date: 04.04.2018
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Status || DeepLib</title>
</head>
<style>
    .b{
        color: #d58512;
        background:#d5d5d5;
        outline:none;
        border:none;
        border-radius:17px;
        width:40%;
        font-size:2vw;
        text-decoration: none;

    }  a:hover button{
        text-decoration: none;
        color:black;
        outline:none;
        border:none;
    }

    .ab:hover{
        color: #d58512;
        text-decoration: none;
        outline:none;

    }
    .ab{
        color: #bce8f1;
    }
</style>
<body>
<%@ include file ="topnav.jsp" %>
<br>
<br>
<div style = "margin-left:25%;width:50%;background: #84b59f; border:none; border-radius:10px; text-align: center; font-size:1vw">
    <br>
    <div style = "margin-top:5%;">
        <c:if test="${history.status==0}">
            <h1>Checking out complete </h1>
            <h2>Returning date: ${history.returnDate}</h2>

        </c:if>
        <c:if test="${history.status==1}">
            <h1>Returning complete </h1>
            <h2>Fine: ${history.penaltyDays}</h2>
        </c:if>

         <c:if test="${history.status==2}">
             <h1>Renew complete </h1>
             <h2>Returning date: ${history.returnDate}</h2>
          </c:if>

        <c:if test="${history.status==3}">
            <h1>You are in a  <a class = "ab" href = "/viewQueue/${history.docId}" style = ""> queue </a> for checking out now</h1>
            <h2>Please wait notification</h2>
        </c:if>

    </div>

    <br>
    <br>
    <a href = "/welcome"  > <button class = "b">Choose new document</button> </a>
    <a href = "/mydoc" > <button class = "b">My Documents </button> </a>
    <br>
    <br>
</div>
</body>
</html>
