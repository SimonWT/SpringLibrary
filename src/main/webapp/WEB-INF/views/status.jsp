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
<body>
<%@ include file ="topnav.jsp" %>
<br>
<br>
<div style = "margin-left:25%;width:50%; height:30%">
    <c:if test="${history.status==0}">
        <h1>Booking complete </h1>
        <h2>Returning date: ${history.returnDate}</h2>
    </c:if>
    <c:if test="${history.status==1}">
        <h1>Returning complete </h1>
        <h2>Fine: ${history.penaltyDays}</h2>
    </c:if>

    <c:if test="${history.status == 2}">
        <h1>Renewing complete </h1>
        <h2>Returning date: ${history.returnDate}</h2>
    </c:if>

    <c:if test="${history.status==3}">
        <h1>You are in a queue for the book now</h1>
        <h2>Please wait for a notification during 3 days</h2>
    </c:if>

    <br>
    <br>
    <br>
    <br>
    <p>ID: ${history.document.id}</p>
    <p>Order ID: ${history.id}</p>
    <p>Title: ${history.document.title}</p>
    <p>Authors: ${history.document.authors}</p>
    <p>Check out date: ${history.checkOutDate}</p>
    <p>Returned date: ${history.returnDate}</p>
    <c:if test="${history.penaltyDays > 0}">
        <p>Penalty days: ${history.penaltyDays}</p>
        <p>Fine: ${history.document.fine} </p>
    </c:if>

</div>
</body>
</html>
