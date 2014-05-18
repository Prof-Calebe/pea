/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.util.List;

/**
 *
 * @author Wanderson
 */
public class ProfessorCreating {
    public static void main(String args[]){
        Professor professor= new Professor(1234,"Calebe");
        BaseDAO db = new BaseDAO();
        db.abreDB();
        //db.salvar(professor);
        
        
        List<Professor> result;
        result = db.retornaManager().createQuery("SELECT p FROM Professor p WHERE p.drt = :drt").setParameter("drt", professor.getDrt()).getResultList();
        
        for (Professor p: result){
            System.out.println(p);
        }
        db.fechaDB();
    }
}
