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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form name="formLogin" action="menuPrincipal.jsp">
            <h6>Nome:</h6>
            <input type="text" name="user" value="" size="25" />
            <h6>Senha:</h6>
            <input type="text" name="senha" value="" size="25" />
            <input type="submit" value="Submit" name="Submit" />
        </form>
    </body>
</html>
