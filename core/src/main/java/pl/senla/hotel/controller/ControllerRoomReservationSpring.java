package pl.senla.hotel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.service.ServiceRoomReservation;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Controller
@Slf4j
public class ControllerRoomReservationSpring implements ControllerRoomReservation {

    @Autowired
    private ServiceRoomReservation roomReservationService;

    @Override
    public List<HotelService> readAll() {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAll'.");
        return roomReservationService.readAll();
    }

    @Override
    public HotelService create(String reservationString) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'create'.");
        return roomReservationService.create(reservationString);
    }

    @Override
    public HotelService read(int idReservation) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'read'.");
        return roomReservationService.read(idReservation);
    }

    @Override
    public HotelService update(int idReservation, String reservationString) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'update'.");
        return roomReservationService.update(idReservation, reservationString);
    }

    @Override
    public void delete(int idReservation) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'delete'.");
        roomReservationService.delete(idReservation);
    }

    @Override
    public List<Room> readAllFreeRoomsSortByPrice(String checkedTimeString) {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAllFreeRoomsSortByPrice'.");
        return roomReservationService.readAllFreeRoomsSortByPrice(checkedTimeString);
    }

    @Override
    public List<Room> readAllFreeRoomsSortByCapacity(String checkedTimeString) {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAllFreeRoomsSortByCapacity'.");
        return roomReservationService.readAllFreeRoomsSortByCapacity(checkedTimeString);
    }

    @Override
    public List<Room> readAllFreeRoomsSortByLevel(String checkedTimeString) {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAllFreeRoomsSortByLevel'.");
        return roomReservationService.readAllFreeRoomsSortByLevel(checkedTimeString);
    }

    @Override
    public List<HotelService> readAllRoomReservationsSortByGuestName() {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAllRoomReservationsSortByGuestName'.");
        return roomReservationService.readAllRoomReservationsSortByGuestName();
    }

    @Override
    public List<HotelService> readAllRoomReservationsSortByGuestCheckOut() {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAllRoomReservationsSortByGuestCheckOut'.");
        return roomReservationService.readAllRoomReservationsSortByGuestCheckOut();
    }

    @Override
    public int countFreeRoomsInTime(String checkedTimeString) {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'countFreeRoomsInTime'.");
        return roomReservationService.countFreeRoomsInTime(checkedTimeString);
    }

    @Override
    public int countNumberOfGuestsOnDate(String checkedTimeString) {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'countNumberOfGuestsOnDate'.");
        return roomReservationService.countNumberOfGuestsOnDate(checkedTimeString);
    }

    @Override
    public List<Room> readAllRoomsFreeInTime(String checkedTimeString) {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAllRoomsFreeInTime'.");
        return roomReservationService.readAllRoomsFreeInTime(checkedTimeString);
    }

    @Override
    public int countGuestPaymentForRoom(int idGuest) {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'countGuestPaymentForRoom'.");
        return roomReservationService.countGuestPaymentForRoom(idGuest);
    }

    @Override
    public List<String> read3LastGuestAndDatesForRoom(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'read3LastGuestAndDatesForRoom'.");
        return roomReservationService.read3LastGuestAndDatesForRoom(idRoom);
    }

    @Override
    public List<HotelService> readAllServicesSortByDate() {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAllServicesSortByDate'.");
        return roomReservationService.readAllServicesSortByDate();
    }

    @Override
    public List<HotelService> readAllServicesSortByPrice() {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAllServicesSortByPrice'.");
        return roomReservationService.readAllServicesSortByPrice();
    }

}
