package pl.senla.lecture3.task4.entity;

import java.util.List;

public class Client {

    private int idClient;
    private String name;
    private int phoneNumber;
    private List<Order> orders;

    public Client() {
    }

    public Client(int idClient) {
        this.idClient = idClient;
    }

    public Client(int idClient, String name, int phoneNumber, List<Order> orders) {
        this.idClient = idClient;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.orders = orders;
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "\nClient{" +
                "idClient=" + idClient +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", orders=" + orders +
                '}';
    }
}
