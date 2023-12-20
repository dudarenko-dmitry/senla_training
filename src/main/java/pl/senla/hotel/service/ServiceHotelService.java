package pl.senla.hotel.service;

import pl.senla.hotel.entity.services.HotelService;

import java.util.List;

public interface ServiceHotelService extends ServiceCRUDALL<HotelService>{

    List<HotelService> findServicesForOrder(int idOrder);
}
