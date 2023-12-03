package pl.senla.hotel.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.senla.hotel.comparators.*;
import pl.senla.hotel.dao.DaoGuestSpring;
import pl.senla.hotel.dao.DaoHotelFacilitySpring;
import pl.senla.hotel.dao.DaoHotelServiceSpring;
import pl.senla.hotel.dao.DaoOrderSpring;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.facilities.CategoryFacility;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.facilities.RoomStatus;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.TypeOfService;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static pl.senla.hotel.constant.ConsoleConstant.CONSOLE_CHANGE_ROOM_RESERVATION;
import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;
import static pl.senla.hotel.constant.HotelConstant.HOTEL_CHECK_IN_TIME;
import static pl.senla.hotel.constant.HotelConstant.HOTEL_CHECK_OUT_TIME;
import static pl.senla.hotel.constant.RoomReservationConstant.*;

@Service
@Slf4j
public class ServiceRoomReservationSpring implements ServiceRoomReservation {

    @Autowired
    private ServiceFacility serviceHotelFacility;
    @Autowired
    private DaoHotelServiceSpring daoHotelService;
    @Autowired
    private DaoGuestSpring daoGuest;
    @Autowired
    private DaoHotelFacilitySpring daoFacility;
    @Autowired
    private DaoOrderSpring daoOrder;
    @Autowired
    private transient ServiceFacility serviceRoom;
    @Value("${room-records.number}")
    private Integer roomRecordsNumber;

    public ServiceRoomReservationSpring() {}

    @Override
    public List<HotelService> readAll() {
        log.debug("START: Hotel Service ReadAll");
        List<HotelService> hotelServiceList = daoHotelService.findAll();
        if(!hotelServiceList.isEmpty()){
            return hotelServiceList;
        }
        log.debug(ALL_ROOM_RESERVATION_IS_EMPTY);
        return hotelServiceList;
    }

    @Override
    public HotelService create(String reservationString) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("START: Hotel Service Create");
        String[] reservationData = reservationString.split(";");
        int idOrder = Integer.parseInt(reservationData[0]);
        int idGuest = Integer.parseInt(reservationData[1]);
        int idRoom = Integer.parseInt(reservationData[2]);
        if(idGuest < 0 || idGuest >= daoGuest.findAll().size()){
            log.debug(ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT);
            return null;
        } else if(idRoom < 0 || idRoom >= daoFacility.findAll().size()) {
            log.debug(ERROR_CREATE_ROOM_RESERVATION_NO_ROOM);
            return null;
        } else if ((daoFacility.findById(idRoom)).get().getRoomStatus().equals(RoomStatus.REPAIRED)) { // edit later!!!
            log.debug(ERROR_CREATE_ROOM_RESERVATION_REPAIRED);
            return null;
        } else {
            LocalDate checkInDate = getDate(reservationData[3]);
            LocalDateTime checkInTime = LocalDateTime.of(checkInDate, HOTEL_CHECK_IN_TIME);
            int numberOfDays = Integer.parseInt(reservationData[4]);
            LocalDateTime checkOutTime = LocalDateTime.of(checkInDate.plusDays(numberOfDays),
                    HOTEL_CHECK_OUT_TIME);

            if(isVacant(idRoom, checkInTime, checkOutTime)){
                HotelService reservation = new HotelService();
                Optional<Order> order = daoOrder.findById(idOrder);
                order.ifPresent(reservation::setOrder);
                Optional<Guest> guest = daoGuest.findById(idGuest);
                guest.ifPresent(reservation::setGuest);
                Optional<Room> room = daoFacility.findById(idRoom);
                room.ifPresent(reservation::setRoom);
                reservation.setCheckInTime(checkInTime);
                reservation.setNumberOfDays(numberOfDays);
                reservation.setTypeOfService(TypeOfService.ROOM_RESERVATION);
                reservation.setCheckOutTime(checkOutTime);
                room.ifPresent(value -> reservation.setCost(value.getPrice() * numberOfDays));
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
    public HotelService read(int idReservation) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("START: Hotel Service Read");
        Optional<HotelService> hotelService = daoHotelService.findById(idReservation);
        if(hotelService.isPresent()){
            return hotelService.get();
        }
        log.debug(ROOM_RESERVATION_NOT_EXISTS);
        return null;
    }

    @Override
    public HotelService update(int idReservation, String reservationUpdatingString) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("START: Hotel Service update");
        if(read(idReservation) == null){
            log.debug(ROOM_RESERVATION_NOT_EXISTS);
            log.debug(ERROR_INPUT);
            return null;
        }
        HotelService reservationOld = read(idReservation);
        String[] reservationData = reservationUpdatingString.split(";");
        String dateString = reservationData[0];
        LocalDate checkInDate = getDate(dateString);
        LocalDateTime checkInTime = LocalDateTime.of(checkInDate, HOTEL_CHECK_IN_TIME);
        int numberOfDaysNew = Integer.parseInt(reservationData[1]);
        LocalDateTime checkOutTime = LocalDateTime.of(checkInDate.plusDays(numberOfDaysNew), HOTEL_CHECK_OUT_TIME);

        HotelService reservationUpdate = new HotelService();
        reservationUpdate.setIdService(idReservation);
        reservationUpdate.setTypeOfService(TypeOfService.ROOM_RESERVATION);
//        reservationUpdate.setIdGuest(reservationOld.getIdGuest());
        reservationUpdate.setGuest(reservationOld.getGuest());
        reservationUpdate.setRoom(reservationOld.getRoom());
        reservationUpdate.setCheckInTime(checkInTime);
        reservationUpdate.setNumberOfDays(numberOfDaysNew);
        reservationUpdate.setCheckOutTime(checkOutTime);
        reservationUpdate.setCost(daoFacility.findById(reservationOld.getRoom().getIdRoom()).get().getPrice() * numberOfDaysNew);

        delete(idReservation);
        if(createFromObject(reservationUpdate) != null){
            log.debug(CONSOLE_CHANGE_ROOM_RESERVATION + " " + true);
            return reservationUpdate;
        } else {
            createFromObject(reservationOld);
            log.debug(ERROR_UPDATE_ROOM_RESERVATION);
            return reservationOld;
        }
    }

