package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private static final String INSERT_USER = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
    private static final String SELECT_USER = "SELECT * FROM users WHERE username = ? AND password = ?";
    private static final String CHECK_USERNAME_AVAILABILITY = "SELECT * FROM users WHERE username = ?";

    public static boolean createUser(String username, String password, String role) {
        try (Connection connection = DatabaseConnector.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
        	
        	if (isUsernameAvailable(username)) {
                System.out.println("Username already exist.");
                return false;
            }
        	
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, role);
            System.out.println("user created successfully!");
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean isUsernameAvailable(String username) {
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(CHECK_USERNAME_AVAILABILITY)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static User authenticateUser(String username, String password) {
    	
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("role")
                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
