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
public class Colegiado extends Professor{
    
    public Colegiado(long Id, String Nome) {
        super(Id, Nome);
    }
    public void AutorizarProfessor(Professor professor){
        
        professor.setAutorizacao(true);
    }
}
