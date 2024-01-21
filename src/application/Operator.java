package application;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Operator {
    private List<Client> clients;
    private List<RentalProtocol> rentalHistory;
    private List<Car> availableCars;

    public Operator() {
        this.clients = new ArrayList<>();
        this.rentalHistory = new ArrayList<>();
        this.availableCars = new ArrayList<>();
    }

    public void registerClient(Client client) {
        clients.add(client);
    }

    public void rentOutCar(Car car, Client client, LocalDateTime startDate, LocalDateTime endDate, String status, String description) {
        RentalProtocol protocol = new RentalProtocol(car, client, startDate, endDate, status, description);
        rentalHistory.add(protocol);
        availableCars.remove(car);
    }

    public List<Car> getAvailableCars() {
        return availableCars;
    }

    public List<RentalProtocol> getRentalHistory() {
        return rentalHistory;
    }
}
