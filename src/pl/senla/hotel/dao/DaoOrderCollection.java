package pl.senla.hotel.dao;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.storage.DataStorage;

import java.util.List;

@AppComponent
public class DaoOrderCollection implements GenericDao<Order> {

    @GetInstance(beanName = "DataStorageOrder")
    private DataStorage<Order> orderDataStorage;

    public DaoOrderCollection() {}

    @Override
    public List<Order> readAll() {
        return orderDataStorage.getDataList();
    }

    @Override
    public boolean create(Order order) {
        readAll().add(order);
        return true;
    }

    @Override
    public Order read(int id) {
        return readAll().get(id);
    }

    @Override
    public boolean update(int id, Order order) {
        readAll().set(order.getIdOrder(), order);
        return true;
    }

    @Override
    public boolean delete(int id) {
        readAll().remove(id);
        return true;
    }
}
