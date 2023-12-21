package pl.senla.hotel.controller;

import pl.senla.hotel.dto.RoomDto;
import pl.senla.hotel.entity.facilities.Room;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ControllerFacility extends ControllerCRUDALL<RoomDto> {

    Room updateRoomStatusAvailable(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException;

    Room updateRoomStatusRepaired(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException;

    List<RoomDto> readPriceListForServicesSortByCategory();
    List<RoomDto> readPriceListForServicesSortByPrice();

    List<RoomDto> readAllRoomsSortByPrice();
    List<RoomDto> readAllRoomsSortByCapacity();
    List<RoomDto> readAllRoomsSortByLevel();
}
