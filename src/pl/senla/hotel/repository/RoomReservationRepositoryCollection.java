package pl.senla.hotel.repository;


import pl.senla.hotel.entity.RoomReservation;
import pl.senla.hotel.storage.DataStorageRoomReservation;

import java.util.List;

public class RoomReservationRepositoryCollection implements Repository<RoomReservation>{

    private final DataStorageRoomReservation dataStorageRoomReservation = new DataStorageRoomReservation();

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
}
