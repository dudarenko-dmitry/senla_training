package pl.senla.hotel.storage;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.entity.services.RoomReservation;

@AppComponent
public class DataStorageRoomReservation extends DataStorage<RoomReservation>{

    public DataStorageRoomReservation(){}

    @Override
    public String toString() {
        return "Room's reservations {" + super.toString();
    }
}
