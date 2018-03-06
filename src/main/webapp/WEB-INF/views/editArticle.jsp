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

<div class="container">

    <form:form method="POST" modelAttribute="articleForm" class="form-signin">
        <h2 class="form-signin-heading">Create a new Article</h2>

        <spring:bind path="journal_title">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input value="${articleForm.journal_title}" type="text" path="journal_title" class="form-control" placeholder="Journal's title"
                            autofocus="true"></form:input>
                <form:errors path="journal_title"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="article_title">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input value="${articleForm.article_title}" type="text" path="article_title" class="form-control" placeholder="Article's title"
                            autofocus="true"></form:input>
                <form:errors path="article_title"></form:errors>
            </div>
        </spring:bind>



        <spring:bind path="publication_month_year">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input value="${articleForm.publication_month_year}" type="text" path="publication_month_year" class="form-control" placeholder="Month and Year"></form:input>
                <form:errors path="publication_month_year"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="author">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input value="${articleForm.author}" type="text" path="author" class="form-control" placeholder="Author's name"></form:input>
                <form:errors path="author"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="editor">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input value="${articleForm.editor}" type="text" path="editor" class="form-control" placeholder="Editor's name"></form:input>
                <form:errors path="editor"></form:errors>
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
