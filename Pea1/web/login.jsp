<%-- 
    Document   : login2
    Created on : May 11, 2014, 5:29:42 PM
    Author     : Adriano
--%>
<%@page import="java.util.*"%>
<%@page import="Classes.Login" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  
    if(request.getParameter("user") != null && request.getParameter("senha") != null)
    {
        Login credentials = new Login(request.getParameter("user"), request.getParameter("senha"), "");
        credentials.abreDB();
        credentials.Validate();
        if (credentials.getId() != 0)
        {
            request.getSession().setAttribute("sessionID", credentials.getId());
            response.sendRedirect("menuPrincipal.jsp");
        }

        /*
        if (request.getParameter("save") != null)
        {
            credentials.Save();
        }
        */
        credentials.fechaDB();
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
