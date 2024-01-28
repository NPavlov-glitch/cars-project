package application;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Administrator extends User {
    private CarRentalCompany carRentalCompany;  // Reference to the CarRentalCompany
    private List<Car> availableCars;
    private List<Operator> operators;
    private List<RentalProtocol> rentalHistory;

    public Administrator(int id, String username, String password) {
        super(id, username, password, "Administrator");
        this.availableCars = new ArrayList<>();
        this.operators = new ArrayList<>();
        this.rentalHistory = new ArrayList<>();
    }

    public void setCarRentalCompany(CarRentalCompany carRentalCompany) {
        this.carRentalCompany = carRentalCompany;
    }

    public void createCarRentalCompany() {
        // Logic to create a car rental company
        System.out.println("Car rental company created: " + carRentalCompany.getName());
    }

    public void createOperator(int id, String username, String password) {
        Operator operator = new Operator(id, username, password);
        operator.setRole("Operator");
        operators.add(operator);
        System.out.println("Operator created: " + operator.getUsername());
    }

    public void registerCar(String model, int year, String carClass, String category, String features, String photos, boolean smoker) {
        Car car = new Car(model, year, carClass, category, features, photos, smoker);
        availableCars.add(car);
        System.out.println("Registered Car: " + car.getModel());
    }

    public void rentOutCar(Car car, Client client, LocalDateTime startDate, LocalDateTime endDate, String status, String description) {
        // Logic to rent out a car
        RentalProtocol protocol = new RentalProtocol(car, client, startDate, endDate, status, description);
        rentalHistory.add(protocol);
        availableCars.remove(car);
        System.out.println("Rented Out Car: " + car.getModel() + " to " + client.getName());

        // Generate renting history report after renting out a car
        generateRentingHistoryReport();
    }

    public void registerClient(int clientId, String name, String phone, String address) {
        // Logic to register a client
        Client client = new Client(clientId, name, phone, address);
        System.out.println("Registered Client: " + client.getName());
    }

    public void generateAvailableCarsReport() {
        // Generate available cars report
        Report.generateAvailableCarsReport(availableCars);
    }

    public void generateOperatorsWorkReport() {
        // Generate operators work report
        Report.generateOperatorsWorkReport(operators);
    }

    public void generateRentingHistoryReport() {
        // Generate renting history report
        List<RentalProtocol> allRentalHistory = new ArrayList<>();
        for (Operator operator : operators) {
            allRentalHistory.addAll(operator.getRentalHistory());
        }
        Report.generateRentingHistoryReport(allRentalHistory);
    }
}
