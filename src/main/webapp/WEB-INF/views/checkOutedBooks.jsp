<%--
  Created by IntelliJ IDEA.
  User: simon
  Date: 3/7/2018
  Time: 6:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Books | DeepLib</title>
</head>
<body>
<h3><a href="/welcome">Back</a></h3>
<c:if test="${!empty listOfbooks}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Title</th>
            <th width="120">Author</th>
            <th width="120">Price</th>
        </tr>
        <c:forEach items="${listOfbooks}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <%--<td>${book.author}</td>--%>
                <td>${book.price}</td>
                <td><a href="#">Return</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty listOfbooks}">
    <h3> Your are free</h3>
</c:if>

</body>
</html>
