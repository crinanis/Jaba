<%--
  Created by IntelliJ IDEA.
  User: ksu"jdbc:mysql://localhost:3306/lab9?serverTimezone=Europe/Moscow&useSSL=false", "root", "Ksusha20031007"
  Date: 27.05.2022
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sql</title>
</head>
<body>
 <sql:setDataSource var="users" driver="com.mysql.cj.jdbc.Driver"
 url="jdbc:mysql://localhost:3306/lab9?serverTimezone=Europe/Moscow&useSSL=false"
                    user="root" password="Ksusha20031007"/>
 <sql:query dataSource="${users}" var="withName" >
     SELECT * FROM users where username = ?
     <sql:param value="admin" />
 </sql:query>
<sql:query dataSource="${users}" var="allUsers">
 SELECT * FROM users
 </sql:query>
 <table border = "1" width = "100%">
     <tr>
         <th>Name</th>
         <th>Password</th>
         <th>Role</th>
     </tr>

     <c:forEach var = "row" items = "${allUsers.rows}">
         <tr>
             <td> <c:out value = "${row.username}"/></td>
             <td> <c:out value = "${row.password}"/></td>
             <td> <c:out value = "${row.role}"/></td>
         </tr>
     </c:forEach>
 </table>
 <table border = "1" width = "100%">
     <tr>
         <th>Name</th>
         <th>Password</th>
         <th>Role</th>
     </tr>

     <c:forEach var = "row" items = "${withName.rows}">
         <tr>
             <td> <c:out value = "${row.username}"/></td>
             <td> <c:out value = "${row.password}"/></td>
             <td> <c:out value = "${row.role}"/></td>
         </tr>
     </c:forEach>
 </table>
</body>
</html>
