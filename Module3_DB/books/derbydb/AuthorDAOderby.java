package derbydb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import books.Author;
import commondb.AuthorDAO;
import commondb.DAOException;

public class AuthorDAOderby implements AuthorDAO {

    @Override
    public Author getByID(int id) throws DAOException {
        try(Connection conn = DerbyConnection.getConnection()) {
            String sql = "select * from app.authors where id=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                Author ret = new Author(id);
                ret.setName(rs.getString("name"));
                ret.setPhone(rs.getString("phone"));
                ret.setAddress(rs.getString("address"));
                return ret;
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    
    
    
    @Override
    public Author create(String name, String address, String phone) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Author> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Author author) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Author author) {
        // TODO Auto-generated method stub
        
    }

}
