/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.BaseDAO;
import Classes.Funcionario;
import Classes.Login;
import Classes.Materia;
import javax.persistence.Query;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
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
 /*   
    public void testaQuery(){
        Materia materia = new Materia("Teste", "Testes");
        dataBaseConnection.salvar(materia);
        
        Query query = dataBaseConnection.retornaManager().createQuery("SELECT m from Materia m where m.nomeMateria = :name").setParameter("name", "teste");
        Materia m1 = (Materia) query.getSingleResult();
        assertFalse(m1.Validate());
         
        
        System.out.println(m1.getPlano());
        dataBaseConnection.retornaManager().clear();
        materia = dataBaseConnection.retornaManager().find(Materia.class, materia.getId());
        dataBaseConnection.remover(materia);
    }*/
    @Test
    public void TestVizualizaPlano(){
         Materia materia= new Materia("Teste de Software","Sem Plano de Ensino");
         dataBaseConnection.salvar(materia);
        Funcionario f= new Funcionario();
        assertTrue(f.VizualizarPlanoEnsino("Teste de Software"));
        
        //Limpeza Banco
        dataBaseConnection.retornaManager().clear();
        materia = dataBaseConnection.retornaManager().find(Materia.class, materia.getId());
        dataBaseConnection.remover(materia);
    }
    @Test
    public void TestVizualizaPlanoNaocadastrado(){
         Materia m1= new Materia("Teste de Software","Sem Plano de Ensino");
         Materia m2= new Materia("Padroes de Projeto","GOF");
         Materia m3= new Materia("Gerencia de Projeto",null);
         dataBaseConnection.salvar(m1);
         dataBaseConnection.salvar(m2);
         dataBaseConnection.salvar(m3);
         Funcionario f= new Funcionario();
         assertFalse(f.VizualizarPlanoEnsino("Gerencia de Projeto"));
       
        //limpeza Banco
        dataBaseConnection.retornaManager().clear();
        m1 = dataBaseConnection.retornaManager().find(Materia.class, m1.getId());
        m2 = dataBaseConnection.retornaManager().find(Materia.class, m2.getId());
        m3 = dataBaseConnection.retornaManager().find(Materia.class, m3.getId());
        dataBaseConnection.remover(m1);
        dataBaseConnection.remover(m2);
        dataBaseConnection.remover(m3);
    }
    
    @Test
    public void TestMateriaExite(){
         Materia m1= new Materia("Teste de Software","Sem Plano de Ensino");
         Materia m2= new Materia("Padroes de Projeto","GOF");
         Materia m3= new Materia("Gerencia de Projeto",null);
         dataBaseConnection.salvar(m1);
         dataBaseConnection.salvar(m2);
         dataBaseConnection.salvar(m3);
        Funcionario f= new Funcionario();
        assertTrue(f.MateriaExite("Gerencia de Projeto"));
       
         //limpeza Banco
        dataBaseConnection.retornaManager().clear();
        m1 = dataBaseConnection.retornaManager().find(Materia.class, m1.getId());
        m2 = dataBaseConnection.retornaManager().find(Materia.class, m2.getId());
        m3 = dataBaseConnection.retornaManager().find(Materia.class, m3.getId());
        dataBaseConnection.remover(m1);
        dataBaseConnection.remover(m2);
        dataBaseConnection.remover(m3);
    }
    
    @Test
    public void TestMateriaNaoExite(){
         Materia m1= new Materia("Teste de Software","Sem Plano de Ensino");
         Materia m2= new Materia("Padroes de Projeto","GOF");
         Materia m3= new Materia("Gerencia de Projeto",null);
         dataBaseConnection.salvar(m1);
         dataBaseConnection.salvar(m2);
         dataBaseConnection.salvar(m3);
        Funcionario f= new Funcionario();
        assertFalse(f.MateriaExite("Sintese de Imagem"));
        dataBaseConnection.retornaManager().clear();
        
        
        //limpeza Banco
        m1 = dataBaseConnection.retornaManager().find(Materia.class, m1.getId());
        m2 = dataBaseConnection.retornaManager().find(Materia.class, m2.getId());
        m3 = dataBaseConnection.retornaManager().find(Materia.class, m3.getId());
        dataBaseConnection.remover(m1);
        dataBaseConnection.remover(m2);
        dataBaseConnection.remover(m3);
    }
}