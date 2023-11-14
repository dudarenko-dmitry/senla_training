package pl.senla.hotel.entity.services;

import lombok.Getter;
import lombok.Setter;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.service.ServiceFacility;

import java.io.Serial;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static pl.senla.hotel.constant.HotelConstant.*;
import static pl.senla.hotel.constant.HotelServiceConstant.*;
import static pl.senla.hotel.constant.OrderConstant.ORDER_NOT_EXISTS;
import static pl.senla.hotel.constant.RoomReservationConstant.*;

@Setter
@Getter
public class HotelService implements Serializable {

    @Serial
    private static final long serialVersionUID = 20L;

    private Integer idService;
    private Integer idOrder;
    private TypeOfService typeOfService;
    private Integer idGuest;
    private Integer idRoom;
    private Integer numberOfDays;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private Integer cost;
    @GetInstance(beanName = "ServiceFacilityDB")
    private transient ServiceFacility serviceRoom;

    public HotelService() {
    }

    public HotelService(Integer idService, Integer idOrder, TypeOfService typeOfService, Integer idGuest,
                           Integer idRoom, LocalDate startDate, Integer numberOfDays)
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if(idOrder == null) {
            System.out.println(ORDER_NOT_EXISTS);
            return;
        }
        if (idGuest == null) {
            System.out.println(ERROR_NULL_GUEST);
            return;
        }
        if(idRoom == null){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_ROOM);
            return;
        }
        if(startDate == null){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_DATE);
            return;
        }
        if(numberOfDays == null){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_DAYS);
            return;
        }
        this.idService = idService;
        this.idGuest = idGuest;
        this.typeOfService = typeOfService;
        this.idRoom = idRoom;
        this.numberOfDays = numberOfDays;
        this.checkInTime = LocalDateTime.of(startDate, HOTEL_CHECK_IN_TIME);
        this.checkOutTime = LocalDateTime.of(startDate.plusDays(numberOfDays), HOTEL_CHECK_OUT_TIME);
        this.cost = this.serviceRoom.read(idRoom).getPrice() * numberOfDays;
    }

    public void setIdOrder(Integer idOrder) {
        if (idOrder != null) {
            this.idOrder = idOrder;
        } else {
            System.out.println(ERROR_NULL_ID_ORDER);
        }
    }

    public void setTypeOfService(TypeOfService typeOfService) {
        if (typeOfService != null) {
            this.typeOfService = typeOfService;
        } else {
            System.out.println(ERROR_NULL_CATEGORY);
        }
    }

    public void setIdGuest(Integer idGuest) {
        if (idGuest != null) {
            this.idGuest = idGuest;
        } else {
            System.out.println(ERROR_NULL_GUEST);
        }
    }

    @Override
    public String toString() {
        return "{typeOfService='" + typeOfService +
                ", idGuest=" + idGuest +
                ", idRoom=" + idRoom +
                ",\ncheck-in time=" + checkInTime +
                ", numberOfDays=" + numberOfDays +
                ", check-out time=" + checkOutTime +
                ", cost=" + cost +
                '}';
    }
}
