package pl.senla.hotel.comparators;

import pl.senla.hotel.entity.GuideTour;
import pl.senla.hotel.entity.HotelService;
import pl.senla.hotel.entity.Restaurant;
import pl.senla.hotel.entity.RoomReservation;

import java.util.Comparator;

public class HotelServicesComparatorByPrice implements Comparator<HotelService> {

    @Override
    public int compare(HotelService o1, HotelService o2) {
        switch(o1.getTypeOfService()){
            case "RoomReservation":
                return compareRoomReservation((RoomReservation) o1, (RoomReservation) o2);
            case "Restaurant":
                return compareRestaurant((Restaurant) o1, (Restaurant) o2);
            case "GuideTour":
                return compareGuideTour((GuideTour) o1, (GuideTour) o2);
            default:
                System.out.println("ERROR IN SERVICE TYPE.");
        }
        return 0;
    }

    private int compareRoomReservation(RoomReservation o1, RoomReservation o2){
        return o1.getRoom().getRoomPrice() - o2.getRoom().getRoomPrice();
    }

    private int compareRestaurant(Restaurant o1, Restaurant o2){
        return o1.getPrice() - o2.getPrice();
    }

    private int compareGuideTour(GuideTour o1, GuideTour o2){
        return o1.getPrice() - o2.getPrice();
    }
}
