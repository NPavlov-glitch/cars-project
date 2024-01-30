package application;

import java.util.List;

public class Report {
    // Method to generate a report of available cars
    public static void generateAvailableCarsReport(List<Car> availableCars) {
        System.out.println("Available Cars Report:");
        for (Car car : availableCars) {
            System.out.println("Car: " + car.getModel());
        }
        System.out.println();
    }


    // Method to generate a report of operators and their work
    public static void generateOperatorsWorkReport(List<? extends User> operators) {
        System.out.println("Operators Work Report:");
        for (User operator : operators) {
            System.out.println("Operator: " + operator.getUsername() +
                    ", Role: " + operator.getRole());
        }
        System.out.println();
    }
}
