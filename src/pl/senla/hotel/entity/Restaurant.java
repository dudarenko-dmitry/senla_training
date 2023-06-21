package pl.senla.hotel.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import static pl.senla.hotel.constant.RestaurantConstant.*;

public class Restaurant extends HotelService{

    private int idRestaurant;
    private int tableNumber;
    private int numberOfGuests;
    private LocalTime startTime;
    private int price;



    public Restaurant(int idRestaurant, Guest guest, int tableNumber, int numberOfGuests,
                      LocalDate startDate, LocalTime startTime, int price) {
        super(startDate, guest);
        if(guest == null){
            System.out.println(ERROR_CREATE_RESTAURANT_RESERVATION_NO_CLIENT);
            return;
        }
        if(tableNumber == -1){// check if the ROOM exists // CREATE Entity TABLE and change IF !!!!!!!!!!!!!!!!!!!!!!!!
            System.out.println(ERROR_CREATE_RESTAURANT_RESERVATION_NO_TABLE);
            return;
//        } else if(!table.TableStatus.FREE.getStatus()).equals(TableStatus.FREE.getStatus())){// check if the TABLE is FREE
//            System.out.println(ERROR_RESTAURANT_NOT_AVAILABLE);
//            return;
        }
        this.idRestaurant = idRestaurant;
        this.tableNumber = tableNumber;
        this.numberOfGuests = numberOfGuests;
        this.startTime = startTime;
        this.price = price;
    }

    public int getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(int idRestaurant) {
        this.idRestaurant = idRestaurant;
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
        return "\nRestaurant {" +
                "idRestaurant=" + idRestaurant +
                super.getGuest().toString() + "," +
                ", tableNumber=" + tableNumber +
                ", numberOfGuests=" + numberOfGuests +
                "\nStartDate=" + super.getStartDate().toString() +
                ", startTime=" + startTime +
                ", price=" + price +
                '}';
    }
}
