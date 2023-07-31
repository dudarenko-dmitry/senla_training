package pl.senla.hotel.storage;

import pl.senla.hotel.entity.services.Restaurant;

public class DataStorageRestaurant extends DataStorage<Restaurant> {

    private static DataStorageRestaurant dataStorageRestaurant;

    private DataStorageRestaurant() {
    }

    public static DataStorageRestaurant getDataStorageRestaurant() {
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
