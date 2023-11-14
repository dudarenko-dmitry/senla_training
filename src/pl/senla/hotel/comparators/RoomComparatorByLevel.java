package pl.senla.hotel.comparators;

import pl.senla.hotel.entity.facilities.HotelFacility;

import java.util.Comparator;

public class RoomComparatorByLevel implements Comparator<HotelFacility> {
    @Override
    public int compare(HotelFacility o1, HotelFacility o2) {
        return o1.getRoomLevel().compareTo(o2.getRoomLevel());
    }
}
