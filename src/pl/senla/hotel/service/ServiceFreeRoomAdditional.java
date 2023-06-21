package pl.senla.hotel.service;

import pl.senla.hotel.entity.FreeRoom;

import java.time.LocalDateTime;
import java.util.List;

public interface ServiceFreeRoomAdditional {

    List<FreeRoom> readAllFreeRoomsSortByPrice();
    List<FreeRoom> readAllFreeRoomsSortByCapacity();
    List<FreeRoom> readAllFreeRoomsSortByLevel();
    int countFreeRoomsOnTime(LocalDateTime checkedDateTime);
    List<FreeRoom> readAllRoomsFreeAtTime(LocalDateTime checkedTime);
}
