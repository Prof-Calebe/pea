<%-- 
    Document   : login
    Created on : 05/11/2013, 12:38:34
    Author     : Song
--%>
<%@page import="java.util.*"%>
<%@page import="Classes.BaseDAO" %>
<%@page import="Classes.Login" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%  
    //logica para verificar se o usuario esta cadastrado
    if(request.getParameter("user") != null && request.getParameter("senha") != null){
        
        Login meuLogin = new Login();
        Login confere = null;
        
        try{
            //abri conexao com o banco de dados
            meuLogin.abreDB();
            
            List <Login> busca = meuLogin.pesquisaLoginPeloLogin(request.getParameter("user"), request.getParameter("senha"));
            
            for(Login e : busca){
                confere = e;
            }
            
            meuLogin.fechaDB();

        }catch(Exception e){
            e.printStackTrace();
            e.getMessage();
        }
        
        if(confere.equals(null) != true){
            response.sendRedirect("menuPrincipal.jsp?user="+confere.getNome()+"&senha="+confere.getSenha());
        }
    }
    
    
    
    
%>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema para o plano de Ensino e Aula da FCI</title>
    </head>
    <body>
        <h1>Login</h1>
        <form name="formLogin" action="login.jsp">
            <h3>Nome:</h3>
            <input type="text" name="user" value="" size="25" />
            <h3>Senha:</h3>
            <input type="password" name="senha" value="" size="25" />
            <input type="submit" value="Submit" name="Submit" />
        </form>
    </body>
</html>
