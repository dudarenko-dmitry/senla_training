package pl.senla.hotel.repository;


import pl.senla.hotel.entity.*;
import pl.senla.hotel.storage.DataStorage;
import pl.senla.hotel.storage.DataStorageRoomReservation;

import java.time.LocalDate;
import java.util.List;

public class RepositoryRoomReservationCollection implements RepositoryRoomReservation {

    private final DataStorage<RoomReservation> dataStorageRoomReservation = new DataStorageRoomReservation();

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
    public RoomReservation read(int id) {
        RoomReservation reservation = null;
        for(RoomReservation rr : readAll()){
            if(id == rr.getIdRoomReservation()){
                reservation = rr;
                break;
            }
        }
        return reservation;
    }

    @Override
    public boolean update(RoomReservation roomReservation) {
        int id = roomReservation.getIdRoomReservation();
        readAll().set(id, roomReservation);
        return true;
    }

    @Override
    public boolean delete(int id) {
        readAll().remove(id);
        return true;
    }

    @Override
    public List<RoomReservation> readAllRoomReservationsSortByGuestName() {
        return readAll().stream().sorted(new RoomReservationsComparatorByGuestName()).toList();
    }

    @Override
    public List<RoomReservation> readAllRoomReservationsSortByGuestCheckOut() {
        return readAll().stream().sorted(new RoomReservationsComparatorByCheckOut()).toList();
    }
}
