package pl.senla.hotel.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static pl.senla.hotel.constant.HotelConstant.*;

public class RoomReservation extends HotelService{

    private final int idRoomReservation;
    private Room room;
    private int numberOfDays;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private int cost;

    public RoomReservation(int idRoomReservation) {
        this.idRoomReservation = idRoomReservation;
    }

    public RoomReservation(int idRoomReservation, Guest guest, Room room, LocalDate startDate, int numberOfDays) {
        super("RoomReservation", guest);
//        if(guest == null){
//            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT);
//            return;
//        }
        this.idRoomReservation = idRoomReservation;
//        if(room == null){// check if the ROOM exists
//            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_ROOM);
//            return;
//        } else if(!room.getRoomStatus().equals(RoomStatus.FREE.getStatus())){// check if the ROOM is FREE
//            System.out.println(ERROR_ROOM_NOT_AVAILABLE);
//            return;
//        }
        this.room = room;
        this.numberOfDays = numberOfDays;
        this.checkInTime = LocalDateTime.of(startDate, HOTEL_CHECK_IN_TIME);
        this.checkOutTime = LocalDateTime.of(startDate.plusDays(numberOfDays), HOTEL_CHECK_OUT_TIME);
        this.cost = room.getRoomPrice() * numberOfDays;
        // add logic for DELETING Free Room
    }

    public int getIdRoomReservation() {
        return idRoomReservation;
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
        this.cost = numberOfDays * room.getRoomPrice();
    }

    @Override
    public String toString() {
        return "\nRoomReservation {" +
                "typeOfService=" + super.getTypeOfService() +
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
