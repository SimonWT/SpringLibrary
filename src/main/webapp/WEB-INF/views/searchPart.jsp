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
<%@ include file ="topnav.jsp" %><script language="javascript">
    function a()
    {document.getElementById('info').innerHTML = document.getElementById('Authors').innerHTML;}
    function b()
    {document.getElementById('info').innerHTML = document.getElementById('Titles').innerHTML;}
    function c()
    {document.getElementById('info').innerHTML = document.getElementById('TitlesAndAuthors').innerHTML;}
    function d()
    {document.getElementById('info').innerHTML = document.getElementById('Description').innerHTML;}
</script>
<div style = "text-align: center;font-size:2vw; margin-top:2%; text-decoration: underline chocolate "><p>Your searching topic:  >>>>>>>>></p></div>
<div class = "search">

    <div class = "groups">
        <input type="button" value="By_Authors" name="hello" OnClick="a();">
        <input type="button" value="By_Title" name="hello" OnClick="b();">
        <input type="button" value="By_Title & By_Authors" name="hello" OnClick="c();">
        <input type="button" value="By_Description" name="hello" OnClick="d();">
    </div>

    <div id="info"></div>
</div>
<div  style = "display:none" id="Authors">
    <div class = "ftable">
        <table class="table table-striped">

            <thead>
            <tr class="tr tr-success">
                <td>Title</td>
                <td>Authors</td>
                <td>Price</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${documentsPartialAuthor}" var="document">
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
<div  style = "display:none" id="Titles">
    <div class = "ftable">
        <table class="table table-striped">

            <thead>
            <tr class="tr tr-success">
                <td>Title</td>
                <td>Authors</td>
                <td>Price</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${documentsPartialTitle}" var="document">
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
<div  style = "display:none" id="TitlesAndAuthors">
    <div class = "ftable">
        <table class="table table-striped">

            <thead>
            <tr class="tr tr-success">
                <td>Title</td>
                <td>Authors</td>
                <td>Price</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${documentsPartialTitleAndAuthor}" var="document">
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


</body>
</html>
