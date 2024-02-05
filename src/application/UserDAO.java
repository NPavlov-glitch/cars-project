package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final String INSERT_USER = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
    private static final String INSERT_COMPANY = "INSERT INTO company (name, location) VALUES (?, ?)";
    private static final String INSERT_CLIENT = "INSERT INTO clients (name, phone, address) VALUES (?, ?, ?)";
    private static final String INSERT_CAR = "INSERT INTO cars (model, year, class, category, features, photos, smoker) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String INSERT_RENTAL_PROTOCOL = "INSERT INTO rentals (client_id, car_id, rental_start_date, rental_end_date, rental_notes, is_rented) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String INSERT_COMPLETION_PROTOCOL = "INSERT INTO completed_rentals (rental_id, notes, date) VALUES (?, ?, ?)";
    private static final String SELECT_USER = "SELECT * FROM users WHERE username = ? AND password = ?";
    private static final String SELECT_PROTOCOL = "SELECT * FROM rentals WHERE id = ?";
    private static final String SELECT_CLIENT = "SELECT * FROM clients WHERE phone = ?";
    private static final String SELECT_ALL_CARS = "SELECT * FROM cars";
    private static final String SELECT_ALL_CLIENTS = "SELECT * FROM clients";
    private static final String SELECT_ALL_PROTOCOLS = "SELECT * FROM rentals";
    private static final String CHECK_USERNAME_AVAILABILITY = "SELECT * FROM users WHERE username = ?";
    private static final String UPDATE_RENTAL_PROTOCOL_STATUS = "UPDATE rentals SET is_rented = ? WHERE id = ?";

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
    
    public static boolean createRentalProtocol(SelectOptions selectedClientOption, SelectOptions selectedCarOption, LocalDate localDate, LocalDate localDate2, String rentalNotes) {
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RENTAL_PROTOCOL)) {
        	preparedStatement.setInt(1, selectedClientOption.getId());
        	preparedStatement.setInt(2, selectedCarOption.getId());

            Timestamp startTimestamp = Timestamp.valueOf(localDate.atStartOfDay());
            Timestamp endTimestamp = Timestamp.valueOf(localDate2.atStartOfDay());

            preparedStatement.setTimestamp(3, startTimestamp);
            preparedStatement.setTimestamp(4, endTimestamp);
            
            preparedStatement.setString(5, rentalNotes);
            preparedStatement.setBoolean(6, true);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean createCompletionProtocol(int rentalProtocolId, String notes) {
        try (Connection connection = DatabaseConnector.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMPLETION_PROTOCOL)) {
        	preparedStatement.setInt(1, rentalProtocolId);
        	preparedStatement.setString(2, notes);
            preparedStatement.setTimestamp(3, Timestamp.from(Instant.now()));
            

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
	
	public static List<Car> getAllCars() {
	    List<Car> cars = new ArrayList<>();

	    try (Connection connection = DatabaseConnector.connect();
	         PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CARS);
	         ResultSet resultSet = preparedStatement.executeQuery()) {

	        while (resultSet.next()) {
	            Car car = new Car(
	            		resultSet.getInt("id"),
	                    resultSet.getString("model"),
	                    resultSet.getInt("year"),
	                    resultSet.getString("class"),
	                    resultSet.getString("category"),
	                    resultSet.getString("features"),
	                    resultSet.getString("photos"),
	                    resultSet.getBoolean("smoker")
	            );

	            cars.add(car);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return cars;
	}

	public static List<Client> getAllClients() {
	    List<Client> clients = new ArrayList<>();

	    try (Connection connection = DatabaseConnector.connect();
	         PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLIENTS);
	         ResultSet resultSet = preparedStatement.executeQuery()) {

	        while (resultSet.next()) {
	            Client client = new Client(
	            		resultSet.getInt("id"),
	                    resultSet.getString("name"),
	                    resultSet.getString("phone"),
	                    resultSet.getString("address")
	            );

	            clients.add(client);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return clients;
	}
	
	public static List<RentalProtocol> getAllRentalProtocols() {
	    List<RentalProtocol> protocols = new ArrayList<>();

	    try (Connection connection = DatabaseConnector.connect();
	         PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROTOCOLS);
	         ResultSet resultSet = preparedStatement.executeQuery()) {

	        while (resultSet.next()) {
	        	RentalProtocol protocol = new RentalProtocol(
	        			resultSet.getInt("id"),
	            		resultSet.getInt("car_id"),
	                    resultSet.getInt("client_id"),
	                    resultSet.getTimestamp("rental_start_date").toLocalDateTime(),
	                    resultSet.getTimestamp("rental_end_date").toLocalDateTime(),
	                    resultSet.getString("rental_notes"),
	                    resultSet.getBoolean("is_rented")
	            );

	        	protocols.add(protocol);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return protocols;
	}
	
	public static RentalProtocol getRentalProtocolFromId(int rentalProtocolId) {
	    try (Connection connection = DatabaseConnector.connect();
	         PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROTOCOL)) {
	        preparedStatement.setInt(1, rentalProtocolId);
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	                return new RentalProtocol(
	                        resultSet.getInt("id"),
	                        resultSet.getInt("car_id"),
	                        resultSet.getInt("client_id"),
	                        resultSet.getTimestamp("rental_start_date").toLocalDateTime(),
	                        resultSet.getTimestamp("rental_end_date").toLocalDateTime(),
	                        resultSet.getString("rental_notes"),
	                        resultSet.getBoolean("is_rented")
	                );
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public static boolean updateRentalStatus(int rentalProtocolId) { 
	    try (Connection connection = DatabaseConnector.connect();
	         PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RENTAL_PROTOCOL_STATUS)) {
	        preparedStatement.setBoolean(1, false);
	        preparedStatement.setInt(2, rentalProtocolId);
	        
	        int rowsUpdated = preparedStatement.executeUpdate();
	        
	        System.out.println("Protocol Status Updated");
	        
	        return rowsUpdated > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return false;
	}

}
