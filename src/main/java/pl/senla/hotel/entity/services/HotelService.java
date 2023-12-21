package pl.senla.hotel.entity.services;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.facilities.Room;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
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
    @Column(name = "service_type", nullable = false)
    private TypeOfService typeOfService;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guestID")
    private Guest guest;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facilityID", referencedColumnName = "facilityID")
    private Room room;

    @Column(name = "day", nullable = false)
    private Integer numberOfDays;

    @Column(name = "check_in")
    private LocalDateTime checkInTime;

    @Column(name = "check_out")
    private LocalDateTime checkOutTime;

    @Column(name = "cost", nullable = false)
    private Integer cost;

    @Override
    public String toString() {
        return "\nHotelService{" +
                "idService=" + idService +
                ", idOrder=" + order.getIdOrder() +
                ", typeOfService=" + typeOfService +
                ", Guest=" + guest.getIdGuest() +
                ", Room=" + room.getIdRoom() + "," +
                "\nnumberOfDays=" + numberOfDays +
                ", checkInTime=" + checkInTime +
                ", checkOutTime=" + checkOutTime +
                ", cost=" + cost +
                '}';
    }
}
