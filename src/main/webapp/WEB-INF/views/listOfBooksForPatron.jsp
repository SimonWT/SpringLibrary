<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="org.springframework.jdbc.datasource.DriverManagerDataSource" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Books | DeepLib</title>
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/bootstrap.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/font-awesome.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/welcomeform.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssNew/listbook.css">

</head>
<body>
<%@ include file ="topnav.jsp" %>

<form method="POST">
    <br>
    <br>
    <div class = "row">
        <div class = "one" style = "float:left; margin-left:2%;">

    </div>

    <c:forEach items="${bookList}" var="book">

    <button style = "background: #f44444; border:1px; height: 90px; text-align: center; width:50%;
    margin-left:calc(50%- 200px); color: #ddd8c4; font-size:13px;"
            type="button" data-toggle="modal"
            data-target="#my${book.id}">${book.title}</button>
        <br><br>

        <div id="my${book.id}" class="modal fade"  >
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

                                <p>Title: ${book.title}</p>
                                <p>Edition: ${book.edition} </p>
                                <p>Authors: ${book.authors}</p>
                                <p>Publisher: ${book.publisher} </p>
                                <p>Publish Year: ${book.year} </p>
                            </div>
                        </div>
                        <br>
                        <br>
                        <br>
                        <div class = "row">

                            <c:if test="${book.status==0}" >
                            <div style = "float:left; margin-left:4%;">
                                <button>
                                    Return back </button>
                            </div>
                            <div style = "float:left; margin-left:4%">
                                <button>
                                    Renew  </button>
                            </div>
                            </c:if>

                            <c:if test="${book.status==2}" >
                            <div style = "float:right; margin-right:4%">
                                <button >
                                    Queue  </button>
                            </div>
                            </c:if>

                            <c:if test="${book.status==3}" >
                            <div style = "float:right; margin-right:4%">
                                <button>
                                    Book  </button>
                            </div>
                            </c:if>
                        </div>

                    </div>
                </div>
            </div>
        </div>

    </c:forEach>

    <%--// <div class = "two" style = "float:left; margin-left:0;">--%>
    <%--//         <% try--%>
    <%--//             {--%>
    <%--//                 DriverManagerDataSource dataSource = new DriverManagerDataSource();--%>
    <%--//                 dataSource.setDriverClassName("com.mysql.jdbc.Driver");--%>
    <%--//                 dataSource.setUrl("jdbc:mysql://eu-cdbr-west-02.cleardb.net:3306/heroku_f76d6fb9e659782");--%>
    <%--//                 dataSource.setUsername("baff532465d8d9");--%>
    <%--//                 dataSource.setPassword("ffa9cd9f");--%>
    <%--//                 String query="SELECT title FROM books";--%>
    <%--//                 Connection conn=DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());--%>
    <%--//                 Statement stmt=conn.createStatement();--%>
    <%--//                 ResultSet rs=stmt.executeQuery(query);--%>
    <%--//                 String rs2;--%>
    <%--//                 while(rs.next())--%>
    <%--//                 {   if (rs.getRow()%5 == 2) {--%>
    <%--//                     rs2 = rs.getString("title"); %>--%>
    <%--//--%>
    <%--//--%>
    <%--//         <button class="btn btn-info btn-lg"  style = "background: #f44336; border:1px; height: 100px; text-align: center; width:200px; margin-left:5px; left:0; color: #ddd8c4; font-size:13px;" type="button" data-toggle="modal" data-target="#myModal"><%=rs2%></button>--%>
    <%--//         <br>--%>
    <%--//         <br>--%>
    <%--//         <br>--%>
    <%--//--%>
    <%--//         <%--%>
    <%--//                     }--%>
    <%--//                 }--%>
    <%--//--%>
    <%--//                 rs.close();--%>
    <%--//                 stmt.close();--%>
    <%--//                 conn.close();--%>
    <%--//             }--%>
    <%--//             catch(Exception e) {--%>
    <%--//                 e.printStackTrace();--%>
    <%--//                 System.out.println("<h1> error: "+ e.getMessage()+"</h1>");--%>
    <%--//             }--%>
    <%--//         %>--%>
    <%--//--%>
    <%--//     </div>--%>
    <%--//--%>
    <%--// <div class = "three" style = "float:left;">--%>
    <%--//     <%--%>
    <%--//         try--%>
    <%--//         {--%>
    <%--//             DriverManagerDataSource dataSource = new DriverManagerDataSource();--%>
    <%--//             dataSource.setDriverClassName("com.mysql.jdbc.Driver");--%>
    <%--//             dataSource.setUrl("jdbc:mysql://eu-cdbr-west-02.cleardb.net:3306/heroku_f76d6fb9e659782");--%>
    <%--//             dataSource.setUsername("baff532465d8d9");--%>
    <%--//             dataSource.setPassword("ffa9cd9f");--%>
    <%--//             String query="SELECT title FROM books";--%>
    <%--//             Connection conn=DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());--%>
    <%--//             Statement stmt=conn.createStatement();--%>
    <%--//             ResultSet rs=stmt.executeQuery(query);--%>
    <%--//             String rs2;--%>
    <%--//             while(rs.next())--%>
    <%--//             {   if (rs.getRow()%5 == 3) {--%>
    <%--//                 rs2 = rs.getString("title");--%>
    <%--//     %>--%>
    <%--//     <button class="btn btn-info btn-lg"  style = "background: #f44336; border:1px; height: 100px; text-align: center; width:200px; margin-left:5px; left:0; color: #ddd8c4; font-size:13px;" type="button" data-toggle="modal" data-target="#myModal"><%=rs2%></button>--%>
    <%--//     <br>--%>
    <%--//     <br>--%>
    <%--//     <br>--%>
    <%--//     <%--%>
    <%--//                 }--%>
    <%--//             }--%>
    <%--//--%>
    <%--//             rs.close();--%>
    <%--//             stmt.close();--%>
    <%--//             conn.close();--%>
    <%--//         }--%>
    <%--//         catch(Exception e) {--%>
    <%--//             e.printStackTrace();--%>
    <%--//             System.out.println("<h1> error: "+ e.getMessage()+"</h1>");--%>
    <%--//         }--%>
    <%--//     %>--%>
    <%--// </div>--%>
    <%--//--%>
    <%--//--%>
    <%--// <div class = "four" style = "float:left;">--%>
    <%--//     <%--%>
    <%--//         try--%>
    <%--//         {--%>
    <%--//             DriverManagerDataSource dataSource = new DriverManagerDataSource();--%>
    <%--//             dataSource.setDriverClassName("com.mysql.jdbc.Driver");--%>
    <%--//             dataSource.setUrl("jdbc:mysql://eu-cdbr-west-02.cleardb.net:3306/heroku_f76d6fb9e659782");--%>
    <%--//             dataSource.setUsername("baff532465d8d9");--%>
    <%--//             dataSource.setPassword("ffa9cd9f");--%>
    <%--//             String query="SELECT title FROM books";--%>
    <%--//             Connection conn=DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());--%>
    <%--//             Statement stmt=conn.createStatement();--%>
    <%--//             ResultSet rs=stmt.executeQuery(query);--%>
    <%--//             String rs2;--%>
    <%--//             while(rs.next())--%>
    <%--//             {   if (rs.getRow()%5 == 4) {--%>
    <%--//                 rs2 = rs.getString("title");--%>
    <%--//     %>--%>
    <%--&lt;%&ndash;//     <button class="btn btn-info btn-lg"  style = "background: #f44336; border:1px; height: 100px; text-align: center; width:200px; margin-left:5px; left:0; color: #ddd8c4; font-size:13px;" type="button" data-toggle="modal" data-target="#myModal"><%=rs2%></button>&ndash;%&gt;--%>
    <%--&lt;%&ndash;//         <br>&ndash;%&gt;--%>
    <%--&lt;%&ndash;//     <br>&ndash;%&gt;--%>
    <%--&lt;%&ndash;//     <br>&ndash;%&gt;--%>
    <%--//     <%--%>
    <%--//                 }--%>
    <%--//             }--%>
    <%--//--%>
    <%--//             rs.close();--%>
    <%--//             stmt.close();--%>
    <%--//             conn.close();--%>
    <%--//         }--%>
    <%--//         catch(Exception e) {--%>
    <%--//             e.printStackTrace();--%>
    <%--//             System.out.println("<h1> error: "+ e.getMessage()+"</h1>");--%>
    <%--//         }--%>
    <%--//     %>--%>
    <%--&lt;%&ndash;// </div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;//     <div class = "five" style = "float:left;">&ndash;%&gt;--%>
    <%--&lt;%&ndash;//         &lt;%&ndash;%>--%>
    <%--//             try--%>
    <%--//             {--%>
    <%--//                 DriverManagerDataSource dataSource = new DriverManagerDataSource();--%>
    <%--//                 dataSource.setDriverClassName("com.mysql.jdbc.Driver");--%>
    <%--//                 dataSource.setUrl("jdbc:mysql://eu-cdbr-west-02.cleardb.net:3306/heroku_f76d6fb9e659782");--%>
    <%--//                 dataSource.setUsername("baff532465d8d9");--%>
    <%--//                 dataSource.setPassword("ffa9cd9f");--%>
    <%--//                 String query="SELECT title FROM books";--%>
    <%--//                 Connection conn=DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());--%>
    <%--//                 Statement stmt=conn.createStatement();--%>
    <%--//                 ResultSet rs=stmt.executeQuery(query);--%>
    <%--//                 String rs2;--%>
    <%--//                 while(rs.next())--%>
    <%--//                 {   if (rs.getRow()%5 == 0) {--%>
    <%--//                     rs2 = rs.getString("title");--%>
    <%--//         %>--%>
    <%--//         <button class="btn btn-info btn-lg"  style = "background: #f44336; border:1px; height: 100px; text-align: center; width:200px; margin-left:5px; left:0; color: #ddd8c4; font-size:13px;" type="button" data-toggle="modal" data-target="#myModal"><%=rs2%></button>--%>
    <%--//         <br>--%>
    <%--//         <br>--%>
    <%--//         <br>--%>
    <%--//         <%--%>
    <%--//                     }--%>
    <%--//                 }--%>
    <%--//--%>
    <%--//                 rs.close();--%>
    <%--//                 stmt.close();--%>
    <%--//                 conn.close();--%>
    <%--//             }--%>
    <%--//             catch(Exception e) {--%>
    <%--//                 e.printStackTrace();--%>
    <%--//                 System.out.println("<h1> error: "+ e.getMessage()+"</h1>");--%>
    <%--//             }--%>
    <%--//         %>--%>
    <%--//     </div>--%>
    <%--// </div>--%>
