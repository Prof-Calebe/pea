/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.io.Serializable;

/**
 *
 * @author Wanderson
 */
public class NDE extends Professor implements Serializable {
    //private boolean autorizado;
    public NDE(long Id, String Nome) {
        super(Id, Nome);
        //this.autorizado=true;
    }
    public boolean AutorizarProfessor(long drt,String nome, String materia){
        Professor professor= new Professor(drt,nome);
        if(professor.Validate()){
            BaseDAO db = new BaseDAO();
            db.abreDB();
            int executeUpdate = db.retornaManager().createQuery("UPDATE Materia SET idUsuario = :id WHERE nomeMateria = :nome").setParameter("id", professor.getId()).setParameter("nome", materia).executeUpdate();
            db.fechaDB();
            return true;
        }
        return false;
    }
}
