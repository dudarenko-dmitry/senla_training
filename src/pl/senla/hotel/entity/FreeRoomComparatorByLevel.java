package pl.senla.hotel.entity;

import java.util.Comparator;

public class FreeRoomComparatorByLevel implements Comparator<FreeRoom> {

    @Override
    public int compare(FreeRoom o1, FreeRoom o2) {
        return o1.getRoom().getRoomLevel().compareTo(o2.getRoom().getRoomLevel());
    }
}
