package pl.senla.hotel.entity.services;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.service.ServiceFacility;

import javax.persistence.*;
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

//    @Column(name = "orderID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderID")
    private Order order;

    @Enumerated(EnumType.STRING)
    @Column(name = "serviceType", nullable = false)
    private TypeOfService typeOfService;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guestID")
    private Guest guest;

//    @Column(name = "facilityID", nullable = false)
//    private Integer idRoom;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facilityID", referencedColumnName = "facilityID")
    private Room room;

    @Column(name = "day", nullable = false)
    private Integer numberOfDays;

    @Column(name = "checkIn", nullable = false)
    private LocalDateTime checkInTime;

    @Column(name = "checkOut", nullable = false)
    private LocalDateTime checkOutTime;

    @Column(name = "cost", nullable = false)
    private Integer cost;

    @GetInstance(beanName = "ServiceFacilityDB")
    private transient ServiceFacility serviceRoom;

    @Override
    public String toString() {
        return "HotelService{" +
                "idService=" + idService +
                ", idOrder=" + order +
                ", typeOfService=" + typeOfService +
                "\nGuest=" + guest +
                "\nRoom=" + room +
                "\nnumberOfDays=" + numberOfDays +
                ", checkInTime=" + checkInTime +
                ", checkOutTime=" + checkOutTime +
                ", cost=" + cost +
                '}';
    }
}
