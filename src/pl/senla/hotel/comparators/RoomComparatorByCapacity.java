package pl.senla.hotel.comparators;

import pl.senla.hotel.entity.facilities.Room;

import java.util.Comparator;

public class RoomComparatorByCapacity implements Comparator<Room> {
    @Override
    public int compare(Room o1, Room o2) {
        return o1.getCapacity() - o2.getCapacity();
    }
}
