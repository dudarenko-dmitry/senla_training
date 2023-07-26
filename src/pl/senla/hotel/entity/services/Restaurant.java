package pl.senla.hotel.entity.services;

import java.time.LocalDateTime;

import static pl.senla.hotel.constant.RestaurantConstant.*;

public class Restaurant extends HotelService{

    private int tableNumber;
    private int numberOfGuests;
    private LocalDateTime startTime;
    private int price;

    public Restaurant(int idService, int idOrder, int idGuest, int tableNumber, int numberOfGuests,
                      LocalDateTime startTime, int price) {
        super(idService, idOrder, TypeOfService.RESTAURANT.getTypeName(), idGuest);
        if(tableNumber < 0){// CREATE Entity TABLE and change IF !!!!!!!!!!!!!!!!!!!!!!!!
            System.out.println(ERROR_CREATE_RESTAURANT_RESERVATION_NO_TABLE);
            return;
        }
        this.tableNumber = tableNumber;
        this.numberOfGuests = numberOfGuests;
        this.startTime = startTime;
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
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
                "idOrder= " + super.getIdOrder() +
                ", typeOfService=" + super.getTypeOfService() +
                "\n idRestaurant=" + super.getIdService() +
                ", idGuest=" + super.getIdGuest() + "," +
                ", tableNumber=" + tableNumber +
                ", numberOfGuests=" + numberOfGuests +
                "\nStartTime=" + startTime +
                ", price=" + price +
                '}';
    }
}
