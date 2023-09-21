package pl.senla.hotel.controller;

import pl.senla.hotel.configuration.AppConfiguration;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.service.ServiceOrder;
import pl.senla.hotel.service.ServiceOrderImpl;

import java.util.List;

public class ControllerOrderCollection implements ControllerOrder {

    private static ControllerOrder controllerOrder;
    private final ServiceOrder orderService;

    private ControllerOrderCollection() {
        this.orderService = ServiceOrderImpl.getServiceOrder(AppConfiguration.getAppConfiguration());
    }

    public static ControllerOrder getControllerOrder(){
        if(controllerOrder == null){
            controllerOrder = new ControllerOrderCollection();
        }
        return controllerOrder;
    }

    @Override
    public List<Order> readAll() {
        return orderService.readAll();
    }

    @Override
    public boolean create(String orderString) {
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
