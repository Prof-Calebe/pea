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
    private boolean autorizado;
    public Colegiado(long Id, String Nome) {
        super(Id, Nome);
        this.autorizado=true;
    }
    public boolean AutorizarProfessor(Professor professor){
        long drt;String nome;
        drt=professor.getDrt();
        nome=professor.getNome();
        return true;
    }
}
