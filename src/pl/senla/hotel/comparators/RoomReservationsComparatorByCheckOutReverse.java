package pl.senla.hotel.comparators;

import pl.senla.hotel.entity.services.HotelService;

import java.util.Comparator;

public class RoomReservationsComparatorByCheckOutReverse implements Comparator<HotelService> {
    @Override
    public int compare(HotelService o1, HotelService o2) {
        if(o1.getCheckOutTime().isBefore(o2.getCheckOutTime())){
            return 1;
        } else if(o1.getCheckOutTime().isAfter(o2.getCheckOutTime())){
            return -1;
        } else{
            return 0;
        }
    }
}
