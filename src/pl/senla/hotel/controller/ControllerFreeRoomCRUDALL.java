package pl.senla.hotel.controller;

import pl.senla.hotel.entity.services.FreeRoom;

import java.util.List;

public interface ControllerFreeRoomCRUDALL {

    List<FreeRoom> readAllFreeRooms();
    boolean createFreeRoom(FreeRoom freeRoom);
    FreeRoom readFreeRoom(int id);
    boolean updateFreeRoom(FreeRoom freeRoom);
    boolean deleteFreeRoom(int id);

}
