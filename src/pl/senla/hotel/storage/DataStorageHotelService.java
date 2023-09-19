package pl.senla.hotel.storage;

import pl.senla.hotel.entity.services.HotelService;

public class DataStorageHotelService extends DataStorage<HotelService>{

    private static DataStorageHotelService dataStorageHotelService;

    private DataStorageHotelService(){}

    public static DataStorageHotelService getDataStorageHotelService(){
        if(dataStorageHotelService == null) {
            dataStorageHotelService = new DataStorageHotelService();
        }
        return dataStorageHotelService;
    }

    @Override
    public String toString() {
        return "Hotel's Services {" + super.toString();
    }
}