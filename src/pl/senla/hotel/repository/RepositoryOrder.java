package pl.senla.hotel.repository;

import pl.senla.hotel.entity.HotelService;
import pl.senla.hotel.entity.Order;

import java.util.List;

public interface RepositoryOrder extends RepositoryCRUDALL<Order>{

    List<HotelService> readAllServicesSortByPrice(int idGuest);
    List<HotelService> readAllServicesSortByDate(int idGuest);
}
