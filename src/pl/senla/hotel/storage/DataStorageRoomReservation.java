package pl.senla.hotel.storage;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.entity.services.RoomReservation;

@AppComponent
public class DataStorageRoomReservation extends DataStorage<RoomReservation>{

    private static DataStorageRoomReservation dataStorageRoomReservation;

    private DataStorageRoomReservation(){}

    public static DataStorageRoomReservation getSingletonInstance(){
        if(dataStorageRoomReservation == null) {
            dataStorageRoomReservation = new DataStorageRoomReservation();
        }
        return dataStorageRoomReservation;
    }

    @Override
    public String toString() {
        return "Room's reservations {" + super.toString();
    }
}
