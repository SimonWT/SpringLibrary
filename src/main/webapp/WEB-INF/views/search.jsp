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
<script language="javascript">
    function a()
    {document.getElementById('info').innerHTML = 'kod5';}
    function b()
    {document.getElementById('info').innerHTML = 'kod6';}
</script>
<input type="button" value="Hello!" name="hello" OnClick="a();">
<input type="button" value="Hello!" name="hello" OnClick="b();">
<div id="info"></div>


</body>
</html>
