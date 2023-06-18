package pl.senla.hotel.repository;

import pl.senla.hotel.entity.Room;
import pl.senla.hotel.storage.DataStorage;
import pl.senla.hotel.storage.DataStorageRoom;

import java.util.List;

public class RepositoryRoomCollection implements RepositoryRoom {

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
    public Room read(int id) {
        Room roomRead = null;
        for(Room r : readAll()){
            if (id == r.getRoomId()){
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
    public boolean delete(int id) {
        readAll().remove(id);
        return true;
    }
}
