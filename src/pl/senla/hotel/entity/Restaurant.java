package pl.senla.hotel.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Restaurant extends HotelService{

    LocalTime startTime;
    private int tableNumber;
    private int numberOfGuests;
    private int price;

    public Restaurant(LocalTime startTime, int tableNumber, int numberOfGuests, int price) {
        this.startTime = startTime;
        this.tableNumber = tableNumber;
        this.numberOfGuests = numberOfGuests;
        this.price = price;
    }

    public Restaurant(int idHotelService, LocalTime startTime, int tableNumber, int numberOfGuests, int price) {
        super(idHotelService);
        this.startTime = startTime;
        this.tableNumber = tableNumber;
        this.numberOfGuests = numberOfGuests;
        this.price = price;
    }

    public Restaurant(int idHotelService, LocalDate startDate, LocalTime startTime, int tableNumber, int numberOfGuests, int price) {
        super(idHotelService, startDate);
        this.startTime = startTime;
        this.tableNumber = tableNumber;
        this.numberOfGuests = numberOfGuests;
        this.price = price;
    }

    public Restaurant(int idHotelService, LocalDate startDate, Guest guest, LocalTime startTime, int tableNumber, int numberOfGuests, int price) {
        super(idHotelService, startDate, guest);
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
