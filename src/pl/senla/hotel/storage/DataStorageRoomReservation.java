package pl.senla.hotel.storage;

import pl.senla.hotel.entity.RoomReservation;

public class DataStorageRoomReservation extends DataStorage<RoomReservation>{

    @Override
    public String toString() {
        return "Room's reservations {" + super.toString();
    }
}