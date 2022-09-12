<%--
  Created by IntelliJ IDEA.
  User: ksu
  Date: 27.05.2022
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
    <jsp:directive.page contentType="text/html; charset=UTF-8"/>
    <html>
    <head>
        <title>XML</title>
    </head>
    <body>
    <x:parse var="doc">
        <c:import url="forxml.xml" />
    </x:parse>
    <br/>
Hmmm...
    <x:set var="helpme" select="$doc/books/book[1]/name"/>
    <x:out select="$helpme/."/>
    <br/>
    <c:catch var="exception">
        <table>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
            </tr>
            <x:forEach select="$doc/books/book" var="item" >
                <tr>
                    <td><x:out select="$item/name"/></td>
                    <td><x:out select="$item/author"/></td>
                    <td><x:out select="$item/price"/></td>
                </tr>
            </x:forEach>
        </table>
    </c:catch>
    <c:if test="${exception != null}">
        <p>Exception : ${exception} <br/>
            Message : ${exception.message}</p>
    </c:if>
    </body>
    </html>
</root>
