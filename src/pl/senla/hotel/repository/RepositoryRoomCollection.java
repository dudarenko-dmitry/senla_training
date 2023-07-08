package pl.senla.hotel.repository;

import pl.senla.hotel.comparators.RoomComparatorByCapacity;
import pl.senla.hotel.comparators.RoomComparatorByLevel;
import pl.senla.hotel.comparators.RoomComparatorByPrice;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.storage.DataStorage;
import pl.senla.hotel.storage.DataStorageRoom;

import java.util.List;

public class RepositoryRoomCollection implements RepositoryRoom {

    private final DataStorage<Room> dataStorage;

    public RepositoryRoomCollection() {
        this.dataStorage = DataStorageRoom.getDataStorageRoom();
    }

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
            if (id == r.getIdFacility()){
                roomRead = r;
            }
        }
        return roomRead;
    }

    @Override
    public boolean update(Room room) { // check method (ID must be always equal index)
        int roomId = room.getIdFacility();
        readAll().set(roomId, room);
        return true;
    }

    @Override
    public boolean delete(int id) {
        readAll().remove(id);
        return true;
    }

    @Override
    public List<Room> readAllRoomsSortByPrice() {
        return readAll().stream().sorted(new RoomComparatorByPrice()).toList();
    }

    @Override
    public List<Room> readAllRoomsSortByCapacity() {
        return readAll().stream().sorted(new RoomComparatorByCapacity()).toList();
    }

    @Override
    public List<Room> readAllRoomsSortByLevel() {
        return readAll().stream().sorted(new RoomComparatorByLevel()).toList();
    }
}
