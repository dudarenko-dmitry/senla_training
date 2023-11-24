package pl.senla.hotel.entity;

import lombok.Getter;
import lombok.Setter;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.services.HotelService;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class Hotel implements Serializable {

    @Serial
    private static final long serialVersionUID = 100L;

    private List<HotelFacility> hotelFacilityList;
    private List<Guest> guestList;
    private List<HotelService> hotelServiceList;
    private List<Order> orderList;

    public Hotel() {
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
