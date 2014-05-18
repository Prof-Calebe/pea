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
import javax.persistence.*;
 
@Entity
public class Professor implements Serializable {

    @Id @GeneratedValue
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
    public void setId(long Id){
            this.id=Id;
    }
   public void setAutorizacao(boolean Autorizado){
        boolean Ndeautorizou=false,Colegiado=false;
        if(Ndeautorizou && Colegiado){
        this.autorizado=Autorizado;}
    }
    public String getNome(){
        return this.nome;
    }
    public Long getId(){
        return this.id;
    }
    public boolean getAutorizacao(){
        return this.autorizado;
    }
}
