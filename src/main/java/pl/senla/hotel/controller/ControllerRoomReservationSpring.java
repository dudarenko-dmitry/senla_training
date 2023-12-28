package pl.senla.hotel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.senla.hotel.dto.HotelServiceCreateDto;
import pl.senla.hotel.dto.HotelServiceReadDto;
import pl.senla.hotel.dto.RoomDto;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.service.ServiceRoomReservation;
import pl.senla.hotel.utils.HotelServiceReadDtoMapperUtil;
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
    @GetMapping
    public List<HotelServiceReadDto> readAll() {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAll'.");
        return roomReservationService.readAll()
                .stream()
                .map(HotelServiceReadDtoMapperUtil::convertHotelServiceToHotelServiceDto)
                .toList();
    }

    @Override
    @PostMapping("/")
    public HotelServiceReadDto create(@RequestBody HotelServiceCreateDto hotelServiceDto) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'create'.");
        HotelService hotelService = roomReservationService.create(hotelServiceDto);
        return HotelServiceReadDtoMapperUtil
                .convertHotelServiceToHotelServiceDto(hotelService);
    }

    @Override
    @GetMapping("/{id}")
    public HotelServiceReadDto read(@PathVariable Integer id) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'read'.");
        return HotelServiceReadDtoMapperUtil
                .convertHotelServiceToHotelServiceDto(roomReservationService.read(id));
    }

    @Override
    @PutMapping("/{id}")
    public HotelServiceReadDto update(@PathVariable Integer id, @RequestBody HotelServiceCreateDto hotelServiceDtoUpdate) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'update'.");
        return HotelServiceReadDtoMapperUtil
                .convertHotelServiceToHotelServiceDto(roomReservationService.update(id, hotelServiceDtoUpdate));
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws InvocationTargetException,
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
    public List<HotelServiceReadDto> readAllRoomReservationsSortByGuestName() {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAllRoomReservationsSortByGuestName'.");
        return roomReservationService.readAllRoomReservationsSortByGuestName()
                .stream()
                .map(HotelServiceReadDtoMapperUtil::convertHotelServiceToHotelServiceDto)
                .toList();
    }

    @Override
    @GetMapping("/sort=check_out")
    public List<HotelServiceReadDto> readAllRoomReservationsSortByGuestCheckOut() {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAllRoomReservationsSortByGuestCheckOut'.");
        return roomReservationService.readAllRoomReservationsSortByGuestCheckOut()
                .stream()
                .map(HotelServiceReadDtoMapperUtil::convertHotelServiceToHotelServiceDto)
                .toList();
    }

    @Override
    @GetMapping("/free-rooms/{time}/count")
    public Integer countFreeRoomsInTime(@PathVariable String time) {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'countFreeRoomsInTime'.");
        return roomReservationService.countFreeRoomsInTime(time);
    }

    @Override
    @GetMapping("/guests-number/{time}")
    public Integer countNumberOfGuestsOnDate(@PathVariable String time) {
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
    @GetMapping("/guest-payment/{id}") // check
    public Integer countGuestPaymentForRoom(@PathVariable Integer id) {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'countGuestPaymentForRoom'.");
        return roomReservationService.countGuestPaymentForRoom(id);
    }

    @Override
    @GetMapping("/rooms-last-reservations/{id}")
    public List<String> read3LastGuestAndDatesForRoom(@PathVariable Integer id) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'read3LastGuestAndDatesForRoom'.");
        return roomReservationService.read3LastGuestAndDatesForRoom(id);
    }

    @Override
    @GetMapping("/sort=check_in")
    public List<HotelServiceReadDto> readAllServicesSortByDate() {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAllServicesSortByDate'.");
        return roomReservationService.readAllServicesSortByDate()
                .stream()
                .map(HotelServiceReadDtoMapperUtil::convertHotelServiceToHotelServiceDto)
                .toList();
    }

    @Override
    @GetMapping("/sort=cost")
    public List<HotelServiceReadDto> readAllServicesSortByCost() {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'readAllServicesSortByPrice'.");
        return roomReservationService.readAllServicesSortByCost()
                .stream()
                .map(HotelServiceReadDtoMapperUtil::convertHotelServiceToHotelServiceDto)
                .toList();
    }

    @Override
    public List<HotelServiceReadDto> readAllServicesForOrder(Integer idOrder) {
        log.debug("ControllerRoomReservation call ServiceRoomReservation's method 'findServicesForOrder'.");
        return roomReservationService.findServicesForOrder(idOrder)
                .stream()
                .map(HotelServiceReadDtoMapperUtil::convertHotelServiceToHotelServiceDto)
                .toList();
    }

}
