package pl.senla.hotel.repository;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.storage.DataStorage;

import java.util.List;

@AppComponent
public class RepositoryRoomReservationCollection implements Repository<RoomReservation> {

    private static Repository<RoomReservation> repositoryRoomReservation;
    @GetInstance(beanName = "DataStorageRoomReservation")
    private final DataStorage<RoomReservation> dataStorageRoomReservation;

    private RepositoryRoomReservationCollection(DataStorage<RoomReservation> dataStorageRoomReservation) {
        this.dataStorageRoomReservation = dataStorageRoomReservation;
    }

    public static Repository<RoomReservation> getSingletonInstance(DataStorage<RoomReservation> dataStorageRoomReservation){
        if(repositoryRoomReservation == null){
            repositoryRoomReservation = new RepositoryRoomReservationCollection(dataStorageRoomReservation);
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
