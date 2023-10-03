package pl.senla.hotel.repository;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.storage.DataStorage;

import java.util.List;

@AppComponent
public class RepositoryRoomCollection implements Repository<Room> {

    @GetInstance(beanName = "DataStorageRoom")
    private DataStorage<Room> dataStorage;

    public RepositoryRoomCollection() {}

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
