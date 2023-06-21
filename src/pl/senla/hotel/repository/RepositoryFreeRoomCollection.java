package pl.senla.hotel.repository;

import pl.senla.hotel.entity.FreeRoom;
import pl.senla.hotel.entity.FreeRoomComparatorByCapacity;
import pl.senla.hotel.entity.FreeRoomComparatorByLevel;
import pl.senla.hotel.entity.FreeRoomComparatorByPrice;
import pl.senla.hotel.storage.DataStorage;
import pl.senla.hotel.storage.DataStorageFreeRoom;

import java.util.List;

public class RepositoryFreeRoomCollection implements RepositoryFreeRoom{

    private final DataStorage<FreeRoom> dataStorageFreeRoom = new DataStorageFreeRoom();

    @Override
    public List<FreeRoom> readAll() {
        return dataStorageFreeRoom.getDataList();
    }

    @Override
    public boolean create(FreeRoom freeRoom) {
        return readAll().add(freeRoom);
    }

    @Override
    public FreeRoom read(int id) {
        return readAll().get(id);
    }

    @Override
    public boolean update(FreeRoom freeRoom) {
        readAll().set(freeRoom.getIdFreeRoom(), freeRoom);
        return true;
    }

    @Override
    public boolean delete(int id) {
        readAll().remove(id);
        return true;
    }

    @Override
    public List<FreeRoom> readAllFreeRoomsSortByPrice() {
        return readAll().stream().sorted(new FreeRoomComparatorByPrice()).toList();
    }

    @Override
    public List<FreeRoom> readAllFreeRoomsSortByCapacity() {
        return readAll().stream().sorted(new FreeRoomComparatorByCapacity()).toList();
    }

    @Override
    public List<FreeRoom> readAllFreeRoomsSortByLevel() {
        return readAll().stream().sorted(new FreeRoomComparatorByLevel()).toList();
    }
}
