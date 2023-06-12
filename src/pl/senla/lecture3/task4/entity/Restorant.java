package pl.senla.lecture3.task4.entity;

import jdk.jfr.Timestamp;

public class Restorant extends HotelService{

    private int tableNumber;
    private int numberOfGuests;

    public Restorant() {
    }

    public Restorant(int tableNumber, int numberOfGuests) {
        this.tableNumber = tableNumber;
        this.numberOfGuests = numberOfGuests;
    }

    public Restorant(int idHotelService, int tableNumber, int numberOfGuests) {
        super(idHotelService);
        this.tableNumber = tableNumber;
        this.numberOfGuests = numberOfGuests;
    }

    public Restorant(int idHotelService, Timestamp startTime, int priceService, int tableNumber, int numberOfGuests) {
        super(idHotelService, startTime, priceService);
        this.tableNumber = tableNumber;
        this.numberOfGuests = numberOfGuests;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    @Override
    public String toString() {
        return "Restorant{" +
                "tableNumber=" + tableNumber +
                ", numberOfGuests=" + numberOfGuests +
                '}';
    }
}
