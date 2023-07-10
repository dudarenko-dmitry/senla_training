package pl.senla.hotel.entity.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static pl.senla.hotel.constant.HotelConstant.*;
import static pl.senla.hotel.constant.RoomReservationConstant.*;

public class RoomReservation extends HotelService{

    private int idRoomReservation = -1;
    private int idRoom;
    private int numberOfDays;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private int cost;

    public RoomReservation(int idGuest, int idRoom, LocalDate startDate, int numberOfDays) {
        super(TypeOfService.ROOM_RESERVATION.getTypeName(), idGuest);
        if(idRoom == -1){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_ROOM);
            return;
        }
        this.idRoom = idRoom;
        this.numberOfDays = numberOfDays;
        this.checkInTime = LocalDateTime.of(startDate, HOTEL_CHECK_IN_TIME);
        this.checkOutTime = LocalDateTime.of(startDate.plusDays(numberOfDays), HOTEL_CHECK_OUT_TIME);
//        this.cost = idRoom.getPrice() * numberOfDays; // REFACTOR !!!!!!!!!!!!!!!!!!!!!!!!!!
        this.cost = 1000000000;
    }

    public RoomReservation() {

    }

    public int getIdRoomReservation() {
        return idRoomReservation;
    }

    public void setIdRoomReservation(int idRoomReservation) {
        this.idRoomReservation = idRoomReservation;
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
//        this.cost = numberOfDays * idRoom.getPrice();
        this.cost = 100000000;
    }

    @Override
    public String toString() {
        return "\n\nRoomReservation {" +
                "Type of Service=" + super.getTypeOfService() +
                ", idRoomReservation=" + idRoomReservation +
                ", idGuest=" + super.getIdGuest() +
                ", idRoom=" + idRoom +
                "\ncheck-in time=" + checkInTime +
                ", numberOfDays=" + numberOfDays +
                ", check-out time=" + checkOutTime +
                ", cost=" + cost +
                '}';
    }
}
