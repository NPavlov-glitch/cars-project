package application;

import java.time.LocalDateTime;

public class CompletionProtocol {
	private int id;
	private int rentalId;
	private String notes;
	private LocalDateTime date;
	
	public CompletionProtocol(int rentalId, String notes, LocalDateTime date) {
        this.rentalId = rentalId;
        this.notes = notes;
        this.date = date;
    }

    public CompletionProtocol(int id, int rentalId, String notes, LocalDateTime date) {
        this.id = id;
        this.rentalId = rentalId;
        this.notes = notes;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
