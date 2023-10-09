package pl.senla.hotel.repository;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.storage.DataStorage;

import java.util.List;

@AppComponent
public class RepositoryRoomCollection implements Repository<Room> {

    private static Repository<Room> repositoryRoom;
    @GetInstance(beanName = "DataStorageRoom")
    private final DataStorage<Room> dataStorage;

    private RepositoryRoomCollection(DataStorage<Room> dataStorage) {
        this.dataStorage = dataStorage;
    }

    public static Repository<Room> getSingletonInstance(DataStorage<Room> dataStorage){
        if(repositoryRoom == null){
            repositoryRoom = new RepositoryRoomCollection(dataStorage);
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
