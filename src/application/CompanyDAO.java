package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompanyDAO {
    private static final String INSERT_COMPANY = "INSERT INTO company (name, location) VALUES (?, ?)";

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
}
