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
    String senha = new String(request.getParameter("senha"));

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema para o plano de Ensino e Aula da FCI</title>
    </head>
    <body>
        <h1>MENU PRINCIPAL</h1>
    </body>
</html>
