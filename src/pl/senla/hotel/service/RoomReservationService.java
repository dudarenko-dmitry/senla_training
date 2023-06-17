package pl.senla.hotel.service;

import pl.senla.hotel.entity.RoomReservation;
import pl.senla.hotel.repository.Repository;
import pl.senla.hotel.repository.RoomReservationRepositoryCollection;

import java.util.List;

import static pl.senla.hotel.constant.RoomReservationConstant.*;

public class RoomReservationService implements Service<RoomReservation> {

    private final Repository<RoomReservation> roomReservationRepository = new RoomReservationRepositoryCollection();

    @Override
    public List<RoomReservation> readAll() {
        if(roomReservationRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM_RESERVATION);
        }
        return roomReservationRepository.readAll();
    }

    @Override
    public boolean create(RoomReservation reservation) {
        if(reservation.getClient() == null){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT);
            return false;
        } else if(reservation.getRoom() == null){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_ROOM);
            return false;
        } else if(roomReservationRepository.read(reservation.getIdHotelService()) != null){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION);
            return false;
        }
        return roomReservationRepository.create(reservation);
    }

    @Override
    public RoomReservation read(int id) {
        if(roomReservationRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM_RESERVATION);
            return null;
        } else if(roomReservationRepository.read(id) == null){
            System.out.println(ERROR_READ_ROOM_RESERVATION);
            return null;
        }
        return roomReservationRepository.read(id);
    }

    @Override
    public boolean update(RoomReservation reservation) {
        if(roomReservationRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM_RESERVATION);
            return false;
        } else if(roomReservationRepository.read(reservation.getIdHotelService()) == null){
            System.out.println(ERROR_READ_ROOM_RESERVATION);
            return false;
        }
        return roomReservationRepository.update(reservation);
    }

    @Override
    public boolean delete(int id) {
        if(roomReservationRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM_RESERVATION);
            return false;
        } else if(roomReservationRepository.read(id) == null){
            System.out.println(ERROR_READ_ROOM_RESERVATION);
            return false;
        }
        return roomReservationRepository.delete(id);
    }
}
