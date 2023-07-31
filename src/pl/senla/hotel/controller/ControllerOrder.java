package pl.senla.hotel.controller;

import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.Order;

import java.util.List;

public interface ControllerOrder extends ControllerCRUDALL<Order> {

    List<HotelService> readAllServicesForGuestSortByPrice(int idGuest);
    List<HotelService> readAllServicesForGuestSortByDate(int idGuest);
    List<HotelService> readAllServicesForGuest(int guest);
}
