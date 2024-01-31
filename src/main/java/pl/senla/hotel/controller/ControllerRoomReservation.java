package pl.senla.hotel.controller;

import pl.senla.hotel.dto.HotelServiceCreateDto;
import pl.senla.hotel.dto.HotelServiceReadDto;
import pl.senla.hotel.dto.RoomDto;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ControllerRoomReservation extends ControllerCRUDALL<HotelServiceReadDto, HotelServiceCreateDto>{

    List<HotelServiceReadDto> readAllRoomReservationsSortByGuestName();
    List<HotelServiceReadDto> readAllRoomReservationsSortByGuestCheckOut();
    Integer countNumberOfGuestsOnDate(String checkedTimeString);
    Integer countGuestPaymentForRoom(Integer idGuest);
    List<String> read3LastGuestAndDatesForRoom(Integer idRoom) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    List<RoomDto> readAllFreeRoomsSortByPrice(String checkedTimeString);
    List<RoomDto> readAllFreeRoomsSortByCapacity(String checkedTimeString);
    List<RoomDto> readAllFreeRoomsSortByLevel(String checkedTimeString);
    Integer countFreeRoomsInTime(String checkedTimeString);
    List<RoomDto> readAllRoomsFreeInTime(String checkedTimeString, String sortBy);

    List<HotelServiceReadDto> readAllServicesSortByDate();
    List<HotelServiceReadDto> readAllServicesSortByCost();

    List<HotelServiceReadDto> readAllServicesForOrder(Integer idOrder);
}
