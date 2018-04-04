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

</div>
</body>
</html>
