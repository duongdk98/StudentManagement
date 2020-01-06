package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    public static Connection getConnection() {
        String user = "root";
        String password = "1234";
        String connectionURL = "jdbc:mysql://localhost:3306/student";
        Connection cn = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(connectionURL,user,password);
        } catch (SQLException e) {

        } catch (ClassNotFoundException e) {

        }
        return cn;
    }

}
