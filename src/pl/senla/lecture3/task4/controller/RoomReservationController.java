package pl.senla.lecture3.task4.controller;

import pl.senla.lecture3.task4.entity.RoomReservation;
import pl.senla.lecture3.task4.service.RoomReservationService;
import pl.senla.lecture3.task4.service.Service;

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
