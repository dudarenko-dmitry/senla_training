package pl.senla.hotel.storage;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.entity.facilities.Room;

@AppComponent
public class DataStorageFacility extends DataStorage<Room>{

    @Override
    public String toString() {
        return "Price list of Hotel's services {" + super.toString();
    }
}
