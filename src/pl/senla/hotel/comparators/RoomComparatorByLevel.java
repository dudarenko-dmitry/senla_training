package pl.senla.hotel.comparators;

import pl.senla.hotel.entity.Room;

import java.util.Comparator;

public class RoomComparatorByLevel implements Comparator<Room> {
    @Override
    public int compare(Room o1, Room o2) {
        return o1.getRoomLevel().compareTo(o2.getRoomLevel());
    }
}
