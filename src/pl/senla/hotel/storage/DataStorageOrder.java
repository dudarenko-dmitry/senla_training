package pl.senla.hotel.storage;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.entity.Order;

@AppComponent
public class DataStorageOrder extends DataStorage<Order>{

    private static DataStorageOrder dataStorageOrder;

    private DataStorageOrder(){}

    public static DataStorageOrder getSingletonInstance(){
        if(dataStorageOrder == null){
            dataStorageOrder = new DataStorageOrder();
        }
        return dataStorageOrder;
    }

    @Override
    public String toString() {
        return "Order {" + super.toString();
    }
}
