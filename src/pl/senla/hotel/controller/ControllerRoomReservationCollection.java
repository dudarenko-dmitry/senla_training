package pl.senla.hotel.controller;

import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.service.ServiceRoomReservationImpl;
import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.service.ServiceRoomReservation;

import java.util.List;

public class ControllerRoomReservationCollection implements ControllerRoomReservation {

    private static ControllerRoomReservation controllerRoomReservation;
    private final ServiceRoomReservation roomReservationService;

    private ControllerRoomReservationCollection(Configuration appConfiguration) {
        this.roomReservationService = ServiceRoomReservationImpl.getServiceRoomReservation(appConfiguration);
    }

    public static ControllerRoomReservation getControllerRoomReservation(Configuration appConfiguration){
        if(controllerRoomReservation == null){
            controllerRoomReservation = new ControllerRoomReservationCollection(appConfiguration);
        }
        return controllerRoomReservation;
    }

    @Override
    public List<RoomReservation> readAll() {
        return roomReservationService.readAll();
    }

    @Override
    public boolean create(String reservationString) {
        return roomReservationService.create(reservationString);
    }

    @Override
    public RoomReservation read(int idReservation) {
        return roomReservationService.read(idReservation);
    }

    @Override
    public boolean update(int idReservation, String reservationString) {
        return roomReservationService.update(idReservation, reservationString);
    }

    @Override
    public boolean delete(int idReservation) {
        return roomReservationService.delete(idReservation);
    }

    @Override
    public List<Room> readAllFreeRoomsSortByPrice(String checkedTimeString) {
        return roomReservationService.readAllFreeRoomsSortByPrice(checkedTimeString);
    }

    @Override
    public List<Room> readAllFreeRoomsSortByCapacity(String checkedTimeString) {
        return roomReservationService.readAllFreeRoomsSortByCapacity(checkedTimeString);
    }

    @Override
    public List<Room> readAllFreeRoomsSortByLevel(String checkedTimeString) {
        return roomReservationService.readAllFreeRoomsSortByLevel(checkedTimeString);
    }

    @Override
    public List<RoomReservation> readAllRoomReservationsSortByGuestName() {
        return roomReservationService.readAllRoomReservationsSortByGuestName();
    }

    @Override
    public List<RoomReservation> readAllRoomReservationsSortByGuestCheckOut() {
        return roomReservationService.readAllRoomReservationsSortByGuestCheckOut();
    }

    @Override
    public int countFreeRoomsInTime(String checkedTimeString) {
        return roomReservationService.countFreeRoomsInTime(checkedTimeString);
    }

    @Override
    public int countNumberOfGuestsOnDate(String checkedTimeString) {
        return roomReservationService.countNumberOfGuestsOnDate(checkedTimeString);
    }

    @Override
    public List<Room> readAllRoomsFreeInTime(String checkedTimeString) {
        return roomReservationService.readAllRoomsFreeInTime(checkedTimeString);
    }

    @Override
    public int countGuestPaymentForRoom(int idGuest) {
        return roomReservationService.countGuestPaymentForRoom(idGuest);
    }

    @Override
    public List<String> read3LastGuestAndDatesForRoom(int idRoom) {
        return roomReservationService.read3LastGuestAndDatesForRoom(idRoom);
    }
}
