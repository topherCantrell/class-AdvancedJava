package commondb;

import derbydb.AuthorDAOderby;
import derbydb.BookDAOderby;
import derbydb.PublisherDAOderby;
import memorydb.AuthorDAOmemory;
import memorydb.BookDAOmemory;
import memorydb.PublisherDAOmemory;

public class DBManager {
    
    static AuthorDAO authorDAO;
    static BookDAO bookDAO;
    static PublisherDAO publisherDAO;
    
    public static void configure(int type) {
        if(type==1) {
            authorDAO = new AuthorDAOderby();
            bookDAO = new BookDAOderby();
            publisherDAO = new PublisherDAOderby();
        } else {
            authorDAO = new AuthorDAOmemory();
            bookDAO = new BookDAOmemory();
            publisherDAO = new PublisherDAOmemory();
        }
    }
    
    public static AuthorDAO getAuthorDAO() {
        return authorDAO;
    }    
    public static BookDAO getBookDAO() {
        return bookDAO;
    }    
    public static PublisherDAO getPublisherDAO() {
        return publisherDAO;
    }

}
