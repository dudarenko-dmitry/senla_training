package pl.senla.hotel.storage;

import pl.senla.hotel.entity.services.Transfer;

public class DataStorageTransfer extends DataStorage<Transfer>{

    private static DataStorageTransfer dataStorageTransfer;

    private DataStorageTransfer(){}

    public static DataStorageTransfer getDataStorageTransfer(){
        if(dataStorageTransfer == null) {
            dataStorageTransfer = new DataStorageTransfer();
            System.out.println("DataStorage for Transfer was created.");
        }
        return dataStorageTransfer;
    }

    @Override
    public String toString() {
        return "Accommodation {" + super.toString();
    }
}
