package pl.senla.hotel.controller;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.service.ServiceRoomReservation;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@AppComponent
public class ControllerRoomReservationDB implements ControllerRoomReservation {

    @GetInstance(beanName = "ServiceRoomReservationDB")
    private ServiceRoomReservation roomReservationService;

    public ControllerRoomReservationDB() {}

    @Override
    public List<HotelService> readAll() {
        return roomReservationService.readAll();
    }

    @Override
    public boolean create(String reservationString) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        return roomReservationService.create(reservationString);
    }

    @Override
    public HotelService read(int idReservation) throws InvocationTargetException,
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
    public List<HotelFacility> readAllFreeRoomsSortByPrice(String checkedTimeString) {
        return roomReservationService.readAllFreeRoomsSortByPrice(checkedTimeString);
    }

    @Override
    public List<HotelFacility> readAllFreeRoomsSortByCapacity(String checkedTimeString) {
        return roomReservationService.readAllFreeRoomsSortByCapacity(checkedTimeString);
    }

    @Override
    public List<HotelFacility> readAllFreeRoomsSortByLevel(String checkedTimeString) {
        return roomReservationService.readAllFreeRoomsSortByLevel(checkedTimeString);
    }

    @Override
    public List<HotelService> readAllRoomReservationsSortByGuestName() {
        return roomReservationService.readAllRoomReservationsSortByGuestName();
    }

    @Override
    public List<HotelService> readAllRoomReservationsSortByGuestCheckOut() {
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
    public List<HotelFacility> readAllRoomsFreeInTime(String checkedTimeString) {
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
