package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private static final String INSERT_USER = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
    private static final String INSERT_COMPANY = "INSERT INTO company (name, location) VALUES (?, ?)";
    private static final String INSERT_CLIENT = "INSERT INTO clients (name, phone, address) VALUES (?, ?, ?)";
    private static final String INSERT_CAR = "INSERT INTO cars (model, year, class, category, features, photos, smoker) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_USER = "SELECT * FROM users WHERE username = ? AND password = ?";
    private static final String SELECT_CLIENT = "SELECT * FROM clients WHERE phone = ?";
    private static final String SELECT_CAR = "SELECT * FROM cars WHERE id = ?";
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
    
    public static boolean createCar(Car car) {
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CAR)) {
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setInt(2, car.getYear());
            preparedStatement.setString(3, car.getCarClass());
            preparedStatement.setString(4, car.getCategory());
            preparedStatement.setString(5, car.getFeatures());
            preparedStatement.setString(6, car.getPhotos());
            preparedStatement.setBoolean(7, car.isSmoker());
            
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean createCompany(CarRentalCompany company) {
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMPANY)) {
            preparedStatement.setString(1, company.getName());
            preparedStatement.setString(2, company.getLocation());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean createClient(Client client) {
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT)) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getPhone());
            preparedStatement.setString(3, client.getAddress());

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
    
	public static Client authenticateClient(String phone) {
    	
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENT)) {
            preparedStatement.setString(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Client(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("phone"),
                        resultSet.getString("address")
                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
