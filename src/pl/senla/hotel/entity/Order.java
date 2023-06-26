package pl.senla.hotel.entity;

import pl.senla.hotel.entity.services.HotelService;

import java.util.List;

public class Order {

    private int idOrder = -1;
    private Guest guest;
    private List<HotelService> services;

    public Order() {
    }

    public Order(int idOrder) {
        this.idOrder = idOrder;
    }

    public Order(Guest guest, List<HotelService> services) {
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
