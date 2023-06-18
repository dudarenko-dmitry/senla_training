package pl.senla.hotel.entity;

import java.util.List;

public class Order {

    private int idOrder;
    private Guest guest;
    private List<HotelService> services;

    public Order() {
    }

    public Order(int idOrder) {
        this.idOrder = idOrder;
    }

    public Order(int idOrder, Guest guest, List<HotelService> services) {
        this.idOrder = idOrder;
        this.guest = guest;
        this.services = services;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Guest getClient() {
        return guest;
    }

    public void setClient(Guest guest) {
        this.guest = guest;
    }

    public List<HotelService> getServices() {
        return services;
    }

    public void setServices(List<HotelService> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "\nOrder{" +
                "idOrder=" + idOrder +
                ", " + services +
                '}';
    }
}
