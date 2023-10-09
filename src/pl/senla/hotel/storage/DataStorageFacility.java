package pl.senla.hotel.storage;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.entity.facilities.HotelFacility;

@AppComponent
public class DataStorageFacility extends DataStorage<HotelFacility>{

    private static DataStorageFacility dataStorageFacility;

    private DataStorageFacility() {
    }

    public static DataStorageFacility getSingletonInstance(){
        if(dataStorageFacility == null) {
            dataStorageFacility = new DataStorageFacility();
        }
        return dataStorageFacility;
    }

    @Override
    public String toString() {
        return "Price list of Hotel's services {" + super.toString();
    }
}
