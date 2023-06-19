package pl.senla.hotel.service;

import pl.senla.hotel.entity.Room;

import java.util.List;

public interface ServiceRoomReservationAdditional {

    List<Room> readAllFreeRoomsSortByPrice();
    List<Room> readAllFreeRoomsSortByCapacity();
    List<Room> readAllFreeRoomsSortByLevel();
}
