package application;

import java.util.ArrayList;
import java.util.List;

public class Administrator {
    private List<Car> availableCars;
    private List<Operator> operators;

    public Administrator() {
        this.availableCars = new ArrayList<>();
        this.operators = new ArrayList<>();
    }

    public void createCarRentalCompany() {
        // Logic to create a car rental company
    }

    public void createOperator(String username, String password) {
        Operator operator = new Operator();  // Create an instance of Operator
        operators.add(operator);
    }

    public void registerCar(Car car) {
        availableCars.add(car);
    }

    public void generateAvailableCarsReport(List<Car> cars) {
        // Logic to generate available cars report
    }

    public void generateRentingHistoryReport(List<RentalProtocol> rentalHistory) {
        // Logic to generate renting history report
    }

    // Additional methods as needed based on the specific requirements
}

