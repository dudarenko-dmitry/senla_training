package pl.senla.hotel.repository;

import pl.senla.hotel.entity.services.FreeRoom;
import pl.senla.hotel.comparators.FreeRoomComparatorByCapacity;
import pl.senla.hotel.comparators.FreeRoomComparatorByLevel;
import pl.senla.hotel.comparators.FreeRoomComparatorByPrice;
import pl.senla.hotel.storage.DataStorage;
import pl.senla.hotel.storage.DataStorageFreeRoom;

import java.time.LocalDateTime;
import java.util.List;

public class RepositoryFreeRoomCollection implements RepositoryFreeRoom{

    private final DataStorage<FreeRoom> dataStorageFreeRoom;

    public RepositoryFreeRoomCollection() {
        this.dataStorageFreeRoom = DataStorageFreeRoom.getDataStorageFreeRoom();
    }

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

    public int countFreeRoomsOnTime(LocalDateTime checkedDateTime) {
        return (int) readAll()
                .stream()
                .filter(fr -> checkedDateTime.isAfter(fr.getStartTime()) && checkedDateTime.isBefore(fr.getEndTime().plusDays(1)))
                .count();
    }

    @Override
    public List<FreeRoom> readAllRoomsFreeAtTime(LocalDateTime checkedTime) {
        return readAll()
                .stream()
                .filter(fr -> fr.getStartTime().isBefore(checkedTime) &&
                        fr.getEndTime().isAfter(checkedTime))
                .toList();
    }
}
