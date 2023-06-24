package pl.senla.hotel.service;

import pl.senla.hotel.entity.services.FreeRoom;
import pl.senla.hotel.entity.services.RoomReservation;

import java.time.LocalDateTime;
import java.util.List;

public interface ServiceRoomReservation extends ServiceCRUDALL<RoomReservation>,
        ServiceFreeRoomCRUDALL {

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
