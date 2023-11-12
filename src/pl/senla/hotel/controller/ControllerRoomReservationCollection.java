package pl.senla.hotel.controller;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.service.ServiceRoomReservation;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@AppComponent
public class ControllerRoomReservationCollection implements ControllerRoomReservation {

    @GetInstance(beanName = "ServiceRoomReservationImpl")
    private ServiceRoomReservation roomReservationService;

    public ControllerRoomReservationCollection() {}

    @Override
    public List<RoomReservation> readAll() {
        return roomReservationService.readAll();
    }

    @Override
    public boolean create(String reservationString) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        return roomReservationService.create(reservationString);
    }

    @Override
    public RoomReservation read(int idReservation) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        return roomReservationService.read(idReservation);
    }

    @Override
    public boolean update(int idReservation, String reservationString) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        return roomReservationService.update(idReservation, reservationString);
    }

    @Override
    public boolean delete(int idReservation) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
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
    public List<String> read3LastGuestAndDatesForRoom(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        return roomReservationService.read3LastGuestAndDatesForRoom(idRoom);
    }


    @Override
    public List<HotelService> readAllServicesSortByDate() {
        return roomReservationService.readAllServicesSortByDate();
    }

    @Override
    public List<HotelService> readAllServicesSortByPrice() {
        return roomReservationService.readAllServicesSortByPrice();
    }

}
