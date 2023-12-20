package pl.senla.hotel.controller;

import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.services.HotelService;

import java.util.List;

public interface ControllerOrder extends ControllerCRUDALL<Order> {

    List<HotelService> readAllServicesForOrder(int idOrderNew);
}
