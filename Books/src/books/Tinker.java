package books;

import commondb.AuthorDAO;
import commondb.DBManager;

public class Tinker {

    public static void main(String[] args) throws Exception {
        
        DBManager.configure(1);
        
        AuthorDAO authorDAO = DBManager.getAuthorDAO();
                
        Author a = authorDAO.getByID(1);      
        
        System.out.println(a);

    }

}
