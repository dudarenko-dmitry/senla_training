package pl.senla.hotel.comparators;

import pl.senla.hotel.entity.FreeRoom;

import java.util.Comparator;

public class FreeRoomComparatorByPrice implements Comparator<FreeRoom> {
    @Override
    public int compare(FreeRoom o1, FreeRoom o2) {
        return o1.getRoom().getRoomPrice() - o2.getRoom().getRoomPrice();
    }
}
