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
public class ProfessorCreating {
    public static void main(String args[]){
        Professor professor= new Professor(1234,"Calebe");
        BaseDAO db = new BaseDAO();
        db.abreDB();
        db.salvar(professor);
        db.fechaDB();
    }
}
