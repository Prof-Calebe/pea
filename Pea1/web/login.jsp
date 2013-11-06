<%-- 
    Document   : login
    Created on : 05/11/2013, 12:38:34
    Author     : Song
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema para o plano de Ensino e Aula da FCI</title>
    </head>
    <body>
        <h1>Login</h1>
        <form name="formLogin" action="menuPrincipal.jsp">
            <h3>Nome:</h3>
            <input type="text" name="user" value="" size="25" />
            <h3>Senha:</h3>
            <input type="text" name="senha" value="" size="25" />
            <input type="submit" value="Submit" name="Submit" />
        </form>
    </body>
</html>
