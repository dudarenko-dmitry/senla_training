package pl.senla.hotel.controller;

import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.Order;

import java.util.List;

public interface ControllerOrder extends ControllerCRUDALL<Order> {

    List<HotelService> readAllServicesSortByPrice();
    List<HotelService> readAllServicesSortByDate();
    List<HotelService> readAllServicesForOrder(int idOrder);

    boolean addServicesToOrder(int idOrder);
}
