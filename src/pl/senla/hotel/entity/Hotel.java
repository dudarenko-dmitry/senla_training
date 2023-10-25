package pl.senla.hotel.entity;

import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.services.HotelService;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class Hotel implements Serializable {

    @Serial
    private static final long serialVersionUID = 100L;

    private List<HotelFacility> hotelFacilityList;
    private List<Guest> guestList;
    private List<HotelService> hotelServiceList;
    private List<Order> orderList;

    public Hotel() {
    }

    public List<HotelFacility> getHotelFacilityList() {
        return hotelFacilityList;
    }

    public List<Guest> getGuestList() {
        return guestList;
    }

    public List<HotelService> getHotelServiceList() {
        return hotelServiceList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setHotelFacilityList(List<HotelFacility> hotelFacilityList) {
        this.hotelFacilityList = hotelFacilityList;
    }

    public void setGuestList(List<Guest> guestList) {
        this.guestList = guestList;
    }

    public void setHotelServiceList(List<HotelService> hotelServiceList) {
        this.hotelServiceList = hotelServiceList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "\nhotelFacilityList=" + hotelFacilityList +
                ", \nguestList=" + guestList +
                ", \nhotelServiceList=" + hotelServiceList +
                ", \norderList=" + orderList +
                '}';
    }

}
