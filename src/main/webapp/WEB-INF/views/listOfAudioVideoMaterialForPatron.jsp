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
<h3><a href="/admin">Back</a></h3>
<form method="POST">
    <table class="table table-condensed">
        <thead>
        <tr>
            <th>Author</th>
            <th>Title</th>
            <th>Price</th>
            <th>Copies</th>
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
                String query="SELECT id, author, title, price, copies FROM audio_video";
                Connection conn=DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
                Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(query);
                while(rs.next())
                {
        %>


        <td><%=rs.getString("author") %></td>
        <td><%=rs.getString("title") %></td>
        <td><%=rs.getString("price") %></td>
        <td><%=rs.getString("copies") %></td>
        <td><a>Book</a></td>

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
