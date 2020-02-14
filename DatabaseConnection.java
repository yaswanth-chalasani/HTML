
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;
public class DatabaseConnection {
    protected static Connection initializeDatabase() 
        throws SQLException, ClassNotFoundException 
    { 
        Class.forName("com.mysql.jdbc.Driver"); 
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root"); 
        return con; 
    } 

}
