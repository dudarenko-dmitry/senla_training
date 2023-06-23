package pl.senla.hotel.service;

import pl.senla.hotel.entity.HotelService;
import pl.senla.hotel.entity.Order;

import java.util.List;

public interface ServiceOrder extends ServiceCRUDALL<Order> {

    List<HotelService> readAllServicesSortByPrice(int idGuest);
    List<HotelService> readAllServicesSortByDate(int idGuest);
}
