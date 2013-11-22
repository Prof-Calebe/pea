<%-- 
    Document   : login
    Created on : 05/11/2013, 12:38:34
    Author     : Song
<--%>
<%@page import="java.util.*"%>
<%@page import="Classes.BaseDAO" %>
<%@page import="Classes.Login" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%  
    //logica para verificar se o usuario esta cadastrado
    if(request.getParameter("user") != null && request.getParameter("senha") != null){
        
        Login meuLogin = new Login();
        Login confere = null;
        List <Login> busca = null;
        
        try{
            //abri conexao com o banco de dados
            meuLogin.abreDB();
            
            busca = meuLogin.pesquisaLoginPeloLogin(request.getParameter("user"), request.getParameter("senha"));

            for(Login e : busca){
                confere = e;
            }
            
        }catch(Exception e){
            e.printStackTrace();
            meuLogin.fechaDB();
        }
        if(busca.size() >= 1){
            response.sendRedirect("menuPrincipal.jsp?user="+confere.getId());
        }else{
            %>
            <script>
                alert("Usuário não cadastrado!\nDica:\nUsuário song \nSenha 123");
            </script>
            <%
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
        <div align="center">
            <h1>Login</h1>
            <form name="formLogin" action="login.jsp">
                <h3>Nome:</h3>
                <input type="text" name="user" value="" size="25" />
                <h3>Senha:</h3>
                <input type="password" name="senha" value="" size="25" />
                <br/>
                <input type="submit" value="Entrar" name="Submit" />
            </form>
        </div>
    </body>
</html>
