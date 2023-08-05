package pl.senla.hotel.entity;

import java.io.Serial;
import java.io.Serializable;

public class Guest implements Serializable {

    private Integer idGuest;
    private String name;
    private int phoneNumber;

    @Serial
    private static final long serialVersionUID = 12L;
    public Guest() {
    }

    public Guest(int idGuest) {
        this.idGuest = idGuest;
    }

    public Guest(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(int idGuest) {
        this.idGuest = idGuest;
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
        return "\nGuest{" +
                "idGuest=" + idGuest +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
