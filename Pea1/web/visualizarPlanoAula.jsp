<%-- 
    Document   : visualizarPlanoAula
    Created on : 12/11/2013, 16:29:30
    Author     : Song
--%>

<%@page import="Classes.BaseDAO" %>
<%@page import="Classes.Login" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%  // recebendo o id do usuario passado pelo paramento enviado pelo form no metodo get
    String userID = new String(request.getParameter("user"));
    
    Login meuLogin = new Login();
    
    try{
        //abre conexao com o banco
        meuLogin.abreDB();
        //recebe o objevo vindo do banco
        meuLogin = meuLogin.pesquisaLoginPeloID(Long.parseLong(userID));
        //encerra conexa com o banco
       meuLogin.fechaDB();
    }catch(Exception e){
        e.printStackTrace();
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema para o plano de Ensino e Aula da FCI</title>
    </head>
    <body>
        <div align="right">
            <a href="index.html">
                <h3>Sair</h3>
            </a>
        </div>
        <div align="center">
            <h1>Plano de Aula <%=meuLogin.getNome()%></h1>
        </div>
    </body>
</html>
