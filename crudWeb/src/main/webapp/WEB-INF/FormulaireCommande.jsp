<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <center>
        <h1>commande</h1>
        <h2>
            <a href="/new">Ajouter</a> &nbsp;&nbsp;&nbsp;
                   
        </h2>
    </center>
    <div align="center">
        <c:if test="${commande != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${commande == null}">
      <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${commande != null}">
                        Ajout commande
                    </c:if>
                    <c:if test="${commande == null}">
                        New commande
                    </c:if>
                </h2>
            </caption>
                <c:if test="${commande != null}">
                    <input type="hidden" name="id" value="<c:out value='${commande.id}' />" />
                </c:if>           
            <tr>
                <th>date_cmd: </th>
                <td>
                    <input type="text" name="date_cmd" size="45"
                            value="<c:out value='${commande.date_cmd}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>client: </th>
                <td>
                    <input type="text" name="client" size="45"
                            value="<c:out value='${commande.client}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>produit: </th>
                <td>
                    <input type="text" name="produit" size="5"
                            value="<c:out value='${commande.produit}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>qte_cmd: </th>
                <td>
                    <input type="text" name="qte_cmd" size="5"
                            value="<c:out value='${ commande.qte_cmd }' />"
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