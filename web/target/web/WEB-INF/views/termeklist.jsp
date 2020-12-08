<%--
  Created by IntelliJ IDEA.
  User: apalo
  Date: 2020. 12. 08.
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Raktáron lévő termékek</title>
</head>
<body>
<c:if test="${!empty termekek}">
    <table frame="border" rules="all">
        <tr>
            <th>ID</th>
            <th>Megnevezés</th>
            <th>Ár</th>
            <th>Gyártási nap</th>
            <th>Kategória</th>
        </tr>
<c:forEach items="${termekek}" var="termek">
    <tr>
        <th><a href="${pageContext.servletContext.contextPath}/termek/${termek.id}">${termek.id}</a></th>
        <th>${termek.nev}</th>
        <th>${termek.ar}</th>
        <th>${termek.gyartasinap}</th>
        <th>${termek.kategoria}</th>
    </tr>
</c:forEach>
    </table>
</c:if>

<c:if test="${empty termekek}">
<c:out value="Nincs egy termék sem :("/>
</c:if>

<form action="${pageContext.servletContext.contextPath}/addTermek">
    <input type="submit" value="Termék hozzáadása">
</form>
</body>
</html>
