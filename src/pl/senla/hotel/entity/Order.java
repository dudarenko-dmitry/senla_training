package pl.senla.hotel.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {

    private Integer idOrder;
    private int idGuest;
    private List<Integer> idServices = new ArrayList<>();

    @Serial
    private static final long serialVersionUID = 31L;

    public Order(int idGuest) {
        this.idOrder = idGuest;
    }

    public Order(int idGuest, List<Integer> idServices) {
        this.idGuest = idGuest;
        this.idServices = idServices;
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

    public List<Integer> getServices() {
        return idServices;
    }

    public void setServices(List<Integer> idServices) {
        this.idServices = idServices;
    }

    @Override
    public String toString() {
        return "\n=== > Order{" +
                "idOrder=" + idOrder +
                ", idGuest= " + idGuest +
                ", idServices= " + idServices +
                '}';
    }
}
