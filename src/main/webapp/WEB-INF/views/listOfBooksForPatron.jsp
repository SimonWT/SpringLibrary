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

    <title>Books | DeepLib</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" href="${contextPath}/resources/cssNew/bootstrap.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/font-awesome.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/styles.css">
</head>
<body>
<nav class="navbar navbar-static-top" style="background-color: #A52A2A;">
    <a href = "/welcome" class="navbar-brand" style="background-color: #A52A2A; " >DeepLib</a>

    <ul class="nav navbar-nav" >
        <li class="divider-vertical"></li>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/listOfAudioVideoMaterialForPatron">Audio/Video File</a></li>
                <li><a href="/listOfArticlesForPatron">Journal Articles</a></li>
                <li><a href="/listOfBooksForPatron">Books</a></li>
                <li class="dropdown" style = "padding-right: 10px;">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"
                       role="button" aria-haspopup="true"
                       aria-expanded="false">${pageContext.request.userPrincipal.name}
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li> <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <a href="/ProfilePage">Profile</a>
                        </c:if>
                        </li>

                        <li>
                            <c:if test="${pageContext.request.userPrincipal.name != null}">
                                <a href="/editUser">Edit Information</a>
                            </c:if>
                        </li>
                        <li><a href="user">My Documents</a></li>
                        <li role="separator" class="divider"></li>
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <form id="logoutForm" method="POST" action="${contextPath}/logout">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                            <li><a onclick="document.forms['logoutForm'].submit()">Logout</a></li>
                        </c:if>
                    </ul>
                </li>
            </ul>
        </div>

    </ul>
</nav>
<form method="POST">
    <table class="table table-condensed">
        <thead>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Year</th>
            <th>Edition</th>
            <th>Price</th>
            <th>Copies</th>
        </tr>
        </thead>
        <tbody>
        <%
            try
            {
                DriverManagerDataSource dataSource = new DriverManagerDataSource();
                dataSource.setDriverClassName("com.mysql.jdbc.Driver");
                dataSource.setUrl("jdbc:mysql://eu-cdbr-west-02.cleardb.net:3306/heroku_f76d6fb9e659782");
                dataSource.setUsername("baff532465d8d9");
                dataSource.setPassword("ffa9cd9f");
                String query="SELECT id, title, author, year, edition, price, copies FROM books";
                Connection conn=DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
                Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(query);
                while(rs.next())
                {
        %>


        <td><%=rs.getString("title") %></td>
        <td><%=rs.getString("author") %></td>
        <td><%=rs.getString("year") %></td>
        <td><%=rs.getString("edition") %></td>
        <td><%=rs.getString("price") %></td>
        <td><%=rs.getString("copies") %></td>
        <td><a href="/bookingBook/<%=rs.getLong("id") %>">Book</a></td>

        </tbody>
        <%
            }
        %>
    </table>
    <%
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("<h1> error: "+ e.getMessage()+"</h1>");
        }
    %>
</form>


<div style = "z-index: 2;
  background: #000;
  opacity: 0.7;">
    <nav class="text-center" style="margin-top: 562px;z-index: 4;  background: linear-gradient(to right, #f9d423, #ff4e50);opacity: 0.47;">
        <div style="color: #fff; padding-top: 20px; padding-bottom: 20px;">
            <img src="${contextPath}/resources/imgNew/15.jpg"  style="height: 2rem; display: inline-block; margin-bottom: .3125rem;">
            <p>2018,"DeepLib" <br>All rights reserved.</p>
            <div id="use" class="img-rounded text-center col-sm-6 col-sm-offset-3" style="background: #999999; padding-top: .3125rem; padding-bottom: .3125rem; margin-top: .3125rem; margin-bottom: 15px; font-size: .875rem; "> by Maksimychev Evgenij, Uzbekova Ekaterina,
                Yudinskikh Yaroslav, Vakhula Igor
            </div>
        </div>
        <div style="color: #4CAF50;padding-right: 4px;">

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <a href="/admin">ADMINKA</a>
            </c:if>

        </div>
        <div class="clearfix"></div>
    </nav>
</div>


<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
<script src="${contextPath}/resources/jsNew/scripts.js"></script>
</body>
</html>
