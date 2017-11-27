package memorydb;
import java.util.ArrayList;
import java.util.List;

import books.Author;
import commondb.AuthorDAO;
import commondb.DAOException;

public class AuthorDAOmemory implements AuthorDAO {
    
    private static List<Author> authors = new ArrayList<Author>();    
    
    @Override
    public Author getByID(int id) {
        for(Author a : authors) {
            if(a.getId() == id) {
                return a;
            }
        }
        return null;
    }
    
    
    
    

    @Override
    public Author create(String name, String address, String phone) throws DAOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Author> getAll() throws DAOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Author author) throws DAOException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Author author) throws DAOException {
        // TODO Auto-generated method stub
        
    }
    
    static {
        Author a = new Author(1);
        a.setName("Ben");
        a.setAddress("CA");
        a.setPhone("1111");
        authors.add(a);
    }

}
