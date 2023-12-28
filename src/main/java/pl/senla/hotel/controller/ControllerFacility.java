package pl.senla.hotel.controller;

import pl.senla.hotel.dto.RoomDto;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ControllerFacility extends ControllerCRUDALL<RoomDto, RoomDto> {

    RoomDto updateRoomStatusAvailable(Integer idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException;

    RoomDto updateRoomStatusRepaired(Integer idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException;

    List<RoomDto> readPriceListForServicesSortByCategory();
    List<RoomDto> readPriceListForServicesSortByPrice();

    List<RoomDto> readAllRoomsSortByPrice();
    List<RoomDto> readAllRoomsSortByCapacity();
    List<RoomDto> readAllRoomsSortByLevel();
}
