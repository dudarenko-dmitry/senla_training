package pl.senla.hotel.comparators;

import pl.senla.hotel.entity.services.RoomReservation;

import java.util.Comparator;

public class RoomReservationsComparatorByGuestName implements Comparator<RoomReservation> {
    @Override
    public int compare(RoomReservation o1, RoomReservation o2) {
        int idGuest1 = o1.getIdGuest();
        int idGuest2 = o2.getIdGuest();
        String name1 = "";
        String name2 = "";
        return name1.compareTo(name2); !!!

//        return o1.getIdGuest().getName().compareTo(o2.getIdGuest().getName());
    }
}
