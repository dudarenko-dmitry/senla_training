package pl.senla.lecture3.task4.entity;

import java.util.List;

public class Client {

    private int idClient;
    private String nameClient;
    private int phoneNumber;
    private List<Order> orders;

    public Client() {
    }

    public Client(int idClient) {
        this.idClient = idClient;
    }

    public Client(int idClient, String nameClient, int phoneNumber, List<Order> orders) {
        this.idClient = idClient;
        this.nameClient = nameClient;
        this.phoneNumber = phoneNumber;
        this.orders = orders;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
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
        return "Client{" +
                "idClient=" + idClient +
                ", nameClient='" + nameClient + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", orders=" + orders +
                '}';
    }
}
