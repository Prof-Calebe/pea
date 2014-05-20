/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.List;

/**
 *
 * @author 31121233
 */
public class Funcionario {
    
   public Funcionario(){}
   
    public boolean VizualizarPlanoEnsino(String nomeMateria){
        
            BaseDAO db = new BaseDAO();
        db.abreDB();
        List<Materia> result =db.retornaManager().createQuery("SELECT M from Materia M where M.nomeMateria =:nomeMateria").setParameter("nomeMateria",nomeMateria).getResultList();
        db.fechaDB();
        boolean achou=false;
        for (Materia i: result){
           if(i.getNomeMateria().equals(nomeMateria)){
               if(i.getPlano()!=null){
                   System.out.println(i.getPlano());
               achou=true;
           return achou;
               }
           }
           
        }
            if(!achou){
            System.out.println("Materia Sem Plano de Ensino!");
            
            }
            return achou; 
    }
    public boolean MateriaExite(String nomeMateria){
        BaseDAO db = new BaseDAO();
        db.abreDB();
        List<Materia> result =db.retornaManager().createQuery("SELECT M from Materia M where M.nomeMateria =:nomeMateria").setParameter("nomeMateria",nomeMateria).getResultList();
        db.fechaDB();
        boolean achou=false;
        for (Materia i: result){
           if(i.getNomeMateria().equals(nomeMateria)){
               achou=true;
           return achou;
                            
           }
           
        }
            if(!achou){
            System.out.println("Materia Nao Cadastrada!");
            
            }
            return achou;
    }
}
