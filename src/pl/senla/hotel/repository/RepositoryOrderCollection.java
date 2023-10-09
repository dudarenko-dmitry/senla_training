package pl.senla.hotel.repository;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.storage.DataStorage;

import java.util.List;

@AppComponent
public class RepositoryOrderCollection implements Repository<Order> {

    private static Repository<Order> repositoryOrder;
    @GetInstance(beanName = "DataStorageOrder")
    private final DataStorage<Order> orderDataStorage;

    private RepositoryOrderCollection(DataStorage<Order> orderDataStorage) {
        this.orderDataStorage = orderDataStorage;
    }

    public static Repository<Order> getSingletonInstance(DataStorage<Order> orderDataStorage){
        if(repositoryOrder == null){
            repositoryOrder = new RepositoryOrderCollection(orderDataStorage);
        }
        return repositoryOrder;
    }

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
