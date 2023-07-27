package pl.senla.hotel.controller;

import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.service.ServiceOrder;
import pl.senla.hotel.service.ServiceOrderImpl;

import java.util.List;

public class ControllerOrderCollection implements ControllerOrder {

    private static ControllerOrder controllerOrder;
    private final ServiceOrder orderService;

    private ControllerOrderCollection() {
        this.orderService = ServiceOrderImpl.getServiceOrder();
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
    public List<HotelService> readAllServicesForGuestSortByPrice(int idGuest) {
        return orderService.readAllServicesSortByPrice(idGuest);
    }

    @Override
    public List<HotelService> readAllServicesForGuestSortByDate(int idGuest) {
        return orderService.readAllServicesSortByDate(idGuest);
    }

    @Override
    public List<HotelService> readAllServicesForGuest(int guest) {
        return orderService.readAllServicesForGuest(guest);
    }
}
