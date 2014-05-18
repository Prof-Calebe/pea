/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

/**
 *
 * @author Wanderson
 */
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
 
@Entity
public class Professor implements Serializable {

    @Id     @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private long drt;
    private String nome;
    private boolean autorizado;

    public Professor() {
        super();
    }
    
    Professor(long Drt, String Nome){
        super();
        this.drt=Drt;
        this.nome=Nome;
        this.autorizado=false;
    }
    public void setNome(String Nome){
        this.nome=Nome;
    }
    public void setDrt(long drt){
            this.drt=drt;
    }
   public void setAutorizacao(NDE nde,Colegiado colegiado){
       if(nde.AutorizarProfessor(drt,nome)){
        this.autorizado=true;}
    }
   
    public String getNome(){
        return this.nome;
    }
    public Long getDrt(){
        return this.drt;
    }
    public boolean getAutorizacao(){
        return this.autorizado;
    }
    public void Validate() {
        BaseDAO db = new BaseDAO();
        db.abreDB();
        List<Professor> result = db.retornaManager().createQuery("SELECT l from Professor l where l.drt = :drt and l.nome = :nome").setParameter("drt", this.drt).setParameter("nome", this.nome).setParameter("autorização", this.autorizado).getResultList();
        db.fechaDB();
        
        if (result.size() > 0)
        {
            Professor t = result.iterator().next();
            //this.id = t.getId();
            //setTipoLogin(t.getTipoLogin());
        }
            
    }
}
