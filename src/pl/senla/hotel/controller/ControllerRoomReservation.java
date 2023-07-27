package pl.senla.hotel.controller;

import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.RoomReservation;

import java.util.List;

public interface ControllerRoomReservation extends ControllerCRUDALL<RoomReservation>{

    List<RoomReservation> readAllRoomReservationsSortByGuestName();
    List<RoomReservation> readAllRoomReservationsSortByGuestCheckOut();
    int countNumberOfGuestsOnDate(String checkedTimeString);
    int countGuestPaymentForRoom(int idGuest);
    List<String> read3LastGuestAndDatesForRoom(int idRoom);

    List<Room> readAllFreeRoomsSortByPrice(String checkedTimeString);
    List<Room> readAllFreeRoomsSortByCapacity(String checkedTimeString);
    List<Room> readAllFreeRoomsSortByLevel(String checkedTimeString);
    int countFreeRoomsInTime(String checkedTimeString);
    List<Room> readAllRoomsFreeInTime(String checkedTimeString);
}
