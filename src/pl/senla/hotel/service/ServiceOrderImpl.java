package pl.senla.hotel.service;

import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.repository.RepositoryOrder;
import pl.senla.hotel.repository.RepositoryOrderCollection;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static pl.senla.hotel.constant.OrderConstant.*;

public class ServiceOrderImpl implements ServiceOrder {

    private final RepositoryOrder repositoryOrder;

    public ServiceOrderImpl() {
        this.repositoryOrder = new RepositoryOrderCollection();
    }

    @Override
    public List<Order> readAll() {
        if(repositoryOrder.readAll() == null  || readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_ORDERS);
            return Collections.emptyList();
        }
        return repositoryOrder.readAll();
    }

    @Override
    public boolean create(String orderString) {
        int idGuest = Integer.parseInt(orderString);
        Order order = new Order(idGuest);
        order.setIdOrder(-1);
        List<HotelService> servicesInOrder = readAllServicesForGuest(idGuest);
        order.setServices(servicesInOrder);
        setIdOrderNew(order);
        return repositoryOrder.create(order);
    }

    @Override
    public Order read(int idOrder) {
        if(readAll() == null){
            System.out.println(ERROR_READ_ALL_ORDERS);
            return null;
        }
        for(int i = 0; i <= readAll().size(); i++){
            if(readAll().get(i).getIdOrder() == idOrder){
                return repositoryOrder.read(i);
            }
        }
        System.out.println(ERROR_READ_ORDER);
        return null;
    }

    @Override
    // This method is not used in application.
    // All changes are processed in appropriate Services depending on Type of Hotel's Service.
    public boolean update(int idOrder, String orderUpdatingString) {
        if(readAll() == null){
            System.out.println(ERROR_READ_ALL_ORDERS);
            return false;
        } else if(read(idOrder) == null){
            System.out.println(ERROR_READ_ORDER);
        }
        return repositoryOrder.update(-1, null);
    }

    @Override
    public boolean delete(int idOrder) {
        if(readAll() == null){
            System.out.println(ERROR_READ_ALL_ORDERS);
            return false;
        }
        for(int i = 0; i <= readAll().size(); i++){
            if(readAll().get(i).getIdOrder() == idOrder){
                return repositoryOrder.delete(i);            }
        }
        System.out.println(ERROR_READ_ORDER);
        return false;
    }

    @Override
    public List<HotelService> readAllServicesSortByPrice(int idGuest) {
        return repositoryOrder.readAllServicesSortByPrice(idGuest);
    }

    @Override
    public List<HotelService> readAllServicesSortByDate(int idGuest) {
        return repositoryOrder.readAllServicesSortByDate(idGuest);
    }

    @Override
    public List<HotelService> readAllServicesForGuest(int idGuest) {
        return repositoryOrder.readAllServicesForGuest(idGuest);
    }

    private void setIdOrderNew(Order order) {
        int lastId = readAll()
                .stream()
                .map(Order::getIdOrder)
                .max(Comparator.comparingInt(o -> o))
                .orElse(-1);
        order.setIdOrder(lastId + 1);
    }
}
