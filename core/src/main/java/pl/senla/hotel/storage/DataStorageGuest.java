package pl.senla.hotel.storage;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.entity.Guest;

@AppComponent
public class DataStorageGuest extends DataStorage<Guest>{

    @Override
    public String toString() {
        return "Guest {" + super.toString();
    }
}
