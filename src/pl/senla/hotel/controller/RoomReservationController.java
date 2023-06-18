package pl.senla.hotel.controller;

import pl.senla.hotel.service.RoomReservationService;
import pl.senla.hotel.entity.RoomReservation;
import pl.senla.hotel.service.Service;

import java.util.List;

public class RoomReservationController implements Controller<RoomReservation> {

    private final Service<RoomReservation> roomReservationService = new RoomReservationService();


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
}
