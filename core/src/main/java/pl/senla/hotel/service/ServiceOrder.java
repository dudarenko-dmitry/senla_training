package pl.senla.hotel.service;

import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.services.HotelService;

import java.util.List;

public interface ServiceOrder extends ServiceCRUDALL<Order> {

    List<HotelService> readAllIdServicesForOrder(int idOrder);
}
