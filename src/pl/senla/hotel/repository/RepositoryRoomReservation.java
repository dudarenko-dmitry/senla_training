package pl.senla.hotel.repository;

import pl.senla.hotel.entity.services.RoomReservation;

import java.time.LocalDateTime;
import java.util.List;

public interface RepositoryRoomReservation extends RepositoryCRUDALL<RoomReservation> {

    List<RoomReservation> readAllRoomReservationsSortByGuestName();
    List<RoomReservation> readAllRoomReservationsSortByGuestCheckOut();
    int countNumberOfGuestsOnDate(LocalDateTime checkedTime);
    int countGuestPaymentForRoom(int idGuest);
    List<String> read3LastGuestAndDatesForRoom(int idRoom);
}
