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

                <div class = "row" style = "background: #ebccd1; width: 40%; margin-left:32%;  ">
                    <div style = "float:left; margin-top:3%; margin-left:4px;">  <img src = "${contextPath}/resources/imgNew/images.png" style = "width:100%; height:25%;"></div>
                    <br>
                    <br>

                    <div style = "float:right; margin-right:10%;">
                        <p>
                            How to forgot about girls
                            and learn masturbate
           <hr style = "height:2px;border:none;color:black; background: black;">
                    </p>
                            <br>
                            <br>
                        <p style = "color:darkred;font-size:1vw;">DO  NOT FORGET TO RETURN
                    <p style = "color:darkred;"> UNTIL 04.04.2018</p>
                        <div>Fine: </div>
                    </div>
                    <div style = "float:right;  font-size:20px;" >
                        <button style = "border: none !important; float:top; margin-top:25%;border-radius: 10px;">Return Document</button> </div>
                </div>

<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
<script src="${contextPath}/resources/jsNew/scripts.js"></script></body>
</html>