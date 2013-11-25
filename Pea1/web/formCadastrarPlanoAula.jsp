<%
    // recebendo o id do usuario passado pelo paramento enviado pelo form no metodo get
    String userID = new String(request.getParameter("user"));
    
%>
<!DOCTYPE html>
<!-- 
Form para cadastro do plano de aula
-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastrar plano de aula</h1>
        <form name="plano_ensino" action="cadastrarPlanoAula.jsp">
            Nome da matéria: <input name="Nome da matéria"><br>
            <input type="submit" value="Cadastrar" name="btnCadastrar" />
            <p>Escolha a matéria: <select name="dropdownMateria">
                    <option></option>
                    <option></option>
                </select></p>
                <p>Digite o plano de aula: <textarea name="planoAula" rows="4" cols="20">
                    </textarea></p>
        </form>
    </body>
</html>
