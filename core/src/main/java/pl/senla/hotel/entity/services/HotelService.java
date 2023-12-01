package pl.senla.hotel.entity.services;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.service.ServiceFacility;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static pl.senla.hotel.constant.HotelConstant.HOTEL_CHECK_IN_TIME;
import static pl.senla.hotel.constant.HotelConstant.HOTEL_CHECK_OUT_TIME;
import static pl.senla.hotel.constant.HotelServiceConstant.*;
import static pl.senla.hotel.constant.OrderConstant.ORDER_NOT_EXISTS;
import static pl.senla.hotel.constant.RoomReservationConstant.*;

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

    @Column(name = "orderID", nullable = false)
    private Integer idOrder;

    @Column(name = "serviceType", nullable = false)
    private TypeOfService typeOfService;

    @Column(name = "guestID", nullable = false)
    private Guest guest;
//    private Integer idGuest;

    @Column(name = "facilityID", nullable = false)
    private Integer idRoom;

    @Column(name = "day", nullable = false)
    private Integer numberOfDays;

    @Column(name = "checkIn", nullable = false)
    private LocalDateTime checkInTime;

    @Column(name = "checkOut", nullable = false)
    private LocalDateTime checkOutTime;

    @Column(name = "cost", nullable = false)
    private Integer cost;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "guestID")
//    private Guest guest;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facilityID", referencedColumnName = "facilityID")
    private Room room;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "orderID")
//    private OrderDto orderDto;

//    @OneToOne
//    private HotelFacility room;
//
//    @ManyToOne
//    private Guest guest;
//
//    @ManyToOne
//    private Order order;

    @GetInstance(beanName = "ServiceFacilityDB")
    private transient ServiceFacility serviceRoom;

//    public HotelService(Integer idOrder, TypeOfService typeOfService, Integer idGuest,
//                           Integer idRoom, LocalDate startDate, Integer numberOfDays)
//            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        if(idOrder == null) {
//            log.warn(ORDER_NOT_EXISTS);
//            return;
//        }
//        if (idGuest == null) {
//            log.warn(ERROR_NULL_GUEST);
//            return;
//        }
//        if(idRoom == null){
//            log.warn(ERROR_CREATE_ROOM_RESERVATION_NO_ROOM);
//            return;
//        }
//        if(startDate == null){
//            log.warn(ERROR_CREATE_ROOM_RESERVATION_NO_DATE);
//            return;
//        }
//        if(numberOfDays == null){
//            log.warn(ERROR_CREATE_ROOM_RESERVATION_NO_DAYS);
//            return;
//        }
//        this.idGuest = idGuest;
//        this.typeOfService = typeOfService;
//        this.idRoom = idRoom;
//        this.numberOfDays = numberOfDays;
//        this.checkInTime = LocalDateTime.of(startDate, HOTEL_CHECK_IN_TIME);
//        this.checkOutTime = LocalDateTime.of(startDate.plusDays(numberOfDays), HOTEL_CHECK_OUT_TIME);
//        this.cost = this.serviceRoom.read(idRoom).getPrice() * numberOfDays;
//    }
//
//    public void setIdOrder(Integer idOrder) {
//        if (idOrder != null) {
//            this.idOrder = idOrder;
//        } else {
//            log.warn(ERROR_NULL_ID_ORDER);
//        }
//    }
//
//    public void setTypeOfService(TypeOfService typeOfService) {
//        if (typeOfService != null) {
//            this.typeOfService = typeOfService;
//        } else {
//            log.warn(ERROR_NULL_CATEGORY);
//        }
//    }
//
//    public void setIdGuest(Integer idGuest) {
//        if (idGuest != null) {
//            this.idGuest = idGuest;
//        } else {
//            log.warn(ERROR_NULL_GUEST);
//        }
//    }

    @Override
    public String toString() {
        return "HotelService{" +
                "idService=" + idService +
                ", idOrder=" + idOrder +
                ", typeOfService=" + typeOfService +
                ", idGuest=" + guest +
                ", idRoom=" + idRoom +
                "\nnumberOfDays=" + numberOfDays +
                ", checkInTime=" + checkInTime +
                ", checkOutTime=" + checkOutTime +
                ", cost=" + cost +
                '}';
    }
}
