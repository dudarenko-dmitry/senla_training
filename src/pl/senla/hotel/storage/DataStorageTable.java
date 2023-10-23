package pl.senla.hotel.storage;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.entity.facilities.Room;

@AppComponent
public class DataStorageTable extends DataStorage<Room>{

    public DataStorageTable(){}

    @Override
    public String toString() {
        return "Table {" + super.toString();
    }
}
