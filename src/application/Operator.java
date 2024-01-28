package application;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Operator extends User {
    private List<Client> clients;
    private List<RentalProtocol> rentalHistory;
    private List<Car> availableCars;

    public Operator(int id, String username, String password) {
        super(id, username, password, "Operator");
        this.clients = new ArrayList<>();
        this.rentalHistory = new ArrayList<>();
        this.availableCars = new ArrayList<>();
    }

    public void registerClient(int clientId, String name, String phone, String address) {
        Client client = new Client(clientId, name, phone, address);
        clients.add(client);
        System.out.println("Client registered: " + client.getName());
    }

    public void rentOutCar(Car car, Client client, LocalDateTime startDate, LocalDateTime endDate, String status, String description) {
        RentalProtocol protocol = new RentalProtocol(car, client, startDate, endDate, status, description);
        rentalHistory.add(protocol);
        availableCars.remove(car);

        // Generate renting history report after renting out a car
        Report.generateRentingHistoryReport(rentalHistory);
    }

    public List<Car> getAvailableCars() {
        return availableCars;
    }

    public List<RentalProtocol> getRentalHistory() {
        return rentalHistory;
    }
}
