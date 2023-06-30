package pl.senla.hotel.service;

import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.repository.RepositoryOrder;
import pl.senla.hotel.repository.RepositoryOrderCollection;

import java.util.List;

import static pl.senla.hotel.constant.OrderConstant.*;

public class ServiceOrderImpl implements ServiceOrder {

    private final RepositoryOrder orderRepository = new RepositoryOrderCollection();

    @Override
    public List<Order> readAll() {
        if(orderRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_ORDERS);
        }
        return orderRepository.readAll();
    }

    @Override
    public boolean create(Order order) {
        if(order.getGuest() == null){
            System.out.println(ERROR_CREATE_ORDER_NO_CLIENT);
            return false;
        } else if(order.getServices() == null){
            System.out.println(ERROR_CREATE_ORDER_NO_SERVICES);
            return false;
        } else if(read(order.getIdOrder()) != null && read(order.getIdOrder()).equals(order)){
            System.out.println(ERROR_CREATE_ORDER);
            return false;
        }
        return orderRepository.create(order);
    }

    @Override
    public Order read(int id) {
        if(readAll() == null){
            System.out.println(ERROR_READ_ALL_ORDERS);
            return null;
        } else if(orderRepository.read(id) == null){
            System.out.println(ERROR_READ_ORDER);
        }
        return orderRepository.read(id);
    }

    @Override
    public boolean update(Order order) {
        if(readAll() == null){
            System.out.println(ERROR_READ_ALL_ORDERS);
            return false;
        } else if(read(order.getIdOrder()) == null){
            System.out.println(ERROR_READ_ORDER);
        }
        return orderRepository.update(order);
    }

    @Override
    public boolean delete(int id) {
        if(readAll() == null){
            System.out.println(ERROR_READ_ALL_ORDERS);
            return false;
        } else if(read(id) == null){
            System.out.println(ERROR_READ_ORDER);
        }
        return orderRepository.delete(id);
    }

    @Override
    public List<HotelService> readAllServicesSortByPrice(int idGuest) {
        return orderRepository.readAllServicesSortByPrice(idGuest);
    }

    @Override
    public List<HotelService> readAllServicesSortByDate(int idGuest) {
        return orderRepository.readAllServicesSortByDate(idGuest);
    }

    @Override
    public List<HotelService> readAllServicesForGuest(Guest guest) {
        return orderRepository.readAllServicesForGuest(guest);
    }

    private void setIdOrderNew(Order order) {
        int lastId = readAll()
                .stream()
                .map(Order::getIdOrder)
                .max((o1, o2) -> o1 - o2)
                .orElse(-1);
        order.setIdOrder(lastId + 1);
    }
}
