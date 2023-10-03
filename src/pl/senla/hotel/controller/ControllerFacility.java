package pl.senla.hotel.controller;

import pl.senla.hotel.entity.facilities.HotelFacility;

import java.util.List;

public interface ControllerFacility extends ControllerCRUDALL<HotelFacility> {

    boolean updateRoomStatusAvailable(int idRoom);

    boolean updateRoomStatusRepaired(int idRoom);

    List<HotelFacility> readPriceListForServicesSortByCategory();
    List<HotelFacility> readPriceListForServicesSortByPrice();

    List<HotelFacility> readAllRoomsSortByPrice();
    List<HotelFacility> readAllRoomsSortByCapacity();
    List<HotelFacility> readAllRoomsSortByLevel();
}
