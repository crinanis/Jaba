<%--
  Created by IntelliJ IDEA.
  User: ksu
  Date: 30.05.2022
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Основная страница</title>
</head>
<body>
<div class="container">
    <div1>
        <jsp:include page="header.jsp"/>
        <c:catch var="Exception">
            <c:set var="currentUser" value="${user}" scope="page"/>
            <c:if test="${not empty currentUser and currentUser eq 'user'}">
                you are user
            </c:if>
        </c:catch>
        <br/>
    </div1>
</div>
<form>
    <a href="register.jsp">Регистрация</a>
    <a href="welcome.jsp">Авторизация</a>
</form>
<center>
    <div1 >
        <h3 style="color: red">${error}</h3>
        <table border="2" cellpadding="4">
            <tr>
                <th> Название семьи </th>
                <th> Численость в мире </th>
            </tr>
            <c:forEach var="nation" items="${nations}">
                <tr>
                    <td>${nation.getName()}</td>
                    <td>${nation.getNumber()}</td>
                </tr>
            </c:forEach>
            <br>
        </table>
    </div1>
    <fieldset>
        <legend>add</legend>
        <form action="${pageContext.request.contextPath}/controller?command=addNation" method="post"   >
            <h3>Название народа:</h3>
            <input type="text" name="name"/>
            <h3>Численность:</h3>
            <input type="text" name="country"/>
            <br/><br/>
            <input type="submit" value="Добавить" ><br/>
        </form>
    </fieldset>
    <fieldset>
        <legend>delete</legend>
        <form action="${pageContext.request.contextPath}/controller?command=delNation" method="post" >
            <h3>Удалить по названию:</h3>
            <input type="text" name="namedelet"/>
            <input type="submit" value="Удалить" ><br/>
        </form>
    </fieldset>

    <fieldset>
        <legend>update</legend>
        <form action="${pageContext.request.contextPath}/controller?command=updNation" method="POST">
            <h3>Название народа:</h3>
            <input name="name" type="text"/> <br/>
            <h3>Измените его численность:</h3>
            <input name="number" type="text" />
            <br/><br/>
            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</center>
<jsp:include page="footer.jsp" />
</body>
</html>