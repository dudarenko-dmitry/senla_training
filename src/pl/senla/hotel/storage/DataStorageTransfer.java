package pl.senla.hotel.storage;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.entity.services.Transfer;

@AppComponent
public class DataStorageTransfer extends DataStorage<Transfer>{

    private static DataStorageTransfer dataStorageTransfer;

    private DataStorageTransfer(){}

    public static DataStorageTransfer getSingletonInstance(){
        if(dataStorageTransfer == null) {
            dataStorageTransfer = new DataStorageTransfer();
        }
        return dataStorageTransfer;
    }

    @Override
    public String toString() {
        return "Accommodation {" + super.toString();
    }
}
