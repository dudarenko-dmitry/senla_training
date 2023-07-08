package pl.senla.hotel.storage;

import pl.senla.hotel.entity.services.FreeRoom;

public class DataStorageFreeRoom extends DataStorage<FreeRoom>{

    private static DataStorageFreeRoom dataStorageFreeRoom;

    private DataStorageFreeRoom(){}

    public static DataStorageFreeRoom getDataStorageFreeRoom(){
        if(dataStorageFreeRoom == null) {
            dataStorageFreeRoom = new DataStorageFreeRoom();
            System.out.println("DataStorage for FreeRoom was created.");
        }
        return dataStorageFreeRoom;
    }

    @Override
    public String toString() {
        return "FreeRooms {" + super.toString();
    }
}
