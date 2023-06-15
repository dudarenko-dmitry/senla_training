package pl.senla.lecture3.task4.storage;

import pl.senla.lecture3.task4.entity.RoomReservation;

public class DataStorageRoomReservation extends DataStorage<RoomReservation>{

    @Override
    public String toString() {
        return "Room's reservations {" + super.toString();
    }
}
