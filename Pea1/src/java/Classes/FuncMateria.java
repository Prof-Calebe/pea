/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author 31121233
 */
public class FuncMateria {
    public static void main(String args[]){
       /* Materia materia= new Materia("Teste de Software","Sem Plano de Ensino");
        BaseDAO db = new BaseDAO();
        db.abreDB();
        db.salvar(materia);
        db.fechaDB();
       */ 
        Funcionario f = new Funcionario();
        
        f.VizualizarPlanoEnsino("Teste de Software");
    }
}
