package pl.senla.hotel.storage;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.entity.services.Transfer;

@AppComponent
public class DataStorageTransport extends DataStorage<Transfer>{

    private static DataStorageTransport dataStorageTransport;

    private DataStorageTransport(){}

    public static DataStorageTransport getSingletonInstance(){
        if (dataStorageTransport == null) {
            dataStorageTransport = new DataStorageTransport();
        }
        return dataStorageTransport;
    }

    @Override
    public String toString() {
        return "Transport {" + super.toString();
    }
}
