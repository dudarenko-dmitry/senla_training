package pl.senla.hotel.controller;

import pl.senla.hotel.entity.facilities.HotelFacility;

import java.lang.reflect.InvocationTargetException;

public interface ControllerRoom extends ControllerCRUDALL<HotelFacility> {

    boolean updateRoomStatusAvailable(int idRoom) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    boolean updateRoomStatusRepaired(int idRoom) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
