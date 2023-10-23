package pl.senla.hotel.storage;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.entity.facilities.Room;

@AppComponent
public class DataStorageRoom extends DataStorage<Room>{

    public DataStorageRoom() {
    }

    @Override
    public String toString() {
        return "Room {" + super.toString();
    }
}
