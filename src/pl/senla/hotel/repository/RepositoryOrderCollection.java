package pl.senla.hotel.repository;

import pl.senla.hotel.comparators.HotelServicesComparatorByDate;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.comparators.HotelServicesComparatorByPrice;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.storage.DataStorage;
import pl.senla.hotel.storage.DataStorageOrder;

import java.util.List;

public class RepositoryOrderCollection implements RepositoryOrder {

    private final DataStorage<Order> orderDataStorage;

    public RepositoryOrderCollection() {
        this.orderDataStorage = DataStorageOrder.getDataStorageOrder();
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

    @Override
    public List<HotelService> readAllServicesSortByPrice(int idGuest) {
        return readAll()
                .stream()
                .filter(o -> o.getIdGuest() == idGuest)
                .flatMap(o -> o.getServices().stream())
                .sorted(new HotelServicesComparatorByPrice())
                .toList();
    }

    @Override
    public List<HotelService> readAllServicesSortByDate(int idGuest) {
        return readAll()
                .stream()
                .filter(o -> o.getIdGuest() == idGuest)
                .flatMap(o -> o.getServices().stream())
                .sorted(new HotelServicesComparatorByDate())
                .toList();
    }

    @Override
    public List<HotelService> readAllServicesForGuest(int idGuest) {
        return readAll()
                .stream()
                .filter(o -> o.getIdGuest() == idGuest)
                .map(Order::getServices)
                .findAny().orElse(null);
    }
}
