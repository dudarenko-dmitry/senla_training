package pl.senla.hotel.controller;

import pl.senla.hotel.entity.Order;
import pl.senla.hotel.service.OrderService;
import pl.senla.hotel.service.Service;

import java.util.List;

public class OrderController implements Controller<Order> {

    private final Service<Order> orderService = new OrderService();


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
