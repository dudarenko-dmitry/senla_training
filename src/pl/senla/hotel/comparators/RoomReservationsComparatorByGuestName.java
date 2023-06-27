package pl.senla.hotel.comparators;

import pl.senla.hotel.entity.services.RoomReservation;

import java.util.Comparator;

public class RoomReservationsComparatorByGuestName implements Comparator<RoomReservation> {
    @Override
    public int compare(RoomReservation o1, RoomReservation o2) {
        return o1.getGuest().getName().compareTo(o2.getGuest().getName());
    }
}
