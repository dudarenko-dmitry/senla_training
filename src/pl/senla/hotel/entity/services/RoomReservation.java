package pl.senla.hotel.entity.services;

import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.facilities.Room;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static pl.senla.hotel.constant.HotelConstant.*;
import static pl.senla.hotel.constant.RoomReservationConstant.*;

public class RoomReservation extends HotelService{

    private int idRoomReservation = -1;
    private Room room;
    private int numberOfDays;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private int cost;

    public RoomReservation(int idRoomReservation) {
        this.idRoomReservation = idRoomReservation;
    }

    public RoomReservation(Guest guest, Room room, LocalDate startDate, int numberOfDays) {
        super("RoomReservation", guest);
        if(room == null){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_ROOM);
            return;
        }
        this.room = room;
        this.numberOfDays = numberOfDays;
        this.checkInTime = LocalDateTime.of(startDate, HOTEL_CHECK_IN_TIME);
        this.checkOutTime = LocalDateTime.of(startDate.plusDays(numberOfDays), HOTEL_CHECK_OUT_TIME);
        this.cost = room.getPrice() * numberOfDays;
    }

    public int getIdRoomReservation() {
        return idRoomReservation;
    }

    public void setIdRoomReservation(int idRoomReservation) {
        this.idRoomReservation = idRoomReservation;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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
        this.cost = numberOfDays * room.getPrice();
    }

    @Override
    public String toString() {
        return "\n\nRoomReservation {" +
                "Type of Service=" + super.getTypeOfService() +
                ", idRoomReservation=" + idRoomReservation + "," +
                super.getGuest().toString() + "," +
                room + "," +
                "\ncheck-in time=" + checkInTime +
                ", numberOfDays=" + numberOfDays +
                ", check-out time=" + checkOutTime +
                ", cost=" + cost +
                '}';
    }
}
