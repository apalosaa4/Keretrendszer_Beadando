<%--
  Created by IntelliJ IDEA.
  User: apalo
  Date: 2020. 12. 08.
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>${termek.id}</title>
</head>
<body>

<table>
    <tr><td>ID:</td><td>${termek.id}</td></tr>
    <tr><td>Megnevezés:</td><td>${termek.nev}</td></tr>
    <tr><td>Ár:</td><td>${termek.ar}</td></tr>
    <tr><td>Gyártási nap:</td><td>${termek.gyartasinap}</td></tr>
    <tr><td>Kategória:</td><td>${termek.kategoria}</td></tr>
</table>
<form action="${pageContext.servletContext.contextPath}/">
    <input type="submit" value="Home">
</form>
</body>
</html>
