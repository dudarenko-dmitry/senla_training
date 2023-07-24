package pl.senla.hotel.entity.services;

import pl.senla.hotel.service.ServiceRoom;
import pl.senla.hotel.service.ServiceRoomImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static pl.senla.hotel.constant.HotelConstant.*;
import static pl.senla.hotel.constant.RoomReservationConstant.*;

public class RoomReservation extends HotelService{

    private int idRoom;
    private int numberOfDays;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private int cost;
    private final ServiceRoom serviceRoom = ServiceRoomImpl.getServiceRoom();

    public RoomReservation() {

    }

    public RoomReservation(int idService, int idOrder, int idGuest, int idRoom, LocalDate startDate, int numberOfDays) {
        super(idService, idOrder, TypeOfService.RESTAURANT.getTypeName(), idGuest);
        if(idRoom < 0){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_ROOM);
            return;
        }
        this.idRoom = idRoom;
        this.numberOfDays = numberOfDays;
        this.checkInTime = LocalDateTime.of(startDate, HOTEL_CHECK_IN_TIME);
        this.checkOutTime = LocalDateTime.of(startDate.plusDays(numberOfDays), HOTEL_CHECK_OUT_TIME);
        this.cost = serviceRoom.read(idRoom).getPrice() * numberOfDays;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost() {
        this.cost = getNumberOfDays() * serviceRoom.read(idRoom).getPrice();
    }

    @Override
    public String toString() {
        return "\n\nRoomReservation {" +
                "idOrder= " + super.getIdOrder() +
                ", type of Service=" + super.getTypeOfService() +
                "\n idRoomReservation=" + super.getIdService() +
                ", idGuest=" + super.getIdGuest() +
                ", idRoom=" + idRoom +
                "\ncheck-in time=" + checkInTime +
                ", numberOfDays=" + numberOfDays +
                ", check-out time=" + checkOutTime +
                ", cost=" + cost +
                '}';
    }
}
