<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="org.springframework.jdbc.datasource.DriverManagerDataSource" %><%--
  Created by IntelliJ IDEA.
  Users: Igor
  Date: 02-Mar-18
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>

    <title>All Books | DeepLib</title>

    <link rel="stylesheet" href="${contextPath}/resources/cssNew/bootstrap.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/font-awesome.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/loginform.css"></head>
<body>
<%@ include file ="topnav.jsp" %>
<br>
<br>
<div style = "background: #8c8c8c; text-align: center;color:#ddd8c4; font-size:30px; width:60%;margin-left:21.5%;
font-style: normal">My Documents</div>
<br>
<br>

                <div class = "row" style = "background: #ebccd1; width: 50%; margin-left:35%; height:27%; ">

                    <div style = "float:left; margin-top:1.5%; margin-left:4px;">  <img src = "${contextPath}/resources/imgNew/images.png" style = "width:100%; height:90%;"></div>
                    <div style = "float:right;">
                        <div style = "height:20%;">How to forgot about girls and learn masturbate  </div>
                        <div  style = "font-size:40px; color:darkred;">DO  NOT FORGET TO RETURN UNTIL 04.04.2018</div>
                        <div>Fine: </div>
                    </div>

                    <div style = "float:right;  font-size:20px;" >
                        <button style = "border: none !important; margin-top:50%;border-radius: 10px;">Return Document</button> </div>
                </div>

<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
<script src="${contextPath}/resources/jsNew/scripts.js"></script></body>
</html>