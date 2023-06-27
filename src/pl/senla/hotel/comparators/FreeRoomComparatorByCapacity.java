package pl.senla.hotel.comparators;

import pl.senla.hotel.entity.services.FreeRoom;

import java.util.Comparator;

public class FreeRoomComparatorByCapacity implements Comparator<FreeRoom> {
    @Override
    public int compare(FreeRoom o1, FreeRoom o2) {
        return o1.getRoom().getCapacity() - o2.getRoom().getCapacity();
    }
}
