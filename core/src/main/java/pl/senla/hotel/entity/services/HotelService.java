package pl.senla.hotel.entity.services;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.service.ServiceFacility;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Slf4j
@Entity
@Table(name = "reservations")
public class HotelService implements Serializable {

    @Serial
    private static final long serialVersionUID = 20L;

    @Id
    @Column(name = "serviceID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idService;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderID")
    private Order order;

    @Enumerated(EnumType.STRING)
    @Column(name = "serviceType", nullable = false)
    private TypeOfService typeOfService;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guestID")
    private Guest guest;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facilityID", referencedColumnName = "facilityID")
    private Room room;

    @Column(name = "day", nullable = false)
    private Integer numberOfDays;

    @Column(name = "checkIn")
    private LocalDateTime checkInTime;

    @Column(name = "checkOut")
    private LocalDateTime checkOutTime;

    @Column(name = "cost", nullable = false)
    private Integer cost;

    @Autowired
    private transient ServiceFacility serviceRoom;

    @Override
    public String toString() {
        return "HotelService{" +
                "idService=" + idService +
                ", idOrder=" + order.getIdOrder() +
                ", typeOfService=" + typeOfService +
                "\nGuest=" + guest.getIdGuest() +
                "\nRoom=" + room.getIdRoom() +
                "\nnumberOfDays=" + numberOfDays +
                ", checkInTime=" + checkInTime +
                ", checkOutTime=" + checkOutTime +
                ", cost=" + cost +
                '}';
    }
}
