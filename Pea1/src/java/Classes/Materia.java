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
}
