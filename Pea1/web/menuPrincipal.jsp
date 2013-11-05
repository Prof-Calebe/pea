<%-- 
    Document   : menuPrincipal
    Created on : 05/11/2013, 13:00:30
    Author     : Song
--%>
<%@page import="Classes.BaseDAO" %>
<%@page import="Classes.Login" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>


<%  Login meuLogin = new Login(); 
    try{
        //abri conexao com o banco de dados
        meuLogin.abreDB();
        meuLogin.setNome(request.getParameter("user"));
        meuLogin.setSenha(request.getParameter("senha"));
        meuLogin.salvar(meuLogin);
        meuLogin.fechaDB();
    }catch(Exception e){
        e.printStackTrace();
        e.getMessage();
    }

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
