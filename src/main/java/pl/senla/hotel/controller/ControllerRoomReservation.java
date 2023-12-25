package pl.senla.hotel.controller;

import pl.senla.hotel.dto.HotelServiceDto;
import pl.senla.hotel.dto.RoomDto;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ControllerRoomReservation extends ControllerCRUDALL<HotelServiceDto>{

    List<HotelServiceDto> readAllRoomReservationsSortByGuestName();
    List<HotelServiceDto> readAllRoomReservationsSortByGuestCheckOut();
    int countNumberOfGuestsOnDate(String checkedTimeString);
    int countGuestPaymentForRoom(int idGuest);
    List<String> read3LastGuestAndDatesForRoom(int idRoom) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    List<RoomDto> readAllFreeRoomsSortByPrice(String checkedTimeString);
    List<RoomDto> readAllFreeRoomsSortByCapacity(String checkedTimeString);
    List<RoomDto> readAllFreeRoomsSortByLevel(String checkedTimeString);
    int countFreeRoomsInTime(String checkedTimeString);
    List<RoomDto> readAllRoomsFreeInTime(String checkedTimeString);

    List<HotelServiceDto> readAllServicesSortByDate();
    List<HotelServiceDto> readAllServicesSortByPrice();

    List<HotelServiceDto> readAllServicesForOrder(int idOrder);
}
