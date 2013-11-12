/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.Login;

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
public class TesteLogin {
    
    public TesteLogin() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void insereNovoLogin(){
        Login meuLogin = new Login();
        meuLogin.setNome("nome");
        meuLogin.setSenha("senha");
        assertArrayEquals(new Object[]{"nome"}, new Object[]{meuLogin.getNome()});
        assertArrayEquals(new Object[]{"senha"}, new Object[]{meuLogin.getSenha()});
        
    }
}