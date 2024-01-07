package pl.senla.hotel.controller;

import pl.senla.hotel.dto.RoomDto;

import java.lang.reflect.InvocationTargetException;

public interface ControllerFacility extends ControllerCRUDALL<RoomDto, RoomDto> {

    RoomDto updateRoomStatusAvailable(Integer idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException;

    RoomDto updateRoomStatusRepaired(Integer idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException;

}
