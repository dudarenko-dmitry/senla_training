package pl.senla.hotel.entity;

public class Client {

    private int idClient;
    private String name;
    private int phoneNumber;

    public Client() {
    }

    public Client(int idClient) {
        this.idClient = idClient;
    }

    public Client(int idClient, String name, int phoneNumber) {
        this.idClient = idClient;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "\nClient{" +
                "idClient=" + idClient +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
