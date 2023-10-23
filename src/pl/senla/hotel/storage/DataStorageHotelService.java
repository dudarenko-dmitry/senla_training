package pl.senla.hotel.storage;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.entity.services.HotelService;

@AppComponent
public class DataStorageHotelService extends DataStorage<HotelService>{

    public DataStorageHotelService(){}

    @Override
    public String toString() {
        return "Hotel's Services {" + super.toString();
    }
}
