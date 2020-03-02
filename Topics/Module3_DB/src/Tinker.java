import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Tinker {    

    public static void main(String[] args) throws Exception  {

        Class.forName("org.apache.derby.jdbc.ClientDriver");

        try(Connection conn = DriverManager.getConnection("jdbc:derby://localhost/grades")) {
            
            String q = "select * from app.grades where subject=?";
            //String q = "select "+
            //              "phones.name, grades.grade "+
            //           "from "+
            //              "grades, phones "+
            //           "where "+
            //              "grades.name=phones.id and subject=?";

            try(PreparedStatement stmt = conn.prepareStatement(q)) {
                stmt.setString(1, "History");
                
                try(ResultSet rs = stmt.executeQuery()) {

                    while(rs.next()) {
                        System.out.println(rs.getString(2) + ":" + rs.getDouble(3));
                        //System.out.println(rs.getString(1) + ":" + rs.getDouble(2));
                    }                     
                } // close(rs)
            }
        }
    }

}
