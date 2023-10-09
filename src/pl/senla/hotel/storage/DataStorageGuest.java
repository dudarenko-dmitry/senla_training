package pl.senla.hotel.storage;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.entity.Guest;

@AppComponent
public class DataStorageGuest extends DataStorage<Guest>{

    private static DataStorageGuest dataStorageGuest;

    private DataStorageGuest(){}

    public static DataStorageGuest getSingletonInstance(){
        if(dataStorageGuest == null) {
            dataStorageGuest = new DataStorageGuest();
        }
        return dataStorageGuest;
    }

    @Override
    public String toString() {
        return "Order {" + super.toString();
    }
}
