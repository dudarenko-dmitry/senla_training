package pl.senla.hotel.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.senla.hotel.dao.DaoGuestSpring;
import pl.senla.hotel.dao.DaoHotelFacilitySpring;
import pl.senla.hotel.dao.DaoHotelServiceSpring;
import pl.senla.hotel.dao.DaoOrderSpring;
import pl.senla.hotel.dto.HotelServiceCreateDto;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.facilities.RoomStatus;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.TypeOfService;
import pl.senla.hotel.exceptions.GuestNotFoundException;
import pl.senla.hotel.exceptions.HotelServiceNotFoundException;
import pl.senla.hotel.exceptions.OrderNotFoundException;
import pl.senla.hotel.exceptions.RoomNotFoundException;
import pl.senla.hotel.utils.HotelServiceReadDtoMapperUtil;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;
import static pl.senla.hotel.constant.RoomReservationConstant.*;

@Service
@Slf4j
public class ServiceRoomReservationSpring implements ServiceRoomReservation {

    @Autowired
    private DaoHotelServiceSpring daoHotelService;
    @Autowired
    private DaoGuestSpring daoGuest;
    @Autowired
    private DaoHotelFacilitySpring daoFacility;
    @Autowired
    private DaoOrderSpring daoOrder;
    @Value("${room-records.number}")
    private Integer roomRecordsNumber;

    @Override
    public List<HotelService> readAll() {
        log.debug("START: Hotel Service ReadAll");
        List<HotelService> hotelServiceList = daoHotelService.findAll();
        if (!hotelServiceList.isEmpty()) {
            return hotelServiceList;
        }
        log.debug(ALL_ROOM_RESERVATION_IS_EMPTY);
        return hotelServiceList;
    }

