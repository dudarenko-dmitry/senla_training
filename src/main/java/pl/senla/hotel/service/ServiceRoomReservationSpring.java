package pl.senla.hotel.service;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.senla.hotel.dao.DaoGuestSpring;
import pl.senla.hotel.dao.DaoHotelFacilitySpring;
import pl.senla.hotel.dao.DaoHotelServiceSpring;
import pl.senla.hotel.dao.DaoOrderSpring;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.Order;
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
@NoArgsConstructor
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

    @Override // ready
    public List<HotelService> readAll() {
        log.debug("START: Hotel Service ReadAll");
        List<HotelService> hotelServiceList = daoHotelService.findAll();
        if(!hotelServiceList.isEmpty()){
            return hotelServiceList;
        }
        log.debug(ALL_ROOM_RESERVATION_IS_EMPTY);
        return hotelServiceList;
    }

    @Transactional
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
                reservation.setCost(daoFacility.findById(idRoom).get().getPrice() * numberOfDays);
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

    @Transactional
    @Override // ready
    public HotelService update(int idReservation, Object t2New) throws InvocationTargetException,
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
    public int countGuestPaymentForRoom(int idGuest) {
        log.debug("START: Hotel Service countGuestPaymentForRoom");
        return daoHotelService.getSumForRoomByGuest(idGuest);
    }

    @Override
    public List<String> read3LastGuestAndDatesForRoom(int idRoom) {
        log.debug("START: Hotel Service read3LastGuestAndDatesForRoom");
        List<String> guestsAndDates = new ArrayList<>();
        List<HotelService> roomReservationsForRoom = daoHotelService.findLast3ByRoomId(idRoom);
        System.out.println("\n3 rr: " + roomReservationsForRoom);
        int i = 1;
        for (HotelService rr : roomReservationsForRoom){
            if (rr != null) {
                Optional<Guest> guest = daoGuest.findById(rr.getGuest().getIdGuest());
                if (guest.isPresent()) {
                    String guestAndDate = "\n#" + (i++) +
                            ":\nGuest's name: " + guest.get().getName() +
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
    public int countFreeRoomsInTime(String checkedTimeString) {
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
    public List<HotelService> readAllServicesSortByPrice() {
        log.debug("START: Hotel Service readAllServicesSortByPrice");
        return daoHotelService.findByOrderByCost();
    }

    @Override
    public List<HotelService> findServicesForOrder(int idOrder) {
        log.debug("START: ServiceRoomReservation readAllServicesForOrder");
        return daoHotelService.findByOrder(idOrder);
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
