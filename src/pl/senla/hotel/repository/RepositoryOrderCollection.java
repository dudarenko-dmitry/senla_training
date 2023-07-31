package pl.senla.hotel.repository;

import pl.senla.hotel.entity.Order;
import pl.senla.hotel.storage.DataStorage;
import pl.senla.hotel.storage.DataStorageOrder;

import java.util.List;

public class RepositoryOrderCollection implements Repository<Order> {

    private static Repository<Order> repositoryOrder;
    private final DataStorage<Order> orderDataStorage;

    private RepositoryOrderCollection() {
        this.orderDataStorage = DataStorageOrder.getDataStorageOrder();
    }

    public static Repository<Order> getRepositoryOrder(){
        if(repositoryOrder == null){
            repositoryOrder = new RepositoryOrderCollection();
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
