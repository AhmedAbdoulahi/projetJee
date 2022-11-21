<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>app</title>
</head>
<body>
    <center>
        <h1>Liste de clients</h1>
        <h2>
            <a href="/new">Ajouter</a> &nbsp;&nbsp;&nbsp;
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List de clients</h2></caption>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Adresse</th>
                <th>Telephone</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="client" items="${listClient}">
                <tr>
                    <td><c:out value="${client.id}" /></td>
                    <td><c:out value="${client.nom}" /></td>
                    <td><c:out value="${client.prenom}" /></td>
                    <td><c:out value="${client.adresse}" /></td>
                    <td><c:out value="${client.telephone}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${client.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${client.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>