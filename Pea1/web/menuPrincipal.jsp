<%-- 
    Document   : menuPrincipal
    Created on : 05/11/2013, 13:00:30
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
        
    }catch(Exception e){
        e.printStackTrace();
        //encerra conexa com o banco
        meuLogin.fechaDB();
    }
    
    
%>

<!--este hidden do id do usuario vai ser passado para a funcao javascript-->
<input type="hidden" id="userID" value="<%=meuLogin.getId()%>" />

<script>
    function visualizarPlanoEnsino(){
        var search = document.getElementById('userID').value;
        window.location = "visualizarPlanoEnsino.jsp?user="+search+"&retorno=0";
    }
</script>

<script>
    function visualizarPlanoAula(){
        var search = document.getElementById('userID').value;
        window.location = "visualizarPlanoAula.jsp?user="+search+"&retorno=0";
    }
</script>


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
            <h1>Bem Vindo ao Sistema para o Plano de Ensino e Aula da FCI</h1>
            <br/>
            <h1>MENU PRINCIPAL</h1>
            <br/>
            <br/>
            <input type="button" name="btn_planoAula" value="Visualizar Plano de Aula" onclick="visualizarPlanoAula();" />
            <br/>
            <input type="button" name="btn_planoEnsino" value="Visualizar Plano de Ensino" onclick="visualizarPlanoEnsino();" />
            <br/>
        </div>
    </body>
</html>
