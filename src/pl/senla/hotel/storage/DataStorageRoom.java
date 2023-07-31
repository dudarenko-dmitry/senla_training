package pl.senla.hotel.storage;

import pl.senla.hotel.entity.facilities.Room;

public class DataStorageRoom extends DataStorage<Room>{

    private static DataStorageRoom dataStorageRoom;

    private DataStorageRoom() {
    }

    public static DataStorageRoom getDataStorageRoom(){
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
