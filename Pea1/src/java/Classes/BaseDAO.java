/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class BaseDAO {
    public BaseDAO ()
    {
        isOpen = false;
    }
	
	//devolve o manager em uso
	public EntityManager retornaManager(){
        assert(isOpen):"Database is not yet opened.";
		return manager;
	}
	
	public EntityManagerFactory retornaFactory(){
		assert(isOpen):"Database is not yet opened.";
		return factory;
	}
	
	
	public void abreDB(){
		factory = Persistence.createEntityManagerFactory("$objectdb/db/Pea.odb");
		manager = factory.createEntityManager();
        isOpen = true;
	}
	
	public void fechaDB(){
		manager.close();
		factory.close();
        isOpen = false;
	}
	
	public Object retornaAno(){
        assert(isOpen):"Database is not yet opened.";
		Query minhaQuery = retornaManager().createNativeQuery("select year(curdate())");
		return minhaQuery.getSingleResult();
	}
	
	//salvar como pra atualizar os dados
	public void salvar(Object o){
        assert(isOpen):"Database is not yet opened.";
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
        assert(isOpen):"Database is not yet opened.";
		manager.getTransaction().begin();
        manager.remove(o);
		manager.getTransaction().commit();
	}
    
    private boolean isOpen;
	private EntityManagerFactory factory;
	private EntityManager manager;
}
