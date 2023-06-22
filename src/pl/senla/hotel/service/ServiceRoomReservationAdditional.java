package pl.senla.hotel.service;

import pl.senla.hotel.entity.RoomReservation;

import java.time.LocalDateTime;
import java.util.List;

public interface ServiceRoomReservationAdditional {

    List<RoomReservation> readAllRoomReservationsSortByGuestName();
    List<RoomReservation> readAllRoomReservationsSortByGuestCheckOut();
    int countNumberOfGuestsOnDate(LocalDateTime checkedTime);
    int countGuestPaymentForRoom(int idGuest);
    List<String> read3LastGuestAndDatesForRoom(int idRoom);

}
