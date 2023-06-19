package pl.senla.hotel.controller;

import pl.senla.hotel.entity.Order;
import pl.senla.hotel.service.ServiceOrderImpl;
import pl.senla.hotel.service.ServiceCRUDALL;

import java.util.List;

public class ControllerOrderCollection implements ControllerOrder {

    private final ServiceCRUDALL<Order> orderService = new ServiceOrderImpl();


    @Override
    public List<Order> readAll() {
        return orderService.readAll();
    }

    @Override
    public boolean create(Order order) {
        return orderService.create(order);
    }

    @Override
    public Order read(int id) {
        return orderService.read(id);
    }

    @Override
    public boolean update(Order order) {
        return orderService.update(order);
    }

    @Override
    public boolean delete(int id) {
        return orderService.delete(id);
    }
}
