package pl.senla.lecture3.task4.entity;

import java.util.List;

public class Order {

    private int idOrder;
    private Client client;
    private List<HotelService> services;

    public Order() {
    }

    public Order(int idOrder) {
        this.idOrder = idOrder;
    }

    public Order(int idOrder, Client client, List<HotelService> services) {
        this.idOrder = idOrder;
        this.client = client;
        this.services = services;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<HotelService> getServices() {
        return services;
    }

    public void setServices(List<HotelService> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", client=" + client +
                ", services=" + services +
                '}';
    }
}
