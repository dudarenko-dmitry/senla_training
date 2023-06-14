package pl.senla.lecture3.task4.controller;

import pl.senla.lecture3.task4.entity.Room;
import pl.senla.lecture3.task4.service.RoomService;
import pl.senla.lecture3.task4.service.Service;

import java.util.List;

public class RoomControllerCollection implements Controller<Room>{

    private Service<Room> roomService = new RoomService();

    public RoomControllerCollection() {
    }

    public RoomControllerCollection(Service<Room> roomService) {
        this.roomService = roomService;
    }

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
        Room room = new Room(roomId);
        return roomService.read(room);
    }

    @Override
    public boolean update(Room room) {
        return roomService.update(room);
    }

    @Override
    public boolean delete(int roomId) {
        Room room = new Room(roomId);
        return roomService.delete(room);
    }
}
