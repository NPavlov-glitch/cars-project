package application;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Administrator extends User {
    private CarRentalCompany carRentalCompany;  // Reference to the CarRentalCompany
    private List<Car> availableCars;
    private List<Operator> operators;

    public Administrator(int id, String username, String password) {
        super(id, username, password, "Administrator");
        this.availableCars = new ArrayList<>();
        this.operators = new ArrayList<>();
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

    public void generateAvailableCarsReport() {
        // Generate available cars report
        Report.generateAvailableCarsReport(availableCars);
    }

    public void generateOperatorsWorkReport() {
        // Generate operators work report
        Report.generateOperatorsWorkReport(operators);
    }
}
