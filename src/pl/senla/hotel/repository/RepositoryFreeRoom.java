package pl.senla.hotel.repository;

import pl.senla.hotel.entity.FreeRoom;

import java.time.LocalDateTime;
import java.util.List;

public interface RepositoryFreeRoom extends RepositoryCRUDALL<FreeRoom> {

    List<FreeRoom> readAllFreeRoomsSortByPrice();
    List<FreeRoom> readAllFreeRoomsSortByCapacity();
    List<FreeRoom> readAllFreeRoomsSortByLevel();
    int countFreeRoomsOnTime(LocalDateTime checkedDateTime);
    List<FreeRoom> readAllRoomsFreeAtTime(LocalDateTime checkedTime);
}
