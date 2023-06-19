package pl.senla.hotel.entity;

import java.util.Comparator;

public class RoomComparatorByPrice implements Comparator<Room> {
    @Override
    public int compare(Room o1, Room o2) {
        return o1.getRoomPrice() - o2.getRoomPrice();
    }
}
