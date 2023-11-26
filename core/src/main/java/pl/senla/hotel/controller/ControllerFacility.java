package pl.senla.hotel.controller;

import pl.senla.hotel.entity.facilities.HotelFacility;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ControllerFacility extends ControllerCRUDALL<HotelFacility> {

    boolean updateRoomStatusAvailable(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException;

    boolean updateRoomStatusRepaired(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException;

    List<HotelFacility> readPriceListForServicesSortByCategory();
    List<HotelFacility> readPriceListForServicesSortByPrice();

    List<HotelFacility> readAllRoomsSortByPrice();
    List<HotelFacility> readAllRoomsSortByCapacity();
    List<HotelFacility> readAllRoomsSortByLevel();
}
