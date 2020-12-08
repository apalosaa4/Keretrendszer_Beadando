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
<form:form method="post" action="addAllapot" modelAttribute="termek">
    <form:label path="nev">Megnevezés</form:label>
    <form:input path="nev"/>
    <form:label path="gyartasinap">Gyártási nap</form:label>
    <form:input path="gyartasinap"/>
    <form:label path="ar">Ár</form:label>
    <form:input path="ar"/>
</form:form>
</body>
</html>
