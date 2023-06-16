package pl.senla.hotel.controller;

import pl.senla.hotel.service.RoomService;
import pl.senla.hotel.entity.Room;
import pl.senla.hotel.service.Service;

import java.util.List;

public class RoomController implements Controller<Room>{

    private final Service<Room> roomService = new RoomService();

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
}
