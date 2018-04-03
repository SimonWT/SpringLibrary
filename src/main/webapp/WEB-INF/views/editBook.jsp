<%--
  Created by IntelliJ IDEA.
  User: simon
  Date: 3/6/2018
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Edit a book</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <style>
      .fontfont
      {
        color: green;
      }

    </style>
</head>
<body>
<%@ include file ="topnav.jsp" %>

  <div class="container">
        <form:form method="POST" modelAttribute="bookForm" class="form-signin">
          <h2 class="form-signin-heading">Edit a book</h2>

            <spring:bind path="title">
              <div class="form-group ${status.error ? 'has-error' : ''}">
                  <form:input value="${bookForm.title}" type="text" path="title" class="form-control" placeholder="Title"
                                        ></form:input>
                  <form:errors path="title"></form:errors>
              </div>
            </spring:bind>

            <spring:bind path="authors">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input value="${bookForm.authors}" type="text" path="authors" class="form-control" placeholder="Author's name"
                                autofocus="true"></form:input>
                    <form:errors path="authors"></form:errors>
                </div>
            </spring:bind>



            <spring:bind path="yearString">
                <div class="form-group ${status.error ? 'has-error' : ''}">

                    <form:input value="${bookForm.yearString}" type="date" path="yearString" class="form-control" placeholder="Month and Year"></form:input>
                    <form:errors path="yearString"></form:errors>

                </div>
            </spring:bind>

            <spring:bind path="publisher">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input value="${bookForm.publisher}" type="text" path="publisher" class="form-control" placeholder="Publisher"></form:input>
                    <form:errors path="publisher"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="edition">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input value="${bookForm.edition}" type="text" path="edition" class="form-control" placeholder="Edition"></form:input>
                    <form:errors path="edition"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="price">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input value="${bookForm.price}" type="text" path="price" class="form-control" placeholder="Price"></form:input>
                    <form:errors path="price"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="copies">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input value="${bookForm.copies}" type="text" path="copies" class="form-control" placeholder="Copies"></form:input>
                    <form:errors path="copies"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="bestSeller">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input value="${bookForm.bestSeller}" type="text" path="bestSeller" class="form-control" placeholder="Bestseller"></form:input>
                    <form:errors path="bestSeller"></form:errors>
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
