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

    <title>Articles | DeepLib</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file ="topnav.jsp" %>

<form method="POST">
    <br>
    <br>
    <div class = "row">
        <div class = "one" style = "float:left; margin-left:2%;">

        </div>

        <c:forEach items="${articleList}" var = "article">

        <button style = "background: #2e6da4; margin-left:2%;border:1px; height: 30%; text-align: center; width:20%;
    color: #ddd8c4; font-size:13px;"
                type="button" data-toggle="modal"
                data-target="#my${article.id}">${article.title}</button>
        <br><br>

        <div id="my${article.id}" class="modal fade"  >
            <div class="modal-dialog" style = "margin-left:calc(50%- 8px); width: 470px;">
                <div class="modal-content" >
                    <div class="modal-body" style = "height:410px; background:#9d9d9d">
                        <div class = "row" >
                            <button class="close" type="button" data-dismiss="modal"><i class="fa fa-window-close-o" aria-hidden="true" style = "font-size:45px; padding-right:4px;"></i></button>
                            <br>
                            <br>
                            <br>

                            <div style = "float:left; margin-left:4px;">  <img src = "${contextPath}/resources/imgNew/images.png" style = "width:160px; height:200px;"></div>
                            <div style = "float:right; margin-right:20%;">
                                <p>ID: ${article.id}</p>
                                <p>Title: ${article.title}</p>
                                <p>Authors: ${article.authors}</p>
                                <p>Journal: ${article.journal}</p>
                                <p>Editors: ${article.editors}</p>
                                <p>Date: ${article.dateString}</p>
                                <p>Price: ${article.price}</p>
                                <p>Copies: ${article.copies}</p>
                            </div>
                        </div>
                        <br>
                        <br>
                        <br>
                        <div class = "row">

                            <c:if test="${article.status==0 || article.status ==2}">
                            <div style = "float:left; margin-left:4%;">
                                <button><a href="/return/${article.id}">
                                    Return back </a>
                                </button>

                            </div>
                            <div style = "float:left; margin-left:4%">
                                <button><a href="/renew/${article.id}">
                                    Renew </a></button>
                            </div>
                            </c:if>

                        <c:if test="${article.status==4}" >
                            <div style = "float:right; margin-right:4%">
                                <button ><a href = "/queue/${article.id}">
                                    Queue </a>  </button>
                                </form>
                            </div>
                        </c:if>

                        <c:if test="${article.status==1}" >
                            <div style = "float:right; margin-right:4%">

                                <button><a href="/booking/${article.id}"> Book  </a>
                                   </button>

                            </div>
                        </c:if>

                        <c:if test="${article.status == 3}">
                            Here list of Queue
                        </c:if>

                        </div>

                    </div>
                </div>
            </div>
        </div>

        </c:forEach>


</form>
<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
<script src="${contextPath}/resources/jsNew/scripts.js"></script>
</body>
</html>
