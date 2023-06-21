package pl.senla.hotel.service;

import pl.senla.hotel.entity.*;
import pl.senla.hotel.repository.RepositoryFreeRoom;
import pl.senla.hotel.repository.RepositoryFreeRoomCollection;
import pl.senla.hotel.repository.RepositoryRoomReservation;
import pl.senla.hotel.repository.RepositoryRoomReservationCollection;

import java.util.List;

import static pl.senla.hotel.constant.FreeRoomConstant.ERROR_READ_ALL_FREE_ROOM;
import static pl.senla.hotel.constant.RoomReservationConstant.*;

public class ServiceRoomReservationImpl implements ServiceRoomReservation {

    private final RepositoryRoomReservation roomReservationRepository = new RepositoryRoomReservationCollection();
    private final RepositoryFreeRoom freeRoomRepository = new RepositoryFreeRoomCollection();

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
        } else if(roomReservationRepository.read(reservation.getIdRoomReservation()) != null){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION);
            return false;
//
//           create check if room is FREE at this period of time
//           create check if room is FREE at this period of time
//           create check if room is FREE at this period of time
//           create check if room is FREE at this period of time
//           create check if room is FREE at this period of time

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
        }
        return roomReservationRepository.read(id);
    }

    @Override
    public boolean update(RoomReservation reservation) {
        if(roomReservationRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM_RESERVATION);
            return false;
        } else if(roomReservationRepository.read(reservation.getIdRoomReservation()) == null){
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

    @Override
    public List<FreeRoom> readAllFreeRooms() {
        if(freeRoomRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_FREE_ROOM);
        }
        return freeRoomRepository.readAll();
    }

    @Override
    public boolean createFreeRoom(FreeRoom freeRoom) {
        return freeRoomRepository.create(freeRoom);
    }

    @Override
    public FreeRoom readFreeRoom(int id) {
        return freeRoomRepository.read(id);
    }

    @Override
    public boolean updateFreeRoom(FreeRoom freeRoom) {
        return freeRoomRepository.update(freeRoom);
    }

    @Override
    public boolean deleteFreeRoom(int id) {
        return delete(id);
    }

    @Override
    public List<FreeRoom> readAllFreeRoomsSortByPrice() {
        return freeRoomRepository.readAllFreeRoomsSortByPrice();
    }

    @Override
    public List<FreeRoom> readAllFreeRoomsSortByCapacity() {
        return freeRoomRepository.readAllFreeRoomsSortByCapacity();
    }

    @Override
    public List<FreeRoom> readAllFreeRoomsSortByLevel() {
        return freeRoomRepository.readAllFreeRoomsSortByLevel();
    }
}
