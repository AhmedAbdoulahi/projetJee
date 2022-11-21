<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">

<title>ajout&edition</title>
</head>
<body>
    <center>
        <h1>Clients</h1>
        <h2>
            <a href="/new">Ajouter</a> &nbsp;&nbsp;&nbsp;
                   
        </h2>
    </center>
    <div align="center">
        <c:if test="${client != null}">
     <form action="update" method="post">
        </c:if>
        <c:if test="${client == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${client != null}"> Ajout Client </c:if>
                    <c:if test="${client == null}">
                        New client
                    </c:if>
                </h2>
            </caption>
                <c:if test="${client != null}">
                    <input type="hidden" name="id" value="<c:out value='${client.id}' />" />
                </c:if>           
            <tr>
                <th>nom: </th>
                <td>
                    <input type="text" name="nom" size="45"
                            value="<c:out value='${client.nom}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>prenom: </th>
                <td>
                    <input type="text" name="prenom" size="45"
                            value="<c:out value='${client.prenom}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>adresse: </th>
                <td>
                    <input type="text" name="adresse" size="5"
                            value="<c:out value='${client.adresse}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Telephone: </th>
                <td>
                    <input type="text" name="tel" size="5"
                            value="<c:out value='${client.tel}' />"
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