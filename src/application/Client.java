package application;

public class Client {
    private int clientId;
    private String name;
    private String phone;
    private String address;

    // Constructors
    public Client(int clientId, String name, String phone, String address) {
        this.clientId = clientId;
        this.name = name;
        this.phone = phone;
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
