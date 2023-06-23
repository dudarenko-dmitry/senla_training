package pl.senla.hotel.controller;

import pl.senla.hotel.entity.FreeRoom;
import pl.senla.hotel.entity.RoomReservation;

import java.time.LocalDateTime;
import java.util.List;

public interface ControllerRoomReservation extends ControllerCRUDALL<RoomReservation>,
        ControllerFreeRoomCRUDALL {

    List<RoomReservation> readAllRoomReservationsSortByGuestName();
    List<RoomReservation> readAllRoomReservationsSortByGuestCheckOut();
    int countNumberOfGuestsOnDate(LocalDateTime checkedTime);
    int countGuestPaymentForRoom(int idGuest);
    List<String> read3LastGuestAndDatesForRoom(int idRoom);

    List<FreeRoom> readAllFreeRoomsSortByPrice();
    List<FreeRoom> readAllFreeRoomsSortByCapacity();
    List<FreeRoom> readAllFreeRoomsSortByLevel();
    int countFreeRoomsOnTime(LocalDateTime checkedDateTime);
    List<FreeRoom> readAllRoomsFreeAtTime(LocalDateTime checkedTime);
}
