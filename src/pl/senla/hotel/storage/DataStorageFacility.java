package pl.senla.hotel.storage;

import pl.senla.hotel.entity.facilities.HotelFacility;

public class DataStorageFacility extends DataStorage<HotelFacility>{

    private static DataStorageFacility dataStorageFacility;

    private DataStorageFacility() {
    }

    public static DataStorageFacility getDataStorageFacility(){
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
