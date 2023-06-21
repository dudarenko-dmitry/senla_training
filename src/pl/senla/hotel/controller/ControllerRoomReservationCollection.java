package pl.senla.hotel.controller;

import pl.senla.hotel.entity.FreeRoom;
import pl.senla.hotel.service.ServiceRoomReservationImpl;
import pl.senla.hotel.entity.RoomReservation;
import pl.senla.hotel.service.ServiceRoomReservation;

import java.util.List;

public class ControllerRoomReservationCollection implements ControllerRoomReservation {

    private final ServiceRoomReservation roomReservationService = new ServiceRoomReservationImpl();

    @Override
    public List<RoomReservation> readAll() {
        return roomReservationService.readAll();
    }

    @Override
    public boolean create(RoomReservation reservation) {
        return roomReservationService.create(reservation);
    }

    @Override
    public RoomReservation read(int id) {
        return roomReservationService.read(id);
    }

    @Override
    public boolean update(RoomReservation reservation) {
        return roomReservationService.update(reservation);
    }

    @Override
    public boolean delete(int id) {
        return roomReservationService.delete(id);
    }

    @Override
    public List<FreeRoom> readAllFreeRooms() {
        return roomReservationService.readAllFreeRooms();
    }

    @Override
    public boolean createFreeRoom(FreeRoom freeRoom) {
        return roomReservationService.createFreeRoom(freeRoom);
    }

    @Override
    public FreeRoom readFreeRoom(int id) {
        return roomReservationService.readFreeRoom(id);
    }

    @Override
    public boolean updateFreeRoom(FreeRoom freeRoom) {
        return roomReservationService.updateFreeRoom(freeRoom);
    }

    @Override
    public boolean deleteFreeRoom(int id) {
        return roomReservationService.deleteFreeRoom(id);
    }

    @Override
    public List<FreeRoom> readAllFreeRoomsSortByPrice() {
        return roomReservationService.readAllFreeRoomsSortByPrice();
    }

    @Override
    public List<FreeRoom> readAllFreeRoomsSortByCapacity() {
        return roomReservationService.readAllFreeRoomsSortByCapacity();
    }

    @Override
    public List<FreeRoom> readAllFreeRoomsSortByLevel() {
        return roomReservationService.readAllFreeRoomsSortByLevel();
    }
}
