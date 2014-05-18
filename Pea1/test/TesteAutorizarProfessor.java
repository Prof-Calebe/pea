/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.BaseDAO;
import Classes.Colegiado;
import Classes.NDE;
import Classes.Professor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Wanderson
 */
public class TesteAutorizarProfessor {
    private BaseDAO dataBaseConnection;
    public TesteAutorizarProfessor() {
    }
    
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
    public void ValidaAutoriza(){
        Professor p1 = new Professor(12345, "Calebe");
        Professor p2 = new Professor(12346, "Joaquim");
        Colegiado p3 = new Colegiado(123, "Ana");
        NDE p4 = new NDE(12, "Vallim");

        dataBaseConnection.salvar(p1);
        dataBaseConnection.salvar(p2);
        dataBaseConnection.salvar(p3);
        dataBaseConnection.salvar(p4);
        
        Professor p5 = new Professor(12345, "Calebe");
        Professor p6 = new Professor(12346, "Joaquim");
        Colegiado p7 = new Colegiado(123, "Ana");
        NDE p8 = new NDE(12, "Vallim");
        
        Assert.assertTrue (p8.Validate(p5));
        Assert.assertTrue (p8.Validate(p6));
        Assert.assertTrue (p8.Validate(p7));
        
        Assert.assertTrue(p8.AutorizarProfessor(12345,"Calebe"));
        Assert.assertTrue(p8.AutorizarProfessor(12346,"Joaquim"));
        
        
    }
    
    
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
