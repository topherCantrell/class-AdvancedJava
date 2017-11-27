package commondb;

import books.Publisher;

public interface PublisherDAO {    
    public Publisher getAll() throws DAOException;
    public Publisher create(String name, String address) throws DAOException;
    // ...
}
