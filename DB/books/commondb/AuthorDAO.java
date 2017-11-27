package commondb;

import java.util.List;

import books.Author;

public interface AuthorDAO {    
    public Author create(String name, String address, String phone) throws DAOException;
    public List<Author> getAll() throws DAOException;
    public Author getByID(int id) throws DAOException;
    public void update(Author author) throws DAOException;
    public void delete(Author author) throws DAOException;
}
