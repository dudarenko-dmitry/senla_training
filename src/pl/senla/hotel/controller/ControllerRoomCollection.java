package pl.senla.hotel.controller;

import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.service.ServiceRoomImpl;
import pl.senla.hotel.service.ServiceRoom;

import java.util.List;

public class ControllerRoomCollection implements ControllerRoom {

    private static ControllerRoom controllerRoom;
    private final ServiceRoom roomService;

    private ControllerRoomCollection() {
        this.roomService = ServiceRoomImpl.getServiceRoom();
    }

    public static ControllerRoom getControllerRoom() {
        if (controllerRoom == null) {
            controllerRoom = new ControllerRoomCollection();
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
    public boolean delete(int roomId) {
        return roomService.delete(roomId);
    }

}
