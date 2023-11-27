package pl.senla.hotel.controller;

import pl.senla.hotel.entity.facilities.Room;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ControllerFacility extends ControllerCRUDALL<Room> {

    boolean updateRoomStatusAvailable(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException;

    boolean updateRoomStatusRepaired(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException;

    List<Room> readPriceListForServicesSortByCategory();
    List<Room> readPriceListForServicesSortByPrice();

    List<Room> readAllRoomsSortByPrice();
    List<Room> readAllRoomsSortByCapacity();
    List<Room> readAllRoomsSortByLevel();
}
