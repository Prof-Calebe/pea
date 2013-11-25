<%
    // recebendo o id do usuario passado pelo paramento enviado pelo form no metodo get
    String userID = new String(request.getParameter("user"));
    
%>
<!DOCTYPE html>
<!--

Form para cadastro de matéria 

To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
        <h1>Cadastro de matéria</h1>
        <form name="Cadastro de matéria" action="cadastrarMateria.jsp">
            <input type="submit" value="Cadastrar" name="btnCadastra" />
            <input type="text" value="Digite o nome da matéria" name="nomeMateria" />
            <input type="hidden" value=<%out.println(userID);%> name="user" />
            <p><a href="menuPrincipal.jsp?user=<%out.println(userID);%>&retorno=0">Voltar</a></p>
        </form>
    </body>
</html>
