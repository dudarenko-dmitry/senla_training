package pl.senla.hotel.storage;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.entity.Order;

@AppComponent
public class DataStorageOrder extends DataStorage<Order>{

    @Override
    public String toString() {
        return "Order {" + super.toString();
    }
}
