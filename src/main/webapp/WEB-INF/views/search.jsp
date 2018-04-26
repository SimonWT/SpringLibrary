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

    <title>Search page || DeepLib</title>
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/bootstrap.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/font-awesome.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/welcomeform.css">
    <link rel = "stylesheet" href = "${contextPath}/resources/cssNew/search.css">

</head>
<body>
<%@ include file ="topnav.jsp" %>
<script language="javascript">
    function a()
    {document.getElementById('info').innerHTML = document.getElementById('Authors').innerHTML;}
    function b()
    {document.getElementById('info').innerHTML = document.getElementById('Titles').innerHTML;}
    function c()
    {document.getElementById('info').innerHTML = document.getElementById('TitlesAndAuthors').innerHTML;}
    function d()
    {document.getElementById('info').innerHTML = document.getElementById('Description').innerHTML;}
</script>
<div style = "text-align: center;font-size:2vw; margin-top:2%; text-decoration: underline chocolate "><p></p></div>
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

            <c:forEach items="${documentsAnswerListByAuthor}" var="document">
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
            <c:forEach items="${documentsAnswerListByAuthorAndTitle}" var="document">
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



<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
</body>
</html>
