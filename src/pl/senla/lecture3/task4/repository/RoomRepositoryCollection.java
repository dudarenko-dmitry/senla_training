package pl.senla.lecture3.task4.repository;

import pl.senla.lecture3.task4.entity.Room;
import pl.senla.lecture3.task4.storage.DataStorage;
import pl.senla.lecture3.task4.storage.DataStorageRoom;

import java.util.List;

public class RoomRepositoryCollection implements Repository<Room>{

    private final DataStorage<Room> dataStorage = new DataStorageRoom();

    @Override
    public List<Room> readAll() {
        return dataStorage.getDataList();
    }

    @Override
    public boolean create(Room room) {
        readAll().add(room);
        return true;
    }

    @Override
    public Room read(Room room) {
        int roomId = room.getRoomId();
        Room roomRead = null;
        for(Room r : readAll()){
            if (roomId == r.getRoomId()){
                roomRead = r;
            }
        }
        return roomRead;
    }

    @Override
    public boolean update(Room room) { // check method (ID must be always equal index)
        int roomId = room.getRoomId();
        readAll().set(roomId, room);
        return true;
    }

    @Override
    public boolean delete(Room room) {
        int roomId = room.getRoomId();
        readAll().remove(roomId);
        return true;
    }
}
