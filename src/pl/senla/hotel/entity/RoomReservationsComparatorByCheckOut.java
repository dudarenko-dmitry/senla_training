package pl.senla.hotel.entity;

import java.util.Comparator;

public class RoomReservationsComparatorByCheckOut implements Comparator<RoomReservation> {
    @Override
    public int compare(RoomReservation o1, RoomReservation o2) {
        if(o1.getCheckOutDate().isBefore(o2.getCheckOutDate())){
            return -1;
        } else if(o1.getCheckOutDate().isAfter(o2.getCheckOutDate())){
            return 1;
        } else{
            return 0;
        }
    }
}
