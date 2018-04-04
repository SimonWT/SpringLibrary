
<%--
  Created by IntelliJ IDEA.
  Users: Igor
  Date: 04-Mar-18
  Time: 6:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>New Book | DeepLib</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


</head>


<body>
<%@ include file ="topnav.jsp" %>

<div class="container">

    <form:form method="POST" modelAttribute="bookForm" class="form-signin">

        <h2 class="form-signin-heading">Create a new Book</h2>

        <spring:bind path="title">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="title" class="form-control" placeholder="Title"
                            autofocus="true"></form:input>
                <form:errors path="title"></form:errors>
            </div>
        </spring:bind>

          <spring:bind path="authors">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="authors" class="form-control" placeholder="Author's name"
                            autofocus="true"></form:input>
                <form:errors path="authors"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="publisher">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="publisher" class="form-control" placeholder="Publisher"></form:input>
                <form:errors path="publisher"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="yearString">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="date" path="yearString" class="form-control" placeholder="Publication Date"></form:input>
                <form:errors path="yearString"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="edition">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="edition" class="form-control" placeholder="Edition"></form:input>
                <form:errors path="edition"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="price">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="price" class="form-control" placeholder="Price"></form:input>
                <form:errors path="price"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="copies">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="copies" class="form-control" placeholder="Copies"></form:input>
                <form:errors path="copies"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="bestSeller">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                is Bestseller
                <form:checkbox path="bestSeller" class="form-control" placeholder="Bestseller"/>
                <form:errors path="bestSeller"></form:errors>
            </div>
        </spring:bind>


        <button class="btn btn-block" type="submit">Submit</button>
    </form:form>

</div>

<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
<script src="${contextPath}/resources/jsNew/scripts.js"></script>
</body>
</html>
