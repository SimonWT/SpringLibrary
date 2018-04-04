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
    <title>List of users</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file ="topnav.jsp" %>

<form method="POST">
<table class="table table-condensed">
    <thead>
    <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Username</th>
        <th>Phone number</th>
        <th>Email</th>
        <th>Type</th>
        <th>View</th>
    </tr>
    </thead>
    <tbody>
    <%
        try
        {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://127.0.0.1/deep_library_3rd_delivery");
            dataSource.setUsername("root");
            dataSource.setPassword("root");
            String query="SELECT id, name, surname, username, phone, email, type FROM users";
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
        <td><%=rs.getString("type") %></td>
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
