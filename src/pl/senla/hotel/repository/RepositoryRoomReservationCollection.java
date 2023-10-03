package pl.senla.hotel.repository;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.storage.DataStorage;

import java.util.List;

@AppComponent
public class RepositoryRoomReservationCollection implements Repository<RoomReservation> {

    @GetInstance(beanName = "DataStorageRoomReservation")
    private DataStorage<RoomReservation> dataStorageRoomReservation;

    public RepositoryRoomReservationCollection() {}

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
