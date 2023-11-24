package pl.senla.hotel.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;
import java.io.Serializable;

import static pl.senla.hotel.constant.ClientConstant.*;

@Setter
@Getter
@Slf4j
public class Guest implements Serializable {

    private Integer idGuest;
    private String name;
    private Integer phoneNumber;

    @Serial
    private static final long serialVersionUID = 12L;
    public Guest() {
    }

    public Guest(String name, Integer phoneNumber) {
        if (name == null) {
            log.warn(ERROR_NULL_NAME);
            return;
        }
        if (phoneNumber == null) {
            log.warn(ERROR_NULL_PHONE);
            return;
        }
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            log.warn(ERROR_NULL_NAME);
        }
    }

    public void setPhoneNumber(Integer phoneNumber) {
        if (phoneNumber != null) {
            this.phoneNumber = phoneNumber;
        } else {
            log.warn(ERROR_NULL_PHONE);
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
