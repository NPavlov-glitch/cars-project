package application;

import java.time.LocalDateTime;
import java.util.List;

public class Notification {
    // Method to generate notifications for expiring or expired rental periods
    public static void generateRentalNotifications(List<RentalProtocol> rentalHistory) {
        System.out.println("Rental Notifications:");
        for (RentalProtocol protocol : rentalHistory) {
            LocalDateTime now = LocalDateTime.now();
            if (protocol.getRentalEndDateTime().isBefore(now)) {
                System.out.println("Client: " + protocol.getClient().getName() +
                        ", Car: " + protocol.getRentedCar().getMake() + " " + protocol.getRentedCar().getModel() +
                        ", Rental End Date: " + protocol.getRentalEndDateTime() +
                        " - Expired");
            } else if (protocol.getRentalEndDateTime().minusDays(1).isBefore(now)) {
                System.out.println("Client: " + protocol.getClient().getName() +
                        ", Car: " + protocol.getRentedCar().getMake() + " " + protocol.getRentedCar().getModel() +
                        ", Rental End Date: " + protocol.getRentalEndDateTime() +
                        " - Expiring tomorrow");
            }
        }
        System.out.println();
    }
}
