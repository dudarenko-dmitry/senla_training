package pl.senla.hotel.comparators;

import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.facilities.Room;

import java.util.Comparator;

public class RoomComparatorByLevel implements Comparator<HotelFacility> {
    @Override
    public int compare(HotelFacility o1, HotelFacility o2) {
        Room room1 = (Room) o1;
        Room room2 = (Room) o2;
        return room1.getRoomLevel().compareTo(room2.getRoomLevel());
    }
}
