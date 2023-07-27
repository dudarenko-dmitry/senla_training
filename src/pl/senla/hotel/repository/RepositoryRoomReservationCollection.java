package pl.senla.hotel.repository;

import pl.senla.hotel.entity.*;
import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.storage.DataStorage;
import pl.senla.hotel.storage.DataStorageGuest;
import pl.senla.hotel.storage.DataStorageRoomReservation;

import java.util.List;

public class RepositoryRoomReservationCollection implements RepositoryCRUDALL<RoomReservation> {

    private static RepositoryCRUDALL<RoomReservation> repositoryRoomReservation;
    private final DataStorage<RoomReservation> dataStorageRoomReservation;
    private final DataStorage<Guest> dataStorageGuest;

    private RepositoryRoomReservationCollection() {
        this.dataStorageGuest = DataStorageGuest.getDataStorageGuest();
        this.dataStorageRoomReservation = DataStorageRoomReservation.getDataStorageRoomReservation();
    }

    public static RepositoryCRUDALL<RoomReservation> getRepositoryRoomReservation(){
        if(repositoryRoomReservation == null){
            repositoryRoomReservation = new RepositoryRoomReservationCollection();
            System.out.println("Repository for RoomReservation was created.");
        }
        return repositoryRoomReservation;
    }

    @Override
    public List<RoomReservation> readAll() {
        return dataStorageRoomReservation.getDataList();
    }

    @Override
    public boolean create(RoomReservation roomReservation) {
        readAll().add(roomReservation);
        return true;
    }

    @Override
    public RoomReservation read(int index) {
        return readAll().get(index);
    }

    @Override
    public boolean update(int index, RoomReservation roomReservation) {
        readAll().set(index, roomReservation);
        return true;
    }

    @Override
    public boolean delete(int index) {
        readAll().remove(index);
        return true;
    }
}
