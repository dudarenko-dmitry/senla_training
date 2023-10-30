package pl.senla.hotel.service;

import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.Order;

import java.util.List;

public interface ServiceOrder extends ServiceCRUDALL<Order> {

    List<HotelService> readAllServicesSortByPrice();
    List<HotelService> readAllServicesSortByDate();
    List<HotelService> readAllServicesForOrder(int idOrder);

    boolean addServicesToOrder(int idOrder);
}
