<%--
  Created by IntelliJ IDEA.
  User: simon
  Date: 3/6/2018
  Time: 8:48 PM
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

    <title>Add a new Article</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>
<%@ include file ="topnav.jsp" %>

<div class="container">

    <form:form method="POST" modelAttribute="articleForm" class="form-signin">
        <h2 class="form-signin-heading">Create a new Article</h2>

        <spring:bind path="title">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input value="${articleForm.title}" type="text" path="title" class="form-control" placeholder="Artical's title"
                            autofocus="true"></form:input>
                <form:errors path="title"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="journal">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input value="${articleForm.journal}" type="text" path="journal" class="form-control" placeholder="Journal's title"
                            autofocus="true"></form:input>
                <form:errors path="journal"></form:errors>
            </div>
        </spring:bind>



        <spring:bind path="date">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input value="${articleForm.date}" type="text" path="date" class="form-control" placeholder="Month and Year"></form:input>
                <form:errors path="date"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="authors">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input value="${articleForm.authors}" type="text" path="authors" class="form-control" placeholder="Authors name"></form:input>
                <form:errors path="authors"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="editors">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input value="${articleForm.editors}" type="text" path="editors" class="form-control" placeholder="Editor's name"></form:input>
                <form:errors path="editors"></form:errors>
            </div>
        </spring:bind>


        <spring:bind path="price">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input value="${articleForm.price}" type="text" path="price" class="form-control" placeholder="Price"></form:input>
                <form:errors path="price"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="copies">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input value="${articleForm.copies}" type="text" path="copies" class="form-control" placeholder="Copies"></form:input>
                <form:errors path="copies"></form:errors>
            </div>
        </spring:bind>


        <button class="btn btn-block" type="submit">Submit</button>
    </form:form>

</div>

<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
