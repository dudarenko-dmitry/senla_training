package pl.senla.hotel.comparators;

import pl.senla.hotel.entity.services.Transfer;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.Restaurant;
import pl.senla.hotel.entity.services.RoomReservation;

import java.util.Comparator;

import static pl.senla.hotel.constant.HotelServiceConstant.ERROR_IN_SERVICE_TYPE;

public class HotelServicesComparatorByDate implements Comparator<HotelService> {

    @Override
    public int compare(HotelService o1, HotelService o2) {
        return switch (o1.getTypeOfService()) {
            case ROOM_RESERVATION -> compareRoomReservation((RoomReservation) o1, (RoomReservation) o2);
            case RESTAURANT -> compareRestaurant((Restaurant) o1, (Restaurant) o2);
            case TRANSFER -> compareTransfer((Transfer) o1, (Transfer) o2);
            default -> {
                System.out.println(ERROR_IN_SERVICE_TYPE);
                yield 0;
            }
        };
    }

    private int compareTransfer(Transfer o1, Transfer o2) {
        if(o1.getStartDateTime().isBefore(o2.getStartDateTime())){
            return -1;
        } else if(o1.getStartDateTime().isAfter(o2.getStartDateTime())){
            return 1;
        } else {
            return 0;
        }
    }

    private int compareRestaurant(Restaurant o1, Restaurant o2) {
        if(o1.getStartTime().isBefore(o2.getStartTime())){
            return -1;
        } else if(o1.getStartTime().isAfter(o2.getStartTime())){
            return 1;
        } else {
            return 0;
        }
    }

    private int compareRoomReservation(RoomReservation o1, RoomReservation o2) {
        if(o1.getCheckInTime().isBefore(o2.getCheckInTime())){
            return -1;
        } else if(o1.getCheckInTime().isAfter(o2.getCheckInTime())){
            return 1;
        } else {
            return 0;
        }
    }
}
