package pl.senla.hotel.controller;

import pl.senla.hotel.entity.FreeRoom;

import java.util.List;

public interface ControllerFreeRoomAdditional {

    List<FreeRoom> readAllFreeRoomsSortByPrice();
    List<FreeRoom> readAllFreeRoomsSortByCapacity();
    List<FreeRoom> readAllFreeRoomsSortByLevel();

}
