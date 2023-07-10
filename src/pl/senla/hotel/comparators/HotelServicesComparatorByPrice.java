package pl.senla.hotel.comparators;

import pl.senla.hotel.entity.services.Transfer;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.Restaurant;
import pl.senla.hotel.entity.services.RoomReservation;

import java.util.Comparator;

import static pl.senla.hotel.constant.HotelServieConstant.ERROR_IN_SERVICE_TYPE;

public class HotelServicesComparatorByPrice implements Comparator<HotelService> {

    @Override
    public int compare(HotelService o1, HotelService o2) {
        switch(o1.getTypeOfService()){
            case "RoomReservation" -> {return compareRoomReservation((RoomReservation) o1, (RoomReservation) o2);}
            case "Restaurant" -> {return compareRestaurant((Restaurant) o1, (Restaurant) o2);}
            case "Transfer" -> {return compareTransfer((Transfer) o1, (Transfer) o2);}
            default -> {System.out.println(ERROR_IN_SERVICE_TYPE);
                return 0;}
        }
    }

    private int compareRoomReservation(RoomReservation o1, RoomReservation o2){
        return o1.getIdRoom().getPrice() - o2.getIdRoom().getPrice();
    }

    private int compareRestaurant(Restaurant o1, Restaurant o2){
        return o1.getPrice() - o2.getPrice();
    }

    private int compareTransfer(Transfer o1, Transfer o2){
        return o1.getPrice() - o2.getPrice();
    }
}
