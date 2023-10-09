package pl.senla.hotel.controller;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.service.ServiceRoom;

import java.util.List;

@AppComponent
public class ControllerRoomCollection implements ControllerRoom {

    private static ControllerRoom controllerRoom;
    @GetInstance(beanName = "ServiceRoomImpl")
    private final ServiceRoom roomService;

    private ControllerRoomCollection(ServiceRoom roomService) {
        this.roomService = roomService;
    }

    public static ControllerRoom getSingletonInstance(ServiceRoom roomService) {
        if (controllerRoom == null) {
            controllerRoom = new ControllerRoomCollection(roomService);
        }
        return controllerRoom;
    }

    @Override
    public List<HotelFacility> readAll() {
        return roomService.readAll();
    }

    @Override
    public boolean create(String roomString) {
        return roomService.create(roomString);
    }

    @Override
    public HotelFacility read(int roomId) {
        return roomService.read(roomId);
    }

    @Override
    public boolean update(int roomId, String roomString) {
        return roomService.update(roomId, roomString);
    }

    @Override
    public boolean updateRoomStatusAvailable(int idRoom){
        return roomService.updateRoomStatusAvailable(idRoom);
    }

    @Override
    public boolean updateRoomStatusRepaired(int idRoom){
        return roomService.updateRoomStatusRepaired(idRoom);
    }

    @Override
    public boolean delete(int roomId) {
        return roomService.delete(roomId);
    }

}
