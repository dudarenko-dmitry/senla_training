package pl.senla.hotel.service;

import pl.senla.hotel.entity.services.FreeRoom;

import java.util.List;

public interface ServiceFreeRoomCRUDALL {

    List<FreeRoom> readAllFreeRooms();
    boolean createFreeRoom(FreeRoom freeRoom);
    FreeRoom readFreeRoom(int id);
    boolean updateFreeRoom(FreeRoom freeRoom);
    boolean deleteFreeRoom(int id);

}
