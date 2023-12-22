package pl.senla.hotel.controller;

import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.HotelService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ControllerRoomReservation extends ControllerCRUDALL<HotelService>{

    List<HotelService> readAllRoomReservationsSortByGuestName();
    List<HotelService> readAllRoomReservationsSortByGuestCheckOut();
    int countNumberOfGuestsOnDate(String checkedTimeString);
    int countGuestPaymentForRoom(int idGuest);
    List<String> read3LastGuestAndDatesForRoom(int idRoom) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    List<Room> readAllFreeRoomsSortByPrice(String checkedTimeString);
    List<Room> readAllFreeRoomsSortByCapacity(String checkedTimeString);
    List<Room> readAllFreeRoomsSortByLevel(String checkedTimeString);
    int countFreeRoomsInTime(String checkedTimeString);
    List<Room> readAllRoomsFreeInTime(String checkedTimeString);

    List<HotelService> readAllServicesSortByDate();
    List<HotelService> readAllServicesSortByPrice();

    List<HotelService> readAllServicesForOrder(int idOrder);
}
