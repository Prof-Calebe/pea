/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Song
 */

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class BaseDAO {
	//fabrica de conexao
	private EntityManagerFactory factory;
	//manager de objetos do banco
	private EntityManager manager;
	
	//devolve o manager em uso
	public EntityManager retornaManager(){
		return manager;
	}
	
	public EntityManagerFactory retornaFactory(){
		
		return factory;
	}
	
	
	public void abreDB(){
		factory = Persistence.createEntityManagerFactory("$objectdb/db/Pea.odb"); 
		manager = factory.createEntityManager();
	}
	
	public void fechaDB(){
		
		manager.close();
		factory.close();
	}
	
	public Object retornaAno(){
		
		Query minhaQuery = retornaManager().createNativeQuery("select year(curdate())");
		return minhaQuery.getSingleResult();
	}
	
	//salvar como pra atualizar os dados
	public void salvar(Object o){
        System.out.println("asd");
		try{
        manager.getTransaction().begin();
        manager.persist(o);
        manager.getTransaction().commit();
		}catch(Exception e){
			System.out.println("deu erro de salvar");
		}
	}
	
	//remove 
	public void remover(Object o){
		manager.getTransaction().begin();
        manager.remove(o);
		manager.getTransaction().commit();
	}
	
	public void iguala(BaseDAO b)
	{
	this.factory = b.retornaFactory();
	this.manager = b.retornaManager();
	}
	
	public BaseDAO getDAO()
	{
		return this;
	}
}
