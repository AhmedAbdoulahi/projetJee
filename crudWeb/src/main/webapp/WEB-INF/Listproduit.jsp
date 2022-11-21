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
        <h1>Liste de produit</h1>
        <h2>
            <a href="/new">Ajouter</a> &nbsp;&nbsp;&nbsp;
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List de produit</h2></caption>
            <tr>
                <th>ID</th>
                <th>libelle</th>
                <th>prix</th>
                <th>qte_stock</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="produit" items="${listProduit}">
                <tr>
                    <td><c:out value="${produit.id}" /></td>
                    <td><c:out value="${produit.libelle}" /></td>
                    <td><c:out value="${produit.prix}" /></td>
                    <td><c:out value="${produit.qte_stock}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${produit.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${produit.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>