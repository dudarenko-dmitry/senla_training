package pl.senla.hotel.service;

import pl.senla.hotel.entity.Order;
import pl.senla.hotel.repository.OrderRepositoryCollection;
import pl.senla.hotel.repository.Repository;

import java.util.List;

import static pl.senla.hotel.constant.OrderConstant.*;

public class OrderService implements Service<Order>{

    private final Repository<Order> orderRepository = new OrderRepositoryCollection();

    @Override
    public List<Order> readAll() {
        if(orderRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_ORDERS);
        }
        return orderRepository.readAll();
    }

    @Override
    public boolean create(Order order) {
        if(order.getClient() == null){
            System.out.println(ERROR_CREATE_ORDER_NO_CLIENT);
            return false;
        } else if(order.getServices() == null){
            System.out.println(ERROR_CREATE_ORDER_NO_SERVICES);
            return false;
        } else if(read(order.getIdOrder()) != null){
            System.out.println(ERROR_CREATE_ORDER);
            return false;
        }
        return orderRepository.create(order);
    }

    @Override
    public Order read(int id) {
        if(orderRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_ORDERS);
            return null;
        } else if(orderRepository.read(id) == null){
            System.out.println(ERROR_READ_ORDER);
        }
        return orderRepository.read(id);
    }

    @Override
    public boolean update(Order order) {
        if(orderRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_ORDERS);
            return false;
        } else if(orderRepository.read(order.getIdOrder()) == null){
            System.out.println(ERROR_READ_ORDER);
        }
        return orderRepository.update(order);
    }

    @Override
    public boolean delete(int id) {
        if(orderRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_ORDERS);
            return false;
        } else if(orderRepository.read(id) == null){
            System.out.println(ERROR_READ_ORDER);
        }
        return orderRepository.delete(id);
    }
}
