package pl.senla.hotel.repository;

import pl.senla.hotel.entity.Room;

import java.util.List;

public interface RepositoryRoomReservationAdditional {

    List<Room> readAllFreeRoomsSortByPrice();
    List<Room> readAllFreeRoomsSortByCapacity();
    List<Room> readAllFreeRoomsSortByLevel();
}
