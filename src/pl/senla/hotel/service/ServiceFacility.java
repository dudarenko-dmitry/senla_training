package pl.senla.hotel.service;

import pl.senla.hotel.entity.facilities.HotelFacility;

import java.util.List;

public interface ServiceFacility extends ServiceCRUDALL<HotelFacility> {

    List<HotelFacility> readPriceListForServicesSortByCategory();
    List<HotelFacility> readPriceListForServicesSortByPrice();

    List<HotelFacility> readAllRoomsSortByPrice();
    List<HotelFacility> readAllRoomsSortByCapacity();
    List<HotelFacility> readAllRoomsSortByLevel();
}
