package derbydb;
import java.util.List;

import books.Book;
import commondb.BookDAO;
import commondb.DAOException;

public class BookDAOderby implements BookDAO {

    @Override
    public Book create(String name, String isbn, double price) throws DAOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Book> getAll() throws DAOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Book getByISBN(String isbn) throws DAOException {
        // TODO Auto-generated method stub
        return null;
    }

}
