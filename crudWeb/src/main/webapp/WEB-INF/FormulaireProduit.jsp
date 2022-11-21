<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produit</title>
</head>
<body>
    <center>
        <h1>Produit</h1>
        <h2>
            <a href="/new">Ajouter</a> &nbsp;&nbsp;&nbsp;
                   
        </h2>
    </center>
    <div align="center">
        <c:if test="${produit != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${produit == null}">
      <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${produit != null}">
                        Ajout produit
                    </c:if>
                    <c:if test="${produit == null}">
                        New produit
                    </c:if>
                </h2>
            </caption>
                <c:if test="${produit != null}">
                    <input type="hidden" name="id" value="<c:out value='${produit.id}' />" />
                </c:if>           
            <tr>
                <th>libelle: </th>
                <td>
                    <input type="text" name="libelle" size="45"
                            value="<c:out value='${produit.libelle}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>prix: </th>
                <td>
                    <input type="text" name="prix" size="45"
                            value="<c:out value='${produit.prix}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>qte_stock: </th>
                <td>
                    <input type="text" name="produit" size="5"
                            value="<c:out value='${produit.qte_stock}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>