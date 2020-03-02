package commondb;

import java.util.List;

import books.Book;

public interface BookDAO {    
    public Book create(String name, String isbn, double price) throws DAOException;
    public List<Book> getAll() throws DAOException;
    public Book getByISBN(String isbn) throws DAOException;
    // ...
}
