package pl.senla.hotel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.entity.services.HotelService;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static pl.senla.hotel.constant.ClientConstant.*;

@Setter
@Getter
@NoArgsConstructor
@Slf4j
@Entity
@Table(name = "guests")
public class Guest implements Serializable {

    @Id
    @Column(name = "guestID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGuest;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private Integer phoneNumber;

    @OneToMany(mappedBy = "guestID")
    private List<HotelService> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "guestID")
    private List<Order> orders = new ArrayList<>();

    @Serial
    private static final long serialVersionUID = 12L;

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
