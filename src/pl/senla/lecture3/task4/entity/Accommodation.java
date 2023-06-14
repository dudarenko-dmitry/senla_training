package pl.senla.lecture3.task4.entity;

import jdk.jfr.Timestamp;

public class Accommodation extends HotelService{

    private Room room;
    private int numberOfDays;

    public Accommodation() {
    }

    public Accommodation(Room room) {
        this.room = room;
    }

    public Accommodation(int idHotelService, Room room) {
        super(idHotelService);
        this.room = room;
    }

    public Accommodation(int idHotelService, Timestamp startTime, int priceService, Room room) {
        super(idHotelService, startTime, priceService);
        this.room = room;
    }

    public Accommodation(Room room, int numberOfDays) {
        super();
        this.room = room;
        this.numberOfDays = numberOfDays;
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
}
