/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.BaseDAO;
import Classes.Login;
import Classes.Materia;
import javax.persistence.Query;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Song
 */
public class TesteMateria {
    private BaseDAO dataBaseConnection;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dataBaseConnection = new BaseDAO();
        dataBaseConnection.abreDB();
    }

    @After
    public void tearDown() {
        dataBaseConnection.fechaDB();
    }

    @Test
    public void TestDataIntegrity()
    {
        Materia materia = new Materia("Teste", "Testes");
        
        Assert.assertEquals("Teste", materia.getNomeMateria());
        Assert.assertEquals("Testes", materia.getPlano());
        
        materia.setPlano("Mais Testes");
        Assert.assertEquals("Mais Testes", materia.getPlano());
    }
    
    public void testaQuery(){
        Materia materia = new Materia("Teste", "Testes");
        dataBaseConnection.salvar(materia);
        
        Query query = dataBaseConnection.retornaManager().createQuery("SELECT m from Materia m where m.nomeMateria = :name").setParameter("name", "Teste");
        Materia m1 = (Materia) query.getSingleResult();
        m1.Validate();
        
        System.out.println(m1.getPlano());
    }
    
}