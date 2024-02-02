package application;

import java.time.LocalDateTime;

public class RentalProtocol {
	private int id;
    private int carId;
    private int clientId;
    private LocalDateTime rentalStartDateTime;
    private LocalDateTime rentalEndDateTime;
    private String rentalNotes;
    private boolean rentalStatus;

    // Constructors
    public RentalProtocol(int id, int carId, int clientId, LocalDateTime rentalStartDateTime, LocalDateTime rentalEndDateTime, String rentalNotes, boolean rentalStatus) {
    	this.id = id;
        this.carId = carId;
        this.clientId = clientId;
        this.rentalStartDateTime = rentalStartDateTime;
        this.rentalEndDateTime = rentalEndDateTime;
        this.rentalNotes = rentalNotes;
        this.rentalStatus = rentalStatus;
    }
    
    public RentalProtocol(int carId, int clientId, LocalDateTime rentalStartDateTime, LocalDateTime rentalEndDateTime, String rentalNotes, boolean rentalStatus) {
        this.carId = carId;
        this.clientId = clientId;
        this.rentalStartDateTime = rentalStartDateTime;
        this.rentalEndDateTime = rentalEndDateTime;
        this.rentalNotes = rentalNotes;
        this.rentalStatus = rentalStatus;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter methods for carId
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    // Getter and setter methods for clientId
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    // Getter and setter methods for rentalStartDateTime
    public LocalDateTime getRentalStartDateTime() {
        return rentalStartDateTime;
    }

    public void setRentalStartDateTime(LocalDateTime rentalStartDateTime) {
        this.rentalStartDateTime = rentalStartDateTime;
    }

    // Getter and setter methods for rentalEndDateTime
    public LocalDateTime getRentalEndDateTime() {
        return rentalEndDateTime;
    }

    public void setRentalEndDateTime(LocalDateTime rentalEndDateTime) {
        this.rentalEndDateTime = rentalEndDateTime;
    }

    // Getter and setter methods for rentalNotes
    public String getRentalNotes() {
        return rentalNotes;
    }

    public void setRentalNotes(String rentalNotes) {
        this.rentalNotes = rentalNotes;
    }

    // Getter and setter methods for rentalStatus
    public boolean getRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(boolean rentalStatus) {
        this.rentalStatus = rentalStatus;
    }
}
