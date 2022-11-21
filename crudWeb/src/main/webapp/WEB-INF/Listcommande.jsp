<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>commande</title>
</head>
<body>
    <center>
        <h1>Liste de commandes</h1>
        <h2>
            <a href="/new">Ajouter</a> &nbsp;&nbsp;&nbsp;
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List de commandes</h2></caption>
            <tr>
                <th>date_cmd</th>
                <th>client</th>
                <th>produit</th>
                <th>qte_cmd</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="commande" items="${listClient}">
                <tr>
                    <td><c:out value="${commande.date_cmd}" /></td>
                    <td><c:out value="${commande.client}" /></td>
                    <td><c:out value="${commande.produit}" /></td>
                    <td><c:out value="${commande.qte_cmd}" /></td>
               <td>
                        <a href="/edit?id=<c:out value='${commande.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${commande.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>