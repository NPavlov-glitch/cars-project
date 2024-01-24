package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/car_rental";
    private static final String USER = "root";
    private static final String PASSWORD = "kuku";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }
    
    public static boolean testConnection() {
        try (Connection connection = connect()) {
            System.out.println("Connection successful!");
            return true;
        } catch (SQLException e) {
            System.err.println("Connection failed!");
            e.printStackTrace();
            return false;
        }
    }

}
