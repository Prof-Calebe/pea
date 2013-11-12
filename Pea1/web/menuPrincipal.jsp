<%-- 
    Document   : menuPrincipal
    Created on : 05/11/2013, 13:00:30
    Author     : Song
--%>
<%@page import="Classes.BaseDAO" %>
<%@page import="Classes.Login" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>


<% // recebendo os paramentos enviados pelo form no metodo get
    String nome = new String(request.getParameter("user"));

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema para o plano de Ensino e Aula da FCI</title>
    </head>
    <body>
        <div align="center">
            <h1>Bem Vindo!!! <%=nome%></h1>
            <br/>
            <h1>MENU PRINCIPAL</h1>
            <input type="button" value="Visualizar Plano de Aula" />
            <br/>
            <input type="button" value="Visualizar Plano de Ensino" />
            <br/>
        </div>
    </body>
</html>
