package pl.senla.hotel.controller;

import pl.senla.hotel.entity.Room;

import java.util.List;

public interface ControllerRoomReservationAdditional {

    List<Room> readAllFreeRoomsSortByPrice();
    List<Room> readAllFreeRoomsSortByCapacity();
    List<Room> readAllFreeRoomsSortByLevel();

}
