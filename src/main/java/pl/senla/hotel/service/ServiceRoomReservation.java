package pl.senla.hotel.service;

import pl.senla.hotel.dto.HotelServiceCreateDto;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.HotelService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ServiceRoomReservation extends ServiceCRUDALL<HotelService, HotelServiceCreateDto> {

    List<HotelService> readAllRoomReservationsSortByGuestName();
    List<HotelService> readAllRoomReservationsSortByGuestCheckOut();
    Integer countNumberOfGuestsOnDate(String checkedTimeString);
    Integer countGuestPaymentForRoom(Integer idGuest);
    List<String> read3LastGuestAndDatesForRoom(Integer idRoom) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    List<Room> readAllRoomsFreeOnDate(String checkedTimeString);
    Integer countFreeRoomsInTime(String checkedTimeString);
    List<Room> readAllFreeRoomsSortByPrice(String checkedTimeString);
    List<Room> readAllFreeRoomsSortByCapacity(String checkedTimeString);
    List<Room> readAllFreeRoomsSortByLevel(String checkedTimeString);

    List<HotelService> readAllServicesSortByDate();

    List<HotelService> readAllServicesSortByCost();

    List<HotelService> findServicesForOrder(Integer idOrder);
}
