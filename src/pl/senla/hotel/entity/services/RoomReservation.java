package pl.senla.hotel.entity.services;

import pl.senla.hotel.configuration.AppConfiguration;
import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.service.ServiceRoom;
import pl.senla.hotel.service.ServiceRoomImpl;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static pl.senla.hotel.constant.HotelConstant.*;
import static pl.senla.hotel.constant.HotelServiceConstant.*;
import static pl.senla.hotel.constant.RoomReservationConstant.*;

public class RoomReservation extends HotelService implements Serializable {

    private Integer idRoom;
    private Integer numberOfDays;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private Integer cost;
    private final transient ServiceRoom serviceRoom;

    @Serial
    private static final long serialVersionUID = 10L;

    public RoomReservation() {
        this.serviceRoom = ServiceRoomImpl.getServiceRoom(AppConfiguration.getAppConfiguration());
    }

    public RoomReservation(Integer idService, Integer idOrder, Integer idGuest, Integer idRoom,
                           LocalDate startDate, Integer numberOfDays, Configuration appConfiguration) {
        super(idService, idOrder, TypeOfService.RESTAURANT, idGuest);
        this.serviceRoom = ServiceRoomImpl.getServiceRoom(appConfiguration);
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
        this.idRoom = idRoom;
        this.numberOfDays = numberOfDays;
        this.checkInTime = LocalDateTime.of(startDate, HOTEL_CHECK_IN_TIME);
        this.checkOutTime = LocalDateTime.of(startDate.plusDays(numberOfDays), HOTEL_CHECK_OUT_TIME);
        this.cost = this.serviceRoom.read(idRoom).getPrice() * numberOfDays;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        if (idRoom != null) {
            this.idRoom = idRoom;
        } else {
            System.out.println(ERROR_NULL_FACILITY);
        }
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        if (checkInTime != null) {
            this.checkInTime = checkInTime;
        } else {
            System.out.println(ERROR_NULL_START_TIME);
        }
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(Integer numberOfDays) {
        if (numberOfDays != null) {
            this.numberOfDays = numberOfDays;
        } else {
            System.out.println(ERROR_NULL_DAYS);
        }
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        if (checkOutTime != null) {
            this.checkOutTime = checkOutTime;
        } else {
            System.out.println(ERROR_NULL_END_TIME);
        }
    }

    public void setCost(Integer cost) {
        if (cost != null) {
            this.cost = cost;
        } else {
            System.out.println(ERROR_NULL_COST);
        }
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost() {
        if (cost != null) {
            this.cost = getNumberOfDays() * serviceRoom.read(idRoom).getPrice();
        } else {
            System.out.println(ERROR_NULL_COST);
        }
    }

    @Override
    public String toString() {
        return "\n == > HotelService {" +
                "type of Service=" + super.getTypeOfService() +
                ",idHotelService=" + super.getIdService() +
                ", idGuest=" + super.getIdGuest() +
                ", idRoom=" + idRoom +
                ",\ncheck-in time=" + checkInTime +
                ", numberOfDays=" + numberOfDays +
                ", check-out time=" + checkOutTime +
                ", cost=" + cost +
                '}';
    }
}
