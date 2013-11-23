<%-- 
    Arquivo responsável por inserir a matéria no banco 
    
    Document   : cadastrarMateria
    Created on : 22/11/2013, 16:40:46
    Author     : thyago


--%>

<%@page import="Classes.BaseDAO" %>
<%@page import="Classes.Materia" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%

    Materia nova_materia = new Materia();
    nova_materia.setNomeMateria(request.getParameter("nomeMateria"));
    
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Matéria: <% out.println(nova_materia.getNomeMateria());  %>  </h1>
    </body>
</html>
