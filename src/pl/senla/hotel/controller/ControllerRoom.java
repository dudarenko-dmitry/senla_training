package pl.senla.hotel.controller;

import pl.senla.hotel.entity.Room;

import java.util.List;

public interface ControllerRoom extends ControllerCRUDALL<Room> {

    List<Room> readAllRoomsSortByPrice();
    List<Room> readAllRoomsSortByCapacity();
    List<Room> readAllRoomsSortByLevel();
}