</form>



<%--<div id="myModal" class="modal fade"  >--%>
    <%--<div class="modal-dialog" style = "margin-left:calc(50%- 8px); width: 470px;">--%>
        <%--<div class="modal-content" >--%>
            <%--<div class="modal-body" style = "height:410px; background:#9d9d9d">--%>
                 <%--<div class = "row" >--%>
                <%--<button class="close" type="button" data-dismiss="modal"><i class="fa fa-window-close-o" aria-hidden="true" style = "font-size:45px; padding-right:4px;"></i></button>--%>
                <%--<br>--%>
                <%--<br>--%>
                <%--<br>--%>

                <%--<div style = "float:left; margin-left:4px;">  <img src = "${contextPath}/resources/imgNew/images.png" style = "width:160px; height:200px;"></div>--%>
                <%--<div style = "float:right; margin-right:30%;">--%>

                <%--<p>Title: </p>--%>
                <%--<p>Edition: издание </p>--%>
                <%--<p>Authors: авторы</p>--%>
                <%--<p>Publisher: </p>--%>
                <%--<p>Publish Year: </p>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--<br>--%>
                <%--<br>--%>
                <%--<br>--%>
                <%--<div class = "row">--%>
                    <%--<div style = "float:left; margin-left:4%;">--%>
                        <%--<button>--%>
                            <%--Return back </button>--%>
                    <%--</div>--%>
                    <%--<div style = "float:left; margin-left:4%">--%>
                        <%--<button>--%>
                            <%--Renew  </button>--%>
                    <%--</div>--%>
                    <%--<div style = "float:right; margin-right:4%">--%>
                         <%--<button >--%>
                                   <%--Queue  </button>--%>
                    <%--</div>--%>
                    <%--<div style = "float:right; margin-right:4%">--%>
                        <%--<button>--%>
                            <%--Book  </button>--%>
                    <%--</div>--%>
                <%--</div>--%>

            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<script src="${contextPath}/resources/jsNew/jquery.js"></script>
<script src="${contextPath}/resources/jsNew/bootstrap.js"></script>
</body>
</html>
