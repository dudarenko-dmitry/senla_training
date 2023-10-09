package pl.senla.hotel.storage;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.entity.services.Restaurant;

@AppComponent
public class DataStorageRestaurant extends DataStorage<Restaurant> {

    private static DataStorageRestaurant dataStorageRestaurant;

    private DataStorageRestaurant() {
    }

    public static DataStorageRestaurant getSingletonInstance() {
        if (dataStorageRestaurant == null) {
            dataStorageRestaurant = new DataStorageRestaurant();
        }
        return dataStorageRestaurant;
    }

    @Override
    public String toString() {
        return "Accommodation {" + super.toString();
    }
}
