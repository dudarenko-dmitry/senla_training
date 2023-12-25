package pl.senla.hotel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.senla.hotel.dto.HotelServiceDto;
import pl.senla.hotel.dto.RoomDto;
import pl.senla.hotel.service.ServiceRoomReservation;
import pl.senla.hotel.utils.HotelServiceDtoMapperUtil;
import pl.senla.hotel.utils.RoomDtoMapperUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/reservations")
@Slf4j
public class ControllerRoomReservationSpring implements ControllerRoomReservation {

    @Autowired
    private ServiceRoomReservation roomReservationService;

    @Override
    @GetMapping("/")
    public List<HotelServiceDto> readAll() {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAll'.");
        return roomReservationService.readAll()
                .stream()
                .map(HotelServiceDtoMapperUtil::convertHotelServiceToHotelServiceDto)
                .toList();
    }

    @Override
    public HotelServiceDto create(HotelServiceDto hotelServiceDto) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'create'.");
        return HotelServiceDtoMapperUtil
                .convertHotelServiceToHotelServiceDto(roomReservationService.create(hotelServiceDto));
    }

    @Override
    @GetMapping("/{id}")
    public HotelServiceDto read(@PathVariable int id) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'read'.");
        return HotelServiceDtoMapperUtil
                .convertHotelServiceToHotelServiceDto(roomReservationService.read(id));
    }

    @Override
    @PutMapping("/{id}")
    public HotelServiceDto update(@PathVariable int id, @RequestBody HotelServiceDto hotelServiceDtoNew) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'update'.");
        return HotelServiceDtoMapperUtil
                .convertHotelServiceToHotelServiceDto(roomReservationService.update(id, hotelServiceDtoNew));
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'delete'.");
        roomReservationService.delete(id);
    }

    @Override
    @GetMapping("/free-rooms/{time}/sort=price")
    public List<RoomDto> readAllFreeRoomsSortByPrice(@PathVariable String time) {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAllFreeRoomsSortByPrice'.");
        return roomReservationService.readAllFreeRoomsSortByPrice(time)
                .stream()
                .map(RoomDtoMapperUtil::convertRoomToRoomDto)
                .toList();
    }

    @Override
    @GetMapping("/free-rooms/{time}/sort=capacity")
    public List<RoomDto> readAllFreeRoomsSortByCapacity(@PathVariable String time) {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAllFreeRoomsSortByCapacity'.");
        return roomReservationService.readAllFreeRoomsSortByCapacity(time)
                .stream()
                .map(RoomDtoMapperUtil::convertRoomToRoomDto)
                .toList();
    }

    @Override
    @GetMapping("/free-rooms/{time}/sort=level")
    public List<RoomDto> readAllFreeRoomsSortByLevel(@PathVariable String time) {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAllFreeRoomsSortByLevel'.");
        return roomReservationService.readAllFreeRoomsSortByLevel(time)
                .stream()
                .map(RoomDtoMapperUtil::convertRoomToRoomDto)
                .toList();
    }

    @Override
    @GetMapping("/sort-guest-name")
    public List<HotelServiceDto> readAllRoomReservationsSortByGuestName() {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAllRoomReservationsSortByGuestName'.");
        return roomReservationService.readAllRoomReservationsSortByGuestName()
                .stream()
                .map(HotelServiceDtoMapperUtil::convertHotelServiceToHotelServiceDto)
                .toList();
    }

    @Override
    @GetMapping("?sort=check_out")
    public List<HotelServiceDto> readAllRoomReservationsSortByGuestCheckOut() {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAllRoomReservationsSortByGuestCheckOut'.");
        return roomReservationService.readAllRoomReservationsSortByGuestCheckOut()
                .stream()
                .map(HotelServiceDtoMapperUtil::convertHotelServiceToHotelServiceDto)
                .toList();
    }

    @Override
    @GetMapping("/free-rooms/count")
    public int countFreeRoomsInTime(String checkedTimeString) {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'countFreeRoomsInTime'.");
        return roomReservationService.countFreeRoomsInTime(checkedTimeString);
    }

    @Override
    @GetMapping("/guests-number/{}")
    public int countNumberOfGuestsOnDate(@PathVariable String time) {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'countNumberOfGuestsOnDate'.");
        return roomReservationService.countNumberOfGuestsOnDate(time);
    }

    @Override
    @GetMapping("/free-rooms/{time}")
    public List<RoomDto> readAllRoomsFreeInTime(@PathVariable String time) {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAllRoomsFreeInTime'.");
        return roomReservationService.readAllRoomsFreeOnDate(time)
                .stream()
                .map(RoomDtoMapperUtil::convertRoomToRoomDto)
                .toList();
    }

    @Override
    @GetMapping("/guest-payment/{id}")
    public int countGuestPaymentForRoom(@PathVariable int idGuest) {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'countGuestPaymentForRoom'.");
        return roomReservationService.countGuestPaymentForRoom(idGuest);
    }

    @Override
    @GetMapping("/rooms-last-reservations/{id}")
    public List<String> read3LastGuestAndDatesForRoom(@PathVariable int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'read3LastGuestAndDatesForRoom'.");
        return roomReservationService.read3LastGuestAndDatesForRoom(idRoom);
    }

    @Override
    @GetMapping("?sort=check_in")
    public List<HotelServiceDto> readAllServicesSortByDate() {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAllServicesSortByDate'.");
        return roomReservationService.readAllServicesSortByDate()
                .stream()
                .map(HotelServiceDtoMapperUtil::convertHotelServiceToHotelServiceDto)
                .toList();
    }

    @Override
    @GetMapping("?sort=price")
    public List<HotelServiceDto> readAllServicesSortByPrice() {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAllServicesSortByPrice'.");
        return roomReservationService.readAllServicesSortByPrice()
                .stream()
                .map(HotelServiceDtoMapperUtil::convertHotelServiceToHotelServiceDto)
                .toList();
    }

    @Override
    public List<HotelServiceDto> readAllServicesForOrder(int idOrder) {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'findServicesForOrder'.");
        return roomReservationService.findServicesForOrder(idOrder)
                .stream()
                .map(HotelServiceDtoMapperUtil::convertHotelServiceToHotelServiceDto)
                .toList();
    }

}
