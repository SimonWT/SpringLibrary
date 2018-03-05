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
    <title>List of books</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
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
                dataSource.setUrl("jdbc:mysql://localhost:3306/spring_library_app");
                dataSource.setUsername("root");
                dataSource.setPassword("root");
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
        <td><a href="/editBook/{<%=rs.getString("title")%>}">Modify</a><a href="/deleteBook/<%=rs.getLong("id")%>">Delete</a></td>


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
