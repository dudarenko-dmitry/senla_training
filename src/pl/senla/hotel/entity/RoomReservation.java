package pl.senla.hotel.entity;

import java.time.LocalDate;

public class RoomReservation extends HotelService{

    private int idRoomReservation;
    private Room room;
    private int numberOfDays;
    private LocalDate checkOutDate;
    private int cost;

    public RoomReservation(int idRoomReservation) {
        this.idRoomReservation = idRoomReservation;
    }

    public RoomReservation(int idRoomReservation, Guest guest, Room room, LocalDate startDate, int numberOfDays) {
        super(startDate, guest);
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
        this.checkOutDate = startDate.plusDays(numberOfDays);
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

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
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
                "idRoomReservation=" + idRoomReservation + "," +
                super.getClient().toString() + "," +
                room + "," +
                "\nStartDate=" + super.getStartDate().toString() +
                ", numberOfDays=" + numberOfDays +
                ", checkOutDate=" + checkOutDate +
                ", cost=" + cost +
                '}';
    }
}
