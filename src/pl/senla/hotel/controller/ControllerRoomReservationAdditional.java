package pl.senla.hotel.controller;

import pl.senla.hotel.entity.RoomReservation;

import java.time.LocalDateTime;
import java.util.List;

public interface ControllerRoomReservationAdditional {

    List<RoomReservation> readAllRoomReservationsSortByGuestName();
    List<RoomReservation> readAllRoomReservationsSortByGuestCheckOut();
    int countNumberOfGuestsOnDate(LocalDateTime checkedTime);

}
