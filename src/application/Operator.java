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

    public List<Car> getAvailableCars() {
        return availableCars;
    }

    public List<RentalProtocol> getRentalHistory() {
        return rentalHistory;
    }
}
