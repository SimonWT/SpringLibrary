<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 22.04.2018
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/search.css">

    <title>Searching page || DeepLib </title>
</head>
<body>
<%@ include file ="topnav.jsp" %>
<div class="tab">
    <button class="tablinks" onclick="openCity(event, 'London')">London</button>
    <button class="tablinks" onclick="openCity(event, 'Paris')">Paris</button>
    <button class="tablinks" onclick="openCity(event, 'Tokyo')">Tokyo</button>
</div>

    <div class = "group">
<input type="button" value="By_Authors" name="hello" OnClick="a();">
<input type="button" value="By_Title" name="hello" OnClick="b();">
<input type="button" value="By_Title & By_Authors" name="hello" OnClick="c();">
<input type="button" value="By_Description" name="hello" OnClick="d();">
    </div>
<!-- Tab content -->
<div id="Authors" class="tabcontent">
    <div class="container">
        <table class="table table-striped">

            <thead>
            <tr class="tr tr-success">
                <td>Title</td>
                <td>Authors</td>
                <td>Price</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${documentsAnswerListByTitle}" var="document">
                <tr>
                    <td>${document.title}</td>
                    <td>${document.authors}</td>
                    <td>${document.price}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div id="Title" class="tabcontent">
    <h3>By Title</h3>
    <p>s pisok2</p>
</div>

<div id="Desk" class="tabcontent">
    <h3>By Description</h3>
    <p>spisok 3</p>
</div>

</body>
</html>
