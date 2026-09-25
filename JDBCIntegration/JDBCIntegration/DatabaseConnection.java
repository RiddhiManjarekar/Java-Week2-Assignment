package JDBCIntegration;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    private static final String URL= "jdbc:mysql://localhost:3306/employee_management";
    private static final String USER="USER_NAME";
    private static final String PASSWORD="USER_PASSWORD";

    public static Connection getConnection() throws SQLException{
            return DriverManager.getConnection(URL,USER,PASSWORD); 
    }
}
