package pl.senla.hotel.service;

import pl.senla.hotel.dto.RoomDto;
import pl.senla.hotel.entity.facilities.Room;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ServiceFacility extends ServiceCRUDALL<Room, RoomDto> {

    List<Room> readPriceListForServicesSortByCategory();
    List<Room> readPriceListForServicesSortByPrice();

    List<Room> readAllRoomsSortByPrice();
    List<Room> readAllRoomsSortByCapacity();
    List<Room> readAllRoomsSortByLevel();

    Room updateRoomStatusAvailable(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException;

    Room updateRoomStatusRepaired(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException;

    Room getRoomByNameFacility(String nameFacility);
}
