package pl.senla.hotel.entity;

import java.io.Serial;
import java.io.Serializable;

import static pl.senla.hotel.constant.ClientConstant.*;

public class Guest implements Serializable {

    private Integer idGuest;
    private String name;
    private Integer phoneNumber;

    @Serial
    private static final long serialVersionUID = 12L;
    public Guest() {
    }

    public Guest(Integer idGuest) {
        this.idGuest = idGuest;
    }

    public Guest(String name, Integer phoneNumber) {
        if (name == null) {
            System.out.printf(ERROR_NULL_NAME);
            return;
        }
        if (phoneNumber == null) {
            System.out.printf(ERROR_NULL_PHONE);
            return;
        }
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Integer getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(Integer idGuest) {
        if (idGuest != null) {
            this.idGuest = idGuest;
        } else {
            System.out.printf(ERROR_NULL_ID);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            System.out.printf(ERROR_NULL_NAME);
        }
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        if (phoneNumber != null) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.printf(ERROR_NULL_PHONE);
        }
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
