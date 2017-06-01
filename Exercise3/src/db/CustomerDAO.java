package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pets.Customer;

public final class CustomerDAO {
    
    static {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    private CustomerDAO() {}
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost/pets");
    }
    
    public static List<Customer> getAllCustomers() throws SQLException {
        String query = "select * from app.customers";
        try(Connection conn = getConnection()) {
            try(PreparedStatement stmt = conn.prepareStatement(query)) {                
                try(ResultSet rs = stmt.executeQuery()) {
                    List<Customer> ret = new ArrayList<Customer>();
                    while(rs.next()) {
                        Customer c = new Customer(rs.getInt("id"));
                        c.setName(rs.getString("name"));
                        c.setNumCats(rs.getInt("numcats"));
                        c.setNumDogs(rs.getInt("numdogs"));
                        ret.add(c);
                    }
                    return ret;
                }
            }            
        }
    }
    
    public static Customer getCustomer(int id) throws SQLException {
        String query = "select * from app.customers where id=?";
        try(Connection conn = getConnection()) {
            try(PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, id);
                try(ResultSet rs = stmt.executeQuery()) {
                    if(rs.next()) {
                        Customer c = new Customer(rs.getInt("id"));
                        c.setName(rs.getString("name"));
                        c.setNumCats(rs.getInt("numcats"));
                        c.setNumDogs(rs.getInt("numdogs"));
                        return c;
                    }
                    return null;
                }
            }
        }
    }
    
    public static Customer createCustomer(String name, int numCats, int numDogs) throws SQLException {
        String query = "insert into app.customers (name,numCats,numDogs) values (?,?,?)";
        int generatedId;
        try(Connection conn = getConnection()) {            
            try(PreparedStatement stmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, name);
                stmt.setInt(2, numCats);
                stmt.setInt(3, numDogs);
                stmt.executeUpdate();
                try(ResultSet rs = stmt.getGeneratedKeys()) {
                    rs.next();
                    generatedId = rs.getInt(1);
                }
            }
        }
        return getCustomer(generatedId);
    }
    
    public static void deleteCustomer(int id) {        
    }
    
    public static void updateCustomer(Customer dustomer) {        
    }
    
    // -----
    
    public static List<Customer> hasNumCats(int numCats) {
        return null;
    }
    public static List<Customer> hasNumPets(int numPets) {
        return null;
    }
    public static List<Customer> hasOnlyType(boolean catType) {
        return null;
    }

}
