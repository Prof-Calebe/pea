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
public class NDE extends Professor {
    private boolean autorizado;
    public NDE(long Id, String Nome,boolean Autorizado) {
        super(Id, Nome);
        this.autorizado=Autorizado;
    }
    public void AutorizarProfessor(Professor professor){
        professor.getId();
        professor.setAutorizacao(true);
    }
}
