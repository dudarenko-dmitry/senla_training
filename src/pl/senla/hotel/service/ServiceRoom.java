package pl.senla.hotel.service;

import pl.senla.hotel.entity.facilities.HotelFacility;

import java.lang.reflect.InvocationTargetException;

public interface ServiceRoom extends ServiceCRUDALL<HotelFacility>{

    boolean updateRoomStatusAvailable(int idRoom) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    boolean updateRoomStatusRepaired(int idRoom) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
