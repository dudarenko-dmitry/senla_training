package pl.senla.hotel.storage;

import pl.senla.hotel.entity.Guest;

public class DataStorageGuest extends DataStorage<Guest>{

    private static DataStorageGuest dataStorageGuest;

    private DataStorageGuest(){}

    public static DataStorageGuest getDataStorageGuest(){
        if(dataStorageGuest == null) {
            dataStorageGuest = new DataStorageGuest();
            System.out.println("DataStorage for Guest was created.");
        }
        return dataStorageGuest;
    }

    @Override
    public String toString() {
        return "Order {" + super.toString();
    }
}
