<%-- 
    Arquivo responsável por inserir a matéria no banco 
    
    Document   : cadastrarMateria
    Created on : 22/11/2013, 16:40:46
    Author     : thyago


--%>

<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="Classes.Materia" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%

    Materia nova_materia = new Materia();
    nova_materia.setNomeMateria(request.getParameter("nomeMateria"));
    
    //persistindo o objeto no banco
    EntityManagerFactory factory = nova_materia.retornaFactory();
    factory = Persistence.createEntityManagerFactory("Pea1PU");
    
    EntityManager manager = nova_materia.retornaManager();
    manager = factory.createEntityManager();
       
    manager.getTransaction().begin();    
    manager.persist(nova_materia);
    manager.getTransaction().commit();  
    
    //final da persistência
    
    
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Matéria <% out.println(nova_materia.getNomeMateria());  %> cadastrada com sucesso. </h2>
        <a href="formCadastrarMateria.html">Voltar</a>
    </body>
</html>
