<%--
  Created by IntelliJ IDEA.
  User: apalo
  Date: 2020. 12. 08.
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Új termék hozzáadása</title>
</head>
<body>
<form:form method="post" action="addTermek" modelAttribute="termek">
    <form:label path="nev">Megnevezés</form:label>
    <form:input path="nev"/>
    <form:label path="gyartasinap">Gyártási nap</form:label>
    <form:input type="date" path="gyartasinap"/>
    <form:label path="ar">Ár</form:label>
    <form:input path="ar"/>
    <form:label path="kategoria">Kategória</form:label>
    <form:select path="kategoria">
        <form:options items="${kategoriak}"/>
    </form:select>
    <input type="submit" value="Mentés"/>
</form:form>
</body>
</html>
