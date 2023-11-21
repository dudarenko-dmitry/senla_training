package pl.senla.hotel.comparators;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.entity.services.HotelService;

import java.util.Comparator;

import static pl.senla.hotel.constant.HotelServiceConstant.ERROR_IN_SERVICE_TYPE;

@Slf4j
public class HotelServicesComparatorByDate implements Comparator<HotelService> {

    @Override
    public int compare(HotelService o1, HotelService o2) {
        return switch (o1.getTypeOfService()) {
            case ROOM_RESERVATION -> compareRoomReservation(o1, o2);
//            case RESTAURANT -> compareRestaurant((Restaurant) o1, (Restaurant) o2);
//            case TRANSFER -> compareTransfer((Transfer) o1, (Transfer) o2);
            default -> {
                log.warn(ERROR_IN_SERVICE_TYPE);
                yield 0;
            }
        };
    }

//    private int compareTransfer(Transfer o1, Transfer o2) {
//        if(o1.getStartDateTime().isBefore(o2.getStartDateTime())){
//            return -1;
//        } else if(o1.getStartDateTime().isAfter(o2.getStartDateTime())){
//            return 1;
//        } else {
//            return 0;
//        }
//    }

//    private int compareRestaurant(Restaurant o1, Restaurant o2) {
//        if(o1.getStartTime().isBefore(o2.getStartTime())){
//            return -1;
//        } else if(o1.getStartTime().isAfter(o2.getStartTime())){
//            return 1;
//        } else {
//            return 0;
//        }
//    }

    private int compareRoomReservation(HotelService o1, HotelService o2) {
        if(o1.getCheckInTime().isBefore(o2.getCheckInTime())){
            return -1;
        } else if(o1.getCheckInTime().isAfter(o2.getCheckInTime())){
            return 1;
        } else {
            return 0;
        }
    }
}
