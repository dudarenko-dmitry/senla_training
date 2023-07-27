package pl.senla.hotel.service;

import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.RoomReservation;

import java.util.List;

public interface ServiceRoomReservation extends ServiceCRUDALL<RoomReservation> {

    List<RoomReservation> readAllRoomReservationsSortByGuestName();
    List<RoomReservation> readAllRoomReservationsSortByGuestCheckOut();
    int countNumberOfGuestsOnDate(String checkedTimeString);
    int countGuestPaymentForRoom(int idGuest);
    List<String> read3LastGuestAndDatesForRoom(int idRoom);

    List<Room> readAllRoomsFreeInTime(String checkedTimeString);
    int countFreeRoomsInTime(String checkedTimeString);
    List<Room> readAllFreeRoomsSortByPrice(String checkedTimeString);
    List<Room> readAllFreeRoomsSortByCapacity(String checkedTimeString);
    List<Room> readAllFreeRoomsSortByLevel(String checkedTimeString);


}
