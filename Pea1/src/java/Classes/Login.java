/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Song
 */
import java.util.List;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;

@Entity
public class Login extends BaseDAO implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;
    private String senha;

    public Login(){
        super();
    }
    
    public Login(String nome, String senha){
        super();
        this.nome = nome;
        this.senha = senha;
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
    
    public Login pesquisaLoginPeloID(Long id){
        try{
            return retornaManager().find(Login.class, id);
        }catch(Exception e){
            return null;
        }      
    }
    
    public List<Login> pesquisaLoginPeloLogin(String nome, String senha){
        Query minhaQuery = retornaManager().createQuery("select u from Login u where u.nome = '"+nome+ "' and u.senha = '"+senha+"'" );
        List<Login> retorno = minhaQuery.getResultList();
        return retorno;
    }
    
}
