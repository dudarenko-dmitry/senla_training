package pl.senla.hotel.storage;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.entity.facilities.Room;

@AppComponent
public class DataStorageRoom extends DataStorage<Room>{

    private static DataStorageRoom dataStorageRoom;

    private DataStorageRoom() {
    }

    public static DataStorageRoom getSingletonInstance(){
        if (dataStorageRoom == null){
            dataStorageRoom = new DataStorageRoom();
        }
        return dataStorageRoom;
    }

    @Override
    public String toString() {
        return "Room {" + super.toString();
    }
}
