package pl.senla.hotel.service;

import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.services.HotelService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ServiceRoomReservation extends ServiceCRUDALL<HotelService> {

    List<HotelService> readAllRoomReservationsSortByGuestName();
    List<HotelService> readAllRoomReservationsSortByGuestCheckOut();
    int countNumberOfGuestsOnDate(String checkedTimeString);
    int countGuestPaymentForRoom(int idGuest);
    List<String> read3LastGuestAndDatesForRoom(int idRoom) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    List<HotelFacility> readAllRoomsFreeInTime(String checkedTimeString);
    int countFreeRoomsInTime(String checkedTimeString);
    List<HotelFacility> readAllFreeRoomsSortByPrice(String checkedTimeString);
    List<HotelFacility> readAllFreeRoomsSortByCapacity(String checkedTimeString);
    List<HotelFacility> readAllFreeRoomsSortByLevel(String checkedTimeString);

    List<HotelService> readAllServicesSortByDate();

    List<HotelService> readAllServicesSortByPrice();
}
