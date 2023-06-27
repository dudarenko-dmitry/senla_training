package pl.senla.hotel.controller;

import pl.senla.hotel.service.ServiceRoomImpl;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.service.ServiceRoom;

import java.util.List;

public class ControllerRoomCollection implements ControllerRoom {

    private final ServiceRoom roomService = new ServiceRoomImpl();

    @Override
    public List<Room> readAll() {
        return roomService.readAll();
    }

    @Override
    public boolean create(Room room) {
        return roomService.create(room);
    }

    @Override
    public Room read(int roomId) {
        return roomService.read(roomId);
    }

    @Override
    public boolean update(Room room) {
        return roomService.update(room);
    }

    @Override
    public boolean delete(int roomId) {
        return roomService.delete(roomId);
    }

    @Override
    public List<Room> readAllRoomsSortByPrice() {
        return roomService.readAllRoomsSortByPrice();
    }

    @Override
    public List<Room> readAllRoomsSortByCapacity() {
        return roomService.readAllRoomsSortByCapacity();
    }

    @Override
    public List<Room> readAllRoomsSortByLevel() {
        return roomService.readAllRoomsSortByLevel();
    }
}
