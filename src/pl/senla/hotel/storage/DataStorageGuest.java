package pl.senla.hotel.storage;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.entity.Guest;

@AppComponent
public class DataStorageGuest extends DataStorage<Guest>{

    public DataStorageGuest(){}

    @Override
    public String toString() {
        return "Guest {" + super.toString();
    }
}
