package application;

import java.time.LocalDateTime;

public class CarRentalCompany {
    private String name;

    private Administrator administrator;

    public CarRentalCompany(String adminUsername, String adminPassword) {
        // Initialize the administrator
        administrator = new Administrator(adminUsername, adminPassword);
        this.name = "BestCarsRental";
    }

    public String getName() {
        return name;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void createCarRentalCompany() {
        // Logic to create a car rental company
        System.out.println("Car rental company created: " + name);
    }

    public void createOperator(String username, String password) {
        // Logic to create an operator
        administrator.createOperator(username, password);
    }

    public void registerClient(int clientId, String name, String contactDetails) {
        // Logic to register a client
        administrator.registerClient(clientId, name, contactDetails);
    }

    public void registerCar(String make, String model, int year, String carClass, String category, String features, String photos, boolean smoker) {
        administrator.registerCar(make, model, year, carClass, category, features, photos, smoker);
    }

    public void rentOutCar(Car car, Client client, LocalDateTime startDate, LocalDateTime endDate, String status, String description) {
        // Logic to rent out a car
        administrator.rentOutCar(car, client, startDate, endDate, status, description);
    }

    public void generateReports() {
        // Logic to generate reports
        administrator.generateAvailableCarsReport();
        administrator.generateRentingHistoryReport();
        administrator.generateOperatorsWorkReport();
    }

    public void handleNotifications() {
        // Logic to handle notifications (expiring/expired rental periods)
    }
}
