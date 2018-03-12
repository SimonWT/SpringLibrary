<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="org.springframework.jdbc.datasource.DriverManagerDataSource" %><%--
  Created by IntelliJ IDEA.
  User: Igor
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
    <title>List of users</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
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
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Username</th>
        <th>Phone number</th>
        <th>Email</th>
        <th>View</th>
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
            String query="SELECT id, name, surname, username, phone, email FROM users";
            Connection conn=DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
    %>


        <td><%=rs.getString("name") %></td>
        <td><%=rs.getString("surname") %></td>
        <td><%=rs.getString("username") %></td>
        <td><%=rs.getString("phone") %></td>
        <td><%=rs.getString("email") %></td>
        <td><a href="/editUser/<%=rs.getLong("id")%>">Modify</a><a href="/deleteUser/<%=rs.getLong("id")%>">Delete</a></td>


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
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
