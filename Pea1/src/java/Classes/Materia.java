/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Thyago
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Materia extends BaseDAO implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeMateria;
    private Long idUsuario;
    private String plano;

    public Materia() {
    }

    public Materia(String nomeMateria, String s) {
        //this.id = id;
        this.nomeMateria = nomeMateria;
        this.idUsuario = null;
        this.plano = s;
    }
    
    /**
     * @return the nomeMateria
     */
    public String getNomeMateria() {
        return nomeMateria;
    }

    /**
     * @param nomeMateria the nomeMateria to set
     */
    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }
    
     /**
     * @return the idUsuario
     */
    public Long getidUsuario() {
        return idUsuario;
    }
   
    /**
     * @param id the idUsuario to set
     */
     public void setidUsuario(Long id) {     
        this.idUsuario = id;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public Long getId() {
        return id;
    }
     
    public boolean Validate() {
        BaseDAO db = new BaseDAO();
        db.abreDB();
        List<Materia> result = db.retornaManager().createQuery("SELECT p from Materia p where p.nomeMateria = :nome").setParameter("nome", this.nomeMateria).getResultList();
        db.fechaDB();
        
        if (result.size() > 0)
        {
            Materia t = result.iterator().next();
            if(t.getId()==this.getId())
                return true;
        }
            return false;
    }  
}
