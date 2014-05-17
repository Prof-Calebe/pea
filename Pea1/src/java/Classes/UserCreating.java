package Classes;


public class UserCreating 
{
    public static void main(String args[])
    {
        Login credentials = new Login("teste", "123", "");
        BaseDAO db = new BaseDAO();
        db.abreDB();
        db.salvar(credentials);
        db.fechaDB();
    }
}
