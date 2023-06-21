package pl.senla.hotel.entity;

import java.util.Comparator;

public class RoomReservationsComparatorByCheckOut implements Comparator<RoomReservation> {
    @Override
    public int compare(RoomReservation o1, RoomReservation o2) {
        if(o1.getCheckOutTime().isBefore(o2.getCheckOutTime())){
            return -1;
        } else if(o1.getCheckOutTime().isAfter(o2.getCheckOutTime())){
            return 1;
        } else{
            return 0;
        }
    }
}