    @Override
    public void delete(int idReservation) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("START: Hotel Service delete");
        if(read(idReservation) != null){
            daoHotelService.deleteById(idReservation);
        }
        log.debug(ALL_ROOM_RESERVATION_IS_EMPTY);
    }

    @Override
    public int countNumberOfGuestsOnDate(String checkedDateString) {
        log.debug("START: Hotel Service countNumberOfGuestsOnDate");
        LocalDateTime checkedDateTime = getDateTime(checkedDateString);
        return (int) readAll().stream()
                .filter(rr -> checkedDateTime.isAfter(rr.getCheckInTime()) &&
                        checkedDateTime.isBefore(rr.getCheckOutTime()))
                .count();
    }

    @Override
    public List<HotelService> readAllRoomReservationsSortByGuestName() {
        log.debug("START: Hotel Service readAllRoomReservationsSortByGuestName");
        return readAll().stream()
                .sorted(new RoomReservationsComparatorByGuestName())
                .toList();
    }

    @Override
    public List<HotelService> readAllRoomReservationsSortByGuestCheckOut() {
        log.debug("START: Hotel Service readAllRoomReservationsSortByGuestCheckOut");
        return readAll().stream()
                .sorted(new RoomReservationsComparatorByCheckOut())
                .toList();
    }

    @Override
    public int countGuestPaymentForRoom(int idGuest) {
        log.debug("START: Hotel Service countGuestPaymentForRoom");
        List<Integer> costs = readAll()
                .stream()
                .filter(rr -> rr.getGuest().getIdGuest() == idGuest)
                .map(HotelService::getCost)
                .toList();
        int sum = 0;
        for(Integer cost : costs){
            sum = sum + cost;
        }
        return sum;
    }

    @Override
    public List<String> read3LastGuestAndDatesForRoom(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("START: Hotel Service read3LastGuestAndDatesForRoom");
        List<String> guestsAndDates = new ArrayList<>();
        List<HotelService> roomReservationsForRoom = readAll()
                .stream()
                .filter(rr -> rr.getRoom().getIdRoom() == idRoom)
                .sorted(new RoomReservationsComparatorByCheckOutReverse())
                .limit(3)
                .toList();
        for (HotelService rr : roomReservationsForRoom){
            if (rr != null) {
                int idGuest = rr.getGuest().getIdGuest();
                for (int i = 0; i < daoGuest.findAll().size(); i++) {
                    if (idGuest == daoGuest.findById(i).get().getIdGuest()) {
                        String guestAndDate = "\n#" + (i + 1) +
                                ":\nGuest's name: " + daoGuest.findById(i).get().getName() +
                                ", check-in:" + rr.getCheckInTime() +
                                ", check-out = " + rr.getCheckOutTime();
                        guestsAndDates.add(guestAndDate);
                    } else {
                        guestsAndDates.add("\n#" + (i + 1) + ": no reservation");
                    }
                }
            }
        }
        return guestsAndDates;
    }

    @Override
    public List<Room> readAllRoomsFreeInTime(String checkedTimeString) {
        log.debug("START: Hotel Service readAllRoomsFreeInTime");
        LocalDateTime checkedDateTime = getDateTime(checkedTimeString);
        List<Room> occupiedRooms = readAll().stream()
                .filter(rr -> rr.getTypeOfService().equals(TypeOfService.ROOM_RESERVATION))
                .filter(rr -> (checkedDateTime.isAfter(rr.getCheckInTime()) && checkedDateTime.isBefore(rr.getCheckOutTime())))
                .map(rr -> {
                    try {
                        return serviceHotelFacility.read(rr.getRoom().getIdRoom());
                    } catch (InvocationTargetException | NoSuchMethodException | InstantiationException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
        List<Room> rooms = serviceHotelFacility.readAll().stream()
                .filter(hs -> hs.getCategory().equals(CategoryFacility.ROOM))
                .toList();
        List<Room> freeRooms = new ArrayList<>();
        for (Room r : rooms) {
            for (Room hs : occupiedRooms) {
                if (r.equals(hs)) {
                    freeRooms.add(r);
                }
            }
        }
        return freeRooms;
    }

    @Override
    public int countFreeRoomsInTime(String checkedTimeString) {
        log.debug("START: Hotel Service countFreeRoomsInTime");
        return readAllRoomsFreeInTime(checkedTimeString).size();
    }

    @Override
    public List<Room> readAllFreeRoomsSortByPrice(String checkedTimeString) {
        log.debug("START: Hotel Service readAllFreeRoomsSortByPrice");
        return readAllRoomsFreeInTime(checkedTimeString).stream()
                .sorted(new RoomComparatorByPrice())
                .toList();
    }

    @Override
    public List<Room> readAllFreeRoomsSortByCapacity(String checkedTimeString) {
        log.debug("START: Hotel Service readAllFreeRoomsSortByCapacity");
        return readAllRoomsFreeInTime(checkedTimeString).stream()
                .sorted(new RoomComparatorByCapacity())
                .toList();
    }

    @Override
    public List<Room> readAllFreeRoomsSortByLevel(String checkedTimeString) {
        log.debug("START: Hotel Service readAllFreeRoomsSortByLevel");
        return readAllRoomsFreeInTime(checkedTimeString).stream()
                .sorted(new RoomComparatorByLevel())
                .toList();
    }

    @Override
    public List<HotelService> readAllServicesSortByDate() {
        log.debug("START: Hotel Service readAllServicesSortByDate");
        return daoHotelService.findAll()
                .stream()
                .sorted(new HotelServicesComparatorByDate())
                .toList();
    }

    @Override
    public List<HotelService> readAllServicesSortByPrice() {
        log.debug("START: Hotel Service readAllServicesSortByPrice");
        return daoHotelService.findAll()
                .stream()
                .sorted(new HotelServicesComparatorByPrice())
                .toList();
    }

    private HotelService createFromObject(HotelService reservation) {
        log.debug("START: Hotel Service createFromObject");
        if(isVacant(reservation.getRoom().getIdRoom(), reservation.getCheckInTime(), reservation.getCheckOutTime())){
            return daoHotelService.save(reservation); // changed here
        } else {
            System.out.println(ERROR_ROOM_NOT_AVAILABLE);
            return null;
        }
    }

    private boolean isVacant(int idRoom, LocalDateTime checkInTime, LocalDateTime checkOutTime) {
        log.debug("START: Hotel Service isVacant");
        return readAll().stream()
                .filter(r -> r.getRoom().getIdRoom() == idRoom)
                .filter(r -> (checkInTime.isAfter(r.getCheckInTime()) && checkInTime.isBefore(r.getCheckOutTime())) ||
                        (checkOutTime.isAfter(r.getCheckInTime()) && checkInTime.isBefore(r.getCheckOutTime())))
                .toList()
                .isEmpty();
    }

    private LocalDate getDate(String reservationDatum) {
        log.debug("START: Hotel Service getDate");
        String[] numbers = reservationDatum.split("-");
        int year = Integer.parseInt(numbers[0]);
        int month = Integer.parseInt(numbers[1]);
        int day = Integer.parseInt(numbers[2]);
        return LocalDate.of(year,month,day);
    }

    private LocalDateTime getDateTime(String checkedDateString) {
        log.debug("START: Hotel Service getDateTime");
        String[] timeData = checkedDateString.split("-");
        int year = Integer.parseInt(timeData[0]);
        int month = Integer.parseInt(timeData[1]);
        int day = Integer.parseInt(timeData[2]);
        int hour = Integer.parseInt(timeData[3]);
        int minute = Integer.parseInt(timeData[4]);
        return LocalDateTime.of(year,month,day, hour, minute);
    }

}
