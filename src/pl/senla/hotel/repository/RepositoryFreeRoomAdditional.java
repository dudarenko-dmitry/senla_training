package pl.senla.hotel.repository;

import pl.senla.hotel.entity.FreeRoom;

import java.util.List;

public interface RepositoryFreeRoomAdditional {

    List<FreeRoom> readAllFreeRoomsSortByPrice();
    List<FreeRoom> readAllFreeRoomsSortByCapacity();
    List<FreeRoom> readAllFreeRoomsSortByLevel();
}
