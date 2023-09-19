package pl.senla.hotel.storage;

import pl.senla.hotel.entity.facilities.Room;

public class DataStorageTable extends DataStorage<Room>{

    private static DataStorageTable dataStorageTable;

    private DataStorageTable(){}

    public static DataStorageTable getDataStorageTable(){
        if(dataStorageTable == null) {
            dataStorageTable = new DataStorageTable();
        }
        return dataStorageTable;
    }

    @Override
    public String toString() {
        return "Table {" + super.toString();
    }
}