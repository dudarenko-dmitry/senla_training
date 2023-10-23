package pl.senla.hotel.storage;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.entity.services.Restaurant;

@AppComponent
public class DataStorageRestaurant extends DataStorage<Restaurant> {

    public DataStorageRestaurant() {
    }

    @Override
    public String toString() {
        return "Restaurant {" + super.toString();
    }
}
