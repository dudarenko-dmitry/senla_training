package pl.senla.hotel.controller;

import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.service.ServiceRoomReservationImpl;
import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.service.ServiceRoomReservation;

import java.time.LocalDateTime;
import java.util.List;

public class ControllerRoomReservationCollection implements ControllerRoomReservation {

    private static ControllerRoomReservation controllerRoomReservation;
    private final ServiceRoomReservation roomReservationService;

    private ControllerRoomReservationCollection() {
        this.roomReservationService = ServiceRoomReservationImpl.getServiceRoomReservation();
    }

    public static ControllerRoomReservation getControllerRoomReservation(){
        if(controllerRoomReservation == null){
            controllerRoomReservation = new ControllerRoomReservationCollection();
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

    @Override
    public List<RoomReservation> readAllRoomReservationsSortByGuestName() {
        return roomReservationService.readAllRoomReservationsSortByGuestName();
    }

    @Override
    public List<RoomReservation> readAllRoomReservationsSortByGuestCheckOut() {
        return roomReservationService.readAllRoomReservationsSortByGuestCheckOut();
    }

    @Override
    public int countFreeRoomsOnTime(String checkedTimeString) {
        return roomReservationService.countFreeRoomsOnTime(checkedTimeString);
    }

    @Override
    public int countNumberOfGuestsOnDate(String checkedTimeString) {
        return roomReservationService.countNumberOfGuestsOnDate(checkedTimeString);
    }

    @Override
    public List<Room> readAllRoomsFreeAtTime(String checkedTimeString) {
        return roomReservationService.readAllRoomsFreeAtTime(checkedTimeString);
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
