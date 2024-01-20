package application;

public class Client {
    private int clientId;
    private String name;
    private String contactDetails;

    // Constructors
    public Client(int clientId, String name, String contactDetails) {
        this.clientId = clientId;
        this.name = name;
        this.contactDetails = contactDetails;
    }

    // Getters and Setters
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }
}
