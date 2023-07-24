package pl.senla.hotel.repository;

import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.storage.DataStorage;
import pl.senla.hotel.storage.DataStorageRoom;

import java.util.List;

public class RepositoryRoomCollection implements RepositoryRoom {

    private static RepositoryRoom repositoryRoom;
    private final DataStorage<Room> dataStorage;

    private RepositoryRoomCollection() {
        this.dataStorage = DataStorageRoom.getDataStorageRoom();
    }

    public static RepositoryRoom getRepositoryRoom(){
        if(repositoryRoom == null){
            repositoryRoom = new RepositoryRoomCollection();
            System.out.println("Repository for Room was created.");
        }
        return repositoryRoom;
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
    public Room read(int idRoom) {
        return dataStorage.getDataList().get(idRoom);
    }

    @Override
    public boolean update(int idRoom, Room room) {
        readAll().set(idRoom, room);
        return true;
    }

    @Override
    public boolean delete(int idRoom) {
        readAll().remove(idRoom);
        return true;
    }

}
