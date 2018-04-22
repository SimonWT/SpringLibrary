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
    <title>Searching page || DeepLib </title>
</head>
<body>
<%@ include file ="topnav.jsp" %>
<div class="tab">
    <button class="tablinks" onclick="openCity(event, 'London')">London</button>
    <button class="tablinks" onclick="openCity(event, 'Paris')">Paris</button>
    <button class="tablinks" onclick="openCity(event, 'Tokyo')">Tokyo</button>
</div>

<!-- Tab content -->
<div id="Authors" class="tabcontent">
    <h3>By Authors</h3>
    <p>spisok1</p>
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
