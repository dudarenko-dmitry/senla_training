package pl.senla.hotel.service;

import pl.senla.hotel.entity.FreeRoom;

import java.util.List;

public interface ServiceFreeRoomAdditional {

    List<FreeRoom> readAllFreeRoomsSortByPrice();
    List<FreeRoom> readAllFreeRoomsSortByCapacity();
    List<FreeRoom> readAllFreeRoomsSortByLevel();
}
