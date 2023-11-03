package pl.senla.hotel.entity.services;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static pl.senla.hotel.constant.HotelServiceConstant.*;
import static pl.senla.hotel.constant.RestaurantConstant.*;

@Setter
@Getter
public class Restaurant extends HotelService{

    private Integer idTable;
    private Integer numberOfGuests;
    private LocalDateTime startTime;
    private Integer price;

    public Restaurant(Integer idService, Integer idOrder, Integer idGuest, Integer idTable, Integer numberOfGuests,
                      LocalDateTime startTime, Integer price) {
        super(idService, idOrder, TypeOfService.RESTAURANT, idGuest);
        if(idTable == null){
            System.out.println(ERROR_NULL_FACILITY);
            return;
        }
        if (numberOfGuests == null) {
            System.out.println(ERROR_CREATE_RESTAURANT_RESERVATION_NO_CLIENT);
            return;
        }
        if (startTime == null) {
            System.out.println(ERROR_NULL_START_TIME);
            return;
        }
        if (price == null) {
            System.out.println(ERROR_NULL_PRICE);
            return;
        }
        this.idTable = idTable;
        this.numberOfGuests = numberOfGuests;
        this.startTime = startTime;
        this.price = price;
    }

    public Integer getIdTable() {
        return idTable;
    }

    public void setIdTable(Integer idTable) {
        if (idTable != null) {
            this.idTable = idTable;
        } else {
            System.out.println(ERROR_NULL_FACILITY);
        }
    }

    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(Integer numberOfGuests) {
        if (idTable != null) {
            this.numberOfGuests = numberOfGuests;
        } else {
            System.out.println(ERROR_NULL_NUMBER_OF_GUEST);
        }
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        if (idTable != null) {
            this.startTime = startTime;
        } else {
            System.out.println(ERROR_NULL_START_TIME);
        }
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        if (idTable != null) {
            this.price = price;
        } else {
            System.out.println(ERROR_NULL_PRICE);
        }
    }

    @Override
    public String toString() {
        return "\nRestaurant {" +
                "idOrder= " + super.getIdOrder() +
                ", typeOfService=" + super.getTypeOfService() +
                "\n idRestaurant=" + super.getIdService() +
                ", idGuest=" + super.getIdGuest() + "," +
                ", idTable=" + idTable +
                ", numberOfGuests=" + numberOfGuests +
                "\nStartTime=" + startTime +
                ", price=" + price +
                '}';
    }
}