    @Transactional
    @Override
    public HotelService create(HotelServiceCreateDto hotelServiceDto) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("START: Hotel Service Create");
        int idOrder = hotelServiceDto.getIdOrder();
        int idGuest = hotelServiceDto.getIdGuest();
        int idRoom = hotelServiceDto.getIdHotelFacility();
        if (daoGuest.findById(idGuest).isEmpty()) {
            log.debug(ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT);
            return null;
        } else if (daoFacility.findById(idRoom).isEmpty()) {
            log.debug(ERROR_CREATE_ROOM_RESERVATION_NO_ROOM);
            return null;
        } else if ((daoFacility.findById(idRoom)).get().getRoomStatus().equals(RoomStatus.REPAIRED)) { // edit later!!!
            log.debug(ERROR_CREATE_ROOM_RESERVATION_REPAIRED);
            return null;
        } else {
            LocalDateTime checkInTime = HotelServiceReadDtoMapperUtil
                    .convertStringToTime(hotelServiceDto.getCheckInTimeString()).plusMinutes(1);
            int numberOfDays = hotelServiceDto.getNumberOfDays();
            LocalDateTime checkOutTime = checkInTime.plusDays(numberOfDays).minusMinutes(1);
            if (isVacant(idRoom, checkInTime, checkOutTime)) {
                Order order = daoOrder.findById(idOrder)
                        .orElseThrow(() -> new OrderNotFoundException(idOrder));
                Guest guest = daoGuest.findById(idGuest)
                        .orElseThrow(() -> new GuestNotFoundException(idGuest));
                Room room = daoFacility.findById(idRoom)
                        .orElseThrow(() -> new RoomNotFoundException(idRoom));
                HotelService reservation = new HotelService();
                reservation.setOrder(order);
                reservation.setTypeOfService(TypeOfService.ROOM_RESERVATION);
                reservation.setGuest(guest);
                reservation.setRoom(room);
                reservation.setNumberOfDays(numberOfDays);
                reservation.setCheckInTime(checkInTime);
                reservation.setCheckOutTime(checkOutTime);
                reservation.setCost(room.getPrice() * numberOfDays);

                // check number of records for this room:
                List<HotelService> roomReservationList = readAll().stream()
                        .filter(rr -> rr.getRoom().getIdRoom() == idRoom)
                        .toList();
                int numberOfRecords = roomReservationList.size();
                if (numberOfRecords >= roomRecordsNumber) {
                    int idRoomReservationToDelete = roomReservationList.get(0).getIdService();
                    delete(idRoomReservationToDelete);
                }
                return daoHotelService.save(reservation);
            } else {
                log.debug(ERROR_ROOM_NOT_AVAILABLE);
                return null;
            }
        }
    }

    @Override
    public HotelService read(Integer idReservation) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("START: Hotel Service Read");
        return daoHotelService.findById(idReservation)
                .orElseThrow(() -> new HotelServiceNotFoundException(idReservation));
    }

    @Transactional
    @Override
    public HotelService update(Integer id, HotelServiceCreateDto hotelServiceDto) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("START: Hotel Service update");
        if (read(id) == null) {
            log.debug(ROOM_RESERVATION_NOT_EXISTS);
            log.debug(ERROR_INPUT);
            return null;
        }
        delete(id);

        int idOrder = hotelServiceDto.getIdOrder();
        int idGuest = hotelServiceDto.getIdGuest();
        int idRoom = hotelServiceDto.getIdHotelFacility();
        if (daoGuest.findById(idGuest).isEmpty()) {
            log.debug(ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT);
            return null;
        } else if (daoFacility.findById(idRoom).isEmpty()) {
            log.debug(ERROR_CREATE_ROOM_RESERVATION_NO_ROOM);
            return null;
        } else if ((daoFacility.findById(idRoom)).get().getRoomStatus().equals(RoomStatus.REPAIRED)) {
            log.debug(ERROR_CREATE_ROOM_RESERVATION_REPAIRED);
            return null;
        } else {
            LocalDateTime checkInTime = HotelServiceReadDtoMapperUtil
                    .convertStringToTime(hotelServiceDto.getCheckInTimeString()).plusMinutes(1);
            int numberOfDays = hotelServiceDto.getNumberOfDays();
            LocalDateTime checkOutTime = checkInTime.plusDays(numberOfDays).minusMinutes(1);
            if (isVacant(idRoom, checkInTime, checkOutTime)) {
                Order order = daoOrder.findById(idOrder)
                        .orElseThrow(() -> new OrderNotFoundException(idOrder));
                Guest guest = daoGuest.findById(idGuest)
                        .orElseThrow(() -> new GuestNotFoundException(idGuest));
                Room room = daoFacility.findById(idRoom)
                        .orElseThrow(() -> new RoomNotFoundException(idRoom));
                HotelService reservationUpdate = new HotelService();
                reservationUpdate.setOrder(order);
                reservationUpdate.setTypeOfService(TypeOfService.ROOM_RESERVATION);
                reservationUpdate.setGuest(guest);
                reservationUpdate.setRoom(room);
                reservationUpdate.setNumberOfDays(numberOfDays);
                reservationUpdate.setCheckInTime(checkInTime);
                reservationUpdate.setCheckOutTime(checkOutTime);
                reservationUpdate.setCost(room.getPrice() * numberOfDays);
                return daoHotelService.save(reservationUpdate);
            } else {
                log.debug(ERROR_ROOM_NOT_AVAILABLE);
                return null;
            }
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("START: Hotel Service delete");
        if (read(id) != null) {
            daoHotelService.deleteById(id);
        }
        log.debug(ALL_ROOM_RESERVATION_IS_EMPTY);
    }

    @Override
    public Integer countNumberOfGuestsOnDate(String checkedDateString) {
        log.debug("START: Hotel Service countNumberOfGuestsOnDate");
        return daoHotelService.countGuestOnDate(checkedDateString);
    }

    @Override // ready with guestID
    public List<HotelService> readAllRoomReservationsSortByGuestName() {
        log.debug("START: Hotel Service readAllRoomReservationsSortByGuestName");
        return daoHotelService.findAllOrderByGuestName();
    }

    @Override
    public List<HotelService> readAllRoomReservationsSortByGuestCheckOut() {
        log.debug("START: Hotel Service readAllRoomReservationsSortByGuestCheckOut");
        return daoHotelService.findByOrderByCheckOutTime();
    }

    @Override
    public Integer countGuestPaymentForRoom(Integer idGuest) {
        log.debug("START: Hotel Service countGuestPaymentForRoom");
        try {
            return daoHotelService.getSumForRoomByGuest(idGuest);
        } catch (Exception e) {
            log.info("This Guest hasn't reserved any room yet.");
            return null;
        }
    }

    @Override
    public List<String> read3LastGuestAndDatesForRoom(Integer idRoom) {
        log.debug("START: Hotel Service read3LastGuestAndDatesForRoom");
        List<String> guestsAndDates = new ArrayList<>();
        List<HotelService> roomReservationsForRoom = daoHotelService.findLast3ByRoomId(idRoom);
        System.out.println("\n3 rr: " + roomReservationsForRoom);
        int i = 1;
        for (HotelService rr : roomReservationsForRoom) {
            if (rr != null) {
                Optional<Guest> guest = daoGuest.findById(rr.getGuest().getIdGuest());
                if (guest.isPresent()) {
                    String guestAndDate = "#" + (i++) +
                            ": Guest's name: " + guest.get().getName() +
                            ", check-in:" + rr.getCheckInTime() +
                            ", check-out = " + rr.getCheckOutTime();
                    guestsAndDates.add(guestAndDate);
                }
            }
        }
        return guestsAndDates;
    }

    @Override
    public List<Room> readAllRoomsFreeOnDate(String checkedTimeString) {
        log.debug("START: Hotel Service readAllRoomsFreeInTime");
        return daoFacility.readAllRoomsFreeOnDate(checkedTimeString);
    }

    @Override
    public Integer countFreeRoomsInTime(String checkedTimeString) {
        log.debug("START: Hotel Service countFreeRoomsInTime");
        return daoFacility.countFreeRoomsInTime(checkedTimeString);
    }

    @Override
    public List<Room> readAllFreeRoomsSortByPrice(String checkedTimeString) {
        log.debug("START: Hotel Service readAllFreeRoomsSortByPrice");
        return daoFacility.readAllRoomsFreeOnDateOrderByPrice(checkedTimeString);

    }

    @Override
    public List<Room> readAllFreeRoomsSortByCapacity(String checkedTimeString) {
        log.debug("START: Hotel Service readAllFreeRoomsSortByCapacity");
        return daoFacility.readAllRoomsFreeOnDateOrderByCapacity(checkedTimeString);
    }

    @Override
    public List<Room> readAllFreeRoomsSortByLevel(String checkedTimeString) {
        log.debug("START: Hotel Service readAllFreeRoomsSortByLevel");
        return daoFacility.readAllRoomsFreeOnDateOrderByLevel(checkedTimeString);
    }

    @Override
    public List<HotelService> readAllServicesSortByDate() {
        log.debug("START: Hotel Service readAllServicesSortByDate");
        return daoHotelService.findByOrderByCheckInTime();
    }

    @Override
    public List<HotelService> readAllServicesSortByCost() {
        log.debug("START: Hotel Service readAllServicesSortByPrice");
        return daoHotelService.findByOrderByCost();
    }

    @Override
    public List<HotelService> findServicesForOrder(Integer idOrder) {
        log.debug("START: ServiceRoomReservation readAllServicesForOrder");
        return daoHotelService.findByOrder(idOrder);
    }

    private boolean isVacant(int idRoom, LocalDateTime checkInTime, LocalDateTime checkOutTime) {
        log.debug("START: Hotel Service isVacant");
        List<HotelService> hotelServices = readAll();
        List<HotelService> hotelServicesForRoom = hotelServices.stream()
                .filter(rr -> rr.getRoom().getIdRoom() == idRoom)
                .toList();
        List<HotelService> hotelServicesForTime = hotelServicesForRoom.stream()
                .filter(rr -> (checkInTime.isAfter(rr.getCheckInTime()) &&
                        checkInTime.isBefore(rr.getCheckOutTime())) ||
                        (checkOutTime.isAfter(rr.getCheckInTime()) &&
                                checkInTime.isBefore(rr.getCheckOutTime())))
                .toList();
        return hotelServicesForTime.isEmpty();
    }

}
