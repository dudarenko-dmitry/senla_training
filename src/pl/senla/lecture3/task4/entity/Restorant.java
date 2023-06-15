package pl.senla.lecture3.task4.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Restorant extends HotelService{

    LocalTime startTime;
    private int tableNumber;
    private int numberOfGuests;
    private int price;

    public Restorant(LocalTime startTime, int tableNumber, int numberOfGuests, int price) {
        this.startTime = startTime;
        this.tableNumber = tableNumber;
        this.numberOfGuests = numberOfGuests;
        this.price = price;
    }

    public Restorant(int idHotelService, LocalTime startTime, int tableNumber, int numberOfGuests, int price) {
        super(idHotelService);
        this.startTime = startTime;
        this.tableNumber = tableNumber;
        this.numberOfGuests = numberOfGuests;
        this.price = price;
    }

    public Restorant(int idHotelService, LocalDate startDate, LocalTime startTime, int tableNumber, int numberOfGuests, int price) {
        super(idHotelService, startDate);
        this.startTime = startTime;
        this.tableNumber = tableNumber;
        this.numberOfGuests = numberOfGuests;
        this.price = price;
    }

    public Restorant(int idHotelService, LocalDate startDate, Client client, LocalTime startTime, int tableNumber, int numberOfGuests, int price) {
        super(idHotelService, startDate, client);
        this.startTime = startTime;
        this.tableNumber = tableNumber;
        this.numberOfGuests = numberOfGuests;
        this.price = price;
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

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Restorant{" + super.toString() +
                "tableNumber=" + tableNumber +
                ", numberOfGuests=" + numberOfGuests +
                ", price=" + price + '\'' +
                '}';
    }
}
