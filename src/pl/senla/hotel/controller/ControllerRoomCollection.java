package pl.senla.hotel.controller;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.service.ServiceRoom;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@AppComponent
public class ControllerRoomCollection implements ControllerRoom {

    @GetInstance(beanName = "ServiceRoomImpl")
    private ServiceRoom roomService;

    public ControllerRoomCollection() {}

    @Override
    public List<HotelFacility> readAll() {
        return roomService.readAll();
    }

    @Override
    public boolean create(String roomString) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        return roomService.create(roomString);
    }

    @Override
    public HotelFacility read(int roomId) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        return roomService.read(roomId);
    }

    @Override
    public boolean update(int roomId, String roomString) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        return roomService.update(roomId, roomString);
    }

    @Override
    public boolean updateRoomStatusAvailable(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        return roomService.updateRoomStatusAvailable(idRoom);
    }

    @Override
    public boolean updateRoomStatusRepaired(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        return roomService.updateRoomStatusRepaired(idRoom);
    }

    @Override
    public boolean delete(int roomId) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        return roomService.delete(roomId);
    }

}
