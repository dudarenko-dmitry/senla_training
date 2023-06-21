package pl.senla.hotel.repository;

import pl.senla.hotel.entity.RoomReservation;

import java.time.LocalDateTime;
import java.util.List;

public interface RepositoryRoomReservationAdditional {

    List<RoomReservation> readAllRoomReservationsSortByGuestName();
    List<RoomReservation> readAllRoomReservationsSortByGuestCheckOut();
    int countNumberOfGuestsOnDate(LocalDateTime checkedTime);
    int countGuestPaymentForRoom(int idGuest);
}
