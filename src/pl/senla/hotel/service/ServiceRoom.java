package pl.senla.hotel.service;

import pl.senla.hotel.entity.Room;

import java.util.List;

public interface ServiceRoom extends ServiceCRUDALL<Room>{

    List<Room> readAllRoomsSortByPrice();
    List<Room> readAllRoomsSortByCapacity();
    List<Room> readAllRoomsSortByLevel();

}
