package pl.senla.hotel.comparators;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.entity.services.HotelService;

import java.util.Comparator;

@Slf4j
public class HotelServicesComparatorByDate implements Comparator<HotelService> {

    @Override
    public int compare(HotelService o1, HotelService o2) {
        return compareRoomReservation(o1, o2);
    }

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
