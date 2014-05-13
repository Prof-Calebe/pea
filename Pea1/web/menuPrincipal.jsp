<%-- 
    Document   : menuPrincipal
    Created on : 05/11/2013, 13:00:30
    Author     : Song
--%>
<%@page import="Classes.BaseDAO" %>
<%@page import="Classes.Login" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>


<%
    Integer userID = (Integer)request.getSession(true).getAttribute("sessionID");

    if (userID == null)
    {
        response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema para o plano de Ensino e Aula da FCI</title>
        <style>
            a, a:hover, a:visited {color: #000;text-decoration: none}
            .menu-button {border: 1px solid #000; padding: 5px; width: 250px; height: 35px;display: block; margin-bottom: 15px;}
        </style>
    </head>
    <body>
        <div align="right">
            <a href="index.html">
                <h3>Sair</h3>
            </a>
        </div>
        <div align="center">
            <h1>Bem Vindo ao Sistema para o Plano de Ensino e Aula da FCI</h1>
            <br/>
            <h1>MENU PRINCIPAL</h1>
            <br/>
            <br/>
            <span class="menu-button"><a href="cadastrarMateria.jsp">Cadastrar Matéria</a></span>
            <span class="menu-button"><a href="cadastrarPlanoAula.jsp">Cadastra Plano de Aula</a></span>
            <span class="menu-button"><a href="visualizarPlanoAula.jsp">Visualizar Plano de Aula</a></span>
            <span class="menu-button"><a href="visualizarPlanoEnsino.jsp">Visualizar Plano de Ensino</a></span>
            <span class="menu-button"><a href="logout.jsp">Logout</a></span>
        </div>
    </body>
</html>
