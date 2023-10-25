package pl.senla.hotel.storage;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.entity.services.Transfer;

@AppComponent
public class DataStorageTransport extends DataStorage<Transfer>{

    public DataStorageTransport(){}

    @Override
    public String toString() {
        return "Transport {" + super.toString();
    }
}