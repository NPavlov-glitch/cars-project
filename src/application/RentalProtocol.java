package application;

import java.time.LocalDateTime;

public class RentalProtocol {
    private Car rentedCar;
    private Client client;
    private LocalDateTime rentalStartDateTime;
    private LocalDateTime rentalEndDateTime;
    private String status; // e.g., smooth, with issues
    private String protocolDescription;

    // Constructors
    public RentalProtocol(Car rentedCar, Client client, LocalDateTime rentalStartDateTime, LocalDateTime rentalEndDateTime, String status, String protocolDescription) {
        this.rentedCar = rentedCar;
        this.client = client;
        this.rentalStartDateTime = rentalStartDateTime;
        this.rentalEndDateTime = rentalEndDateTime;
        this.status = status;
        this.protocolDescription = protocolDescription;
    }

    // Getters and Setters
    public Car getRentedCar() {
        return rentedCar;
    }

    public void setRentedCar(Car rentedCar) {
        this.rentedCar = rentedCar;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getRentalStartDateTime() {
        return rentalStartDateTime;
    }

    public void setRentalStartDateTime(LocalDateTime rentalStartDateTime) {
        this.rentalStartDateTime = rentalStartDateTime;
    }

    public LocalDateTime getRentalEndDateTime() {
        return rentalEndDateTime;
    }

    public void setRentalEndDateTime(LocalDateTime rentalEndDateTime) {
        this.rentalEndDateTime = rentalEndDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProtocolDescription() {
        return protocolDescription;
    }

    public void setProtocolDescription(String protocolDescription) {
        this.protocolDescription = protocolDescription;
    }
}
