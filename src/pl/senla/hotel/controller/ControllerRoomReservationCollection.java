package pl.senla.hotel.controller;

import pl.senla.hotel.entity.Room;
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
    public List<Room> readAllFreeRoomsSortByPrice() {
        return roomReservationService.readAllFreeRoomsSortByPrice();
    }

    @Override
    public List<Room> readAllFreeRoomsSortByCapacity() {
        return roomReservationService.readAllFreeRoomsSortByCapacity();
    }

    @Override
    public List<Room> readAllFreeRoomsSortByLevel() {
        return roomReservationService.readAllFreeRoomsSortByLevel();
    }
}
