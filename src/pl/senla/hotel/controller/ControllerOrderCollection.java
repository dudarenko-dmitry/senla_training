package pl.senla.hotel.controller;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.service.ServiceOrder;

import java.util.List;

@AppComponent
public class ControllerOrderCollection implements ControllerOrder {

    @GetInstance(beanName = "ServiceOrderImpl")
    private ServiceOrder orderService;

    public ControllerOrderCollection() {}

    @Override
    public List<Order> readAll() {
        return orderService.readAll();
    }

    @Override
    public boolean create(String orderString) throws IllegalAccessException {
        return orderService.create(orderString);
    }

    @Override
    public Order read(int idOrder) {
        return orderService.read(idOrder);
    }

    @Override
    public boolean update(int idOrder, String orderString) {
        return orderService.update(idOrder, orderString);
    }

    @Override
    public boolean delete(int id) {
        return orderService.delete(id);
    }

    @Override
    public List<HotelService> readAllServicesSortByPrice() {
        return orderService.readAllServicesSortByPrice();
    }

    @Override
    public List<HotelService> readAllServicesSortByDate() {
        return orderService.readAllServicesSortByDate();
    }

    @Override
    public List<HotelService> readAllServicesForOrder(int idOrder) {
        return orderService.readAllServicesForOrder(idOrder);
    }
}
