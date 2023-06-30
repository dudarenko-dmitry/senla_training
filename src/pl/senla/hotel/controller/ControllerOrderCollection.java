package pl.senla.hotel.controller;

import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.service.ServiceOrder;
import pl.senla.hotel.service.ServiceOrderImpl;

import java.util.List;

public class ControllerOrderCollection implements ControllerOrder {

    private final ServiceOrder orderService = new ServiceOrderImpl();


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

    @Override
    public List<HotelService> readAllServicesSortByPrice(int idGuest) {
        return orderService.readAllServicesSortByPrice(idGuest);
    }

    @Override
    public List<HotelService> readAllServicesSortByDate(int idGuest) {
        return orderService.readAllServicesSortByDate(idGuest);
    }

    @Override
    public List<HotelService> readAllServicesForGuest(Guest guest) {
        return orderService.readAllServicesForGuest(guest);
    }
}
