/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Song
 */
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;

@Entity
public class Login extends BaseDAO implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nome;
    private String senha;
    private String tipoLogin;
    
    public Login(){
        super();
    }
    
    public Login(String nome, String senha, String tipoLogin){
        super();
        this.nome = nome;
        this.senha = senha;
        this.tipoLogin = tipoLogin;
    }
    
    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getTipoLogin() {
        return tipoLogin;
    }

    public void setTipoLogin(String tipoLogin) {
        this.tipoLogin = tipoLogin;
    }
    
    public void setID(int newID)
    {
        this.id = newID;
    }
    
    public int getId() {
        return id;
    }
    
    public void Validate() {
        List<Login> result = retornaManager().createQuery("SELECT l from Login l where l.nome = :name and l.senha = :password").setParameter("name", this.nome).setParameter("password", this.senha).getResultList();
        if (result.size() > 0)
        {
            Login t = result.iterator().next();
            this.id = t.getId();
            setTipoLogin(t.getTipoLogin());
        }
            
    }
    
    public void Save() {
        salvar(this);
    }
    
    public void LoadLoginByID(int id){
        try{
            Login credentials = retornaManager().find(Login.class, id);
            this.id = credentials.getId();
            setNome(credentials.getNome());
            setSenha(credentials.getSenha());
            setTipoLogin(credentials.getTipoLogin());
        }
            catch(Exception e){
        }
    }
}
