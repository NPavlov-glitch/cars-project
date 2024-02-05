package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RentalProtocol {
	private int id;
    private int carId;
    private int clientId;
    private LocalDateTime rentalStartDateTime;
    private LocalDateTime rentalEndDateTime;
    private String rentalNotes;
    private boolean rentalStatus;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getRentalStartDateTime() {
        return rentalStartDateTime;
    }

    public void setRentalStartDateTime(LocalDateTime rentalStartDateTime) {
        this.rentalStartDateTime = rentalStartDateTime;
    }
    
    public String getFormattedRentalStartDateTime() {
        if (rentalStartDateTime != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return rentalStartDateTime.format(formatter);
        } else {
            return "N/A";
        }
    }

    public LocalDateTime getRentalEndDateTime() {
        return rentalEndDateTime;
    }

    public void setRentalEndDateTime(LocalDateTime rentalEndDateTime) {
        this.rentalEndDateTime = rentalEndDateTime;
    }
    
    public String getFormattedRentalEndDateTime() {
        if (rentalEndDateTime != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return rentalEndDateTime.format(formatter);
        } else {
            return "N/A";
        }
    }

    public String getRentalNotes() {
        return rentalNotes;
    }

    public void setRentalNotes(String rentalNotes) {
        this.rentalNotes = rentalNotes;
    }

    public boolean getRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(boolean rentalStatus) {
        this.rentalStatus = rentalStatus;
    }
    
    public String getFormattedRentalStatus() {
    	if(rentalStatus) {
    		return "Currently Rented";
    	} else {
    		return "Rent Completed";
    	}
    }
}
