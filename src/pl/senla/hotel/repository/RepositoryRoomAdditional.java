package pl.senla.hotel.repository;

import pl.senla.hotel.entity.Room;

import java.util.List;

public interface RepositoryRoomAdditional {

    List<Room> readAllRoomsSortByPrice();
    List<Room> readAllRoomsSortByCapacity();
    List<Room> readAllRoomsSortByLevel();

}
