package pl.senla.hotel.entity;

import pl.senla.hotel.entity.services.HotelService;

import java.util.List;

public class Order {

    private int idOrder = -1;
    private int idGuest;
    private List<HotelService> services;

    public Order(int idGuest) {
        this.idOrder = idGuest;
    }

    public Order(int idGuest, List<HotelService> services) {
        this.idGuest = idGuest;
        this.services = services;
    }

    public Order() {

    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(int idGuest) {
        this.idGuest = idGuest;
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
