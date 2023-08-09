package pl.senla.hotel.entity;

import java.io.Serial;
import java.io.Serializable;

public class CsvOrder implements Serializable {

    private int idOrder = -1;
    private int idGuest;
    private String idServices;

    @Serial
    private static final long serialVersionUID = 30L;

    public CsvOrder(int idGuest) {
        this.idOrder = idGuest;
    }

    public CsvOrder(int idGuest, String idServices) {
        this.idGuest = idGuest;
        this.idServices = idServices;
    }

    public CsvOrder() {

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

    public String getServices() {
        return idServices;
    }

    public void setServices(String idServices) {
        this.idServices = idServices;
    }

    @Override
    public String toString() {
        return "\n=== > CsvOrder{" +
                "idOrder=" + idOrder +
                ", idGuest= " + idGuest +
                ", idServices= " + idServices +
                '}';
    }
}
