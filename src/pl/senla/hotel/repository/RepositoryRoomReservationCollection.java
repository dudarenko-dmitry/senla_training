package pl.senla.hotel.repository;

import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.storage.DataStorage;
import pl.senla.hotel.storage.DataStorageRoomReservation;

import java.util.List;

public class RepositoryRoomReservationCollection implements Repository<RoomReservation> {

    private static Repository<RoomReservation> repositoryRoomReservation;
    private final DataStorage<RoomReservation> dataStorageRoomReservation;

    private RepositoryRoomReservationCollection() {
        this.dataStorageRoomReservation = DataStorageRoomReservation.getDataStorageRoomReservation();
    }

    public static Repository<RoomReservation> getRepositoryRoomReservation(){
        if(repositoryRoomReservation == null){
            repositoryRoomReservation = new RepositoryRoomReservationCollection();
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
