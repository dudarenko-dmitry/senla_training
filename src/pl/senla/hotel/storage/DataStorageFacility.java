package pl.senla.hotel.storage;

import pl.senla.hotel.entity.facilities.HotelFacility;

public class DataStorageFacility extends DataStorage<HotelFacility>{

    @Override
    public String toString() {
        return "Price list of Hotel's services {" + super.toString();
    }
}
