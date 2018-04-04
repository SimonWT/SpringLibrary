<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 04-Mar-18
  Time: 6:45 AM
  To change this template use File | Settings | File Templates.
--%>
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

    <title>New Article | DeepLib</title>

    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <link rel="stylesheet" href="${contextPath}/resources/cssNew/bootstrap.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/font-awesome.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/loginform.css">
</head>

<body>
<%@ include file ="topnav.jsp" %>


<div class="container">

    <form:form method="POST" modelAttribute="articleForm" class="form-signin">
        <h2 class="form-signin-heading">Create a new Article</h2>

        <spring:bind path="title">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="title" class="form-control" placeholder="Article's title"
                            autofocus="true"></form:input>
                <form:errors path="title"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="journal">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="journal" class="form-control" placeholder="Journal's title"
                            autofocus="true"></form:input>
                <form:errors path="journal"></form:errors>
            </div>
        </spring:bind>


        <%--<spring:bind path="date">--%>
            <%--<div class="form-group ${status.error ? 'has-error' : ''}">--%>
                <%--<form:input type="text" path="date" class="form-control" placeholder="Publication Date"></form:input>--%>
                <%--<form:errors path="date"></form:errors>--%>
            <%--</div>--%>
        <%--</spring:bind>--%>

        <spring:bind path="authors">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="authors" class="form-control" placeholder="Authors name"></form:input>
                <form:errors path="authors"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="editors">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="editors" class="form-control" placeholder="Editors name"></form:input>
                <form:errors path="editors"></form:errors>
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



        <button class="btn btn-block" type="submit">Submit</button>
    </form:form>
</div>

<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
<script src="${contextPath}/resources/jsNew/scripts.js"></script>
</body>
</html>
