package pl.senla.lecture3.task4.entity;

import java.time.LocalDate;

public class RoomReservation extends HotelService{

    private Room room;
    private int numberOfDays;
    private int cost;

    public RoomReservation(int idHotelService) {
        super(idHotelService);
    }

    public RoomReservation(int idHotelService, LocalDate startDate, Client client, Room room, int numberOfDays) {
        super(idHotelService, startDate, client);
        room.setRoomStatus(RoomStatus.RESERVED.getStatus());
        this.room = room;
        // check if the ROOM exists in DB and is FREE
        this.numberOfDays = numberOfDays;
        this.cost = room.getRoomPrice() * numberOfDays;
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

    @Override
    public String toString() {
        return "RoomReservation{" +
                super.toString() +
                room +
                ",\nnumberOfDays=" + numberOfDays +
                ", cost=" + cost +
                '}';
    }
}
