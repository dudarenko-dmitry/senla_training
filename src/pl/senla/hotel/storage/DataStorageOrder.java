package pl.senla.hotel.storage;

import pl.senla.hotel.entity.Order;

public class DataStorageOrder extends DataStorage<Order>{

    private static DataStorageOrder dataStorageOrder;

    private DataStorageOrder(){}

    public static DataStorageOrder getDataStorageOrder(){
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
