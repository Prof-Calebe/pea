/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.BaseDAO;
import Classes.Login;
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
public class TesteLogin {
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
        Login credentials = new Login("Nome", "Senha", "Acesso");
        
        Assert.assertEquals("Nome", credentials.getNome());
        Assert.assertEquals("Senha", credentials.getSenha());
        Assert.assertEquals("Acesso", credentials.getTipoLogin());
        
        credentials.setNome("NomeEstranho");
        Assert.assertEquals("NomeEstranho", credentials.getNome());
        credentials.setSenha("SenhaEstranha");
        Assert.assertEquals("SenhaEstranha", credentials.getSenha());
    }
    
    @Test
    public void TestValidLogin()
    {
        Login credentials = new Login("usuarioTeste123", "senhaTeste123", "Acesso");
        dataBaseConnection.salvar(credentials);
        
        Login credentials2 = new Login("usuarioTeste123", "senhaTeste123", "");
        credentials2.Validate();
        Assert.assertTrue(credentials2.isValid());
        Assert.assertEquals(credentials.getId(), credentials2.getId());
        
        // Cleanup
        dataBaseConnection.retornaManager().clear();
        credentials = dataBaseConnection.retornaManager().find(Login.class, credentials.getId());
        dataBaseConnection.remover(credentials);
    }
    
    @Test
    public void TestInvalidLogin()
    {
        Login credentials = new Login("usuarioTeste123", "senhaTeste123", "Acesso");
        dataBaseConnection.salvar(credentials);
        
        Login credentials2 = new Login("usuarioTeste123", "senhateste123", "Acesso");
        credentials2.Validate();
        Assert.assertFalse(credentials2.isValid());
        
        // Cleanup
        dataBaseConnection.retornaManager().clear();
        credentials = dataBaseConnection.retornaManager().find(Login.class, credentials.getId());
        dataBaseConnection.remover(credentials);
    }
    
    @Test
    public void TestValidIDLoading()
    {
        Login credentials = new Login("usuarioTeste123", "senhaTeste123", "Acesso");
        dataBaseConnection.salvar(credentials);
        
        Login credentials2 = Login.LoadLoginByID(credentials.getId());
        Assert.assertEquals(credentials.getId(), credentials2.getId());
        
        // Cleanup
        dataBaseConnection.retornaManager().clear();
        credentials = dataBaseConnection.retornaManager().find(Login.class, credentials.getId());
        dataBaseConnection.remover(credentials);
    }
    
    @Test
    public void TestInvalidIDLoading()
    {
        Login credentials2 = Login.LoadLoginByID(-1);
        Assert.assertNull(credentials2);
    }
    
    @Test
    public void TestValidNameLoading()
    {
        Login credentials = new Login("usuarioTeste123", "senhaTeste123", "Acesso");
        dataBaseConnection.salvar(credentials);
        
        Login credentials2 = Login.LoadLoginByName("usuarioTeste123");
        Assert.assertEquals(credentials.getId(), credentials2.getId());
        
        // Cleanup
        dataBaseConnection.retornaManager().clear();
        credentials = dataBaseConnection.retornaManager().find(Login.class, credentials.getId());
        dataBaseConnection.remover(credentials);
    }
    
    @Test
    public void TestInvalidNameLoading()
    {
        Login credentials = Login.LoadLoginByName("uuuuuuuuuuu");
        Assert.assertNull(credentials);
    }
}