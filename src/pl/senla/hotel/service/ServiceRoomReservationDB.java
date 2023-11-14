package pl.senla.hotel.service;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.ConfigProperty;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.comparators.*;
import pl.senla.hotel.dao.GenericDao;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.facilities.CategoryFacility;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.facilities.RoomStatus;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.TypeOfService;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static pl.senla.hotel.constant.ConsoleConstant.CONSOLE_CHANGE_ROOM_RESERVATION;
import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;
import static pl.senla.hotel.constant.HotelConstant.HOTEL_CHECK_IN_TIME;
import static pl.senla.hotel.constant.HotelConstant.HOTEL_CHECK_OUT_TIME;
import static pl.senla.hotel.constant.RoomReservationConstant.*;

@AppComponent
public class ServiceRoomReservationDB implements ServiceRoomReservation {

    @GetInstance(beanName = "ServiceFacilityDB")
    private ServiceFacility serviceHotelFacility;
    @GetInstance(beanName = "DaoHotelServiceDB")
    private GenericDao<HotelService> daoHotelService;
    @GetInstance(beanName = "DaoGuestDB")
    private GenericDao<Guest> daoGuest;
    @GetInstance(beanName = "DaoFacilityDB")
    private GenericDao<HotelFacility> daoFacility;
    @GetInstance(beanName = "ServiceFacilityDB")
    private transient ServiceFacility serviceRoom;
    @ConfigProperty(configFileName = "hotel.properties", propertyName = "room-records.number", type = "Integer")
    private Integer roomRecordsNumber;

    public ServiceRoomReservationDB() {}

    @Override
    public List<HotelService> readAll() {
        if(daoHotelService.readAll() != null || !daoHotelService.readAll().isEmpty()){
            return daoHotelService.readAll()
                    .stream()
//                    .map(RoomReservation.class::cast) //check
                    .toList();
        }
        System.out.println(ALL_ROOM_RESERVATION_IS_EMPTY);
        return Collections.emptyList();
    }

    @Override
    public boolean create(String reservationString) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        String[] reservationData = reservationString.split(";");
        int idOrder = Integer.parseInt(reservationData[0]);
        int idGuest = Integer.parseInt(reservationData[1]);
        int idRoom = Integer.parseInt(reservationData[2]);
        if(idGuest < 0 || idGuest >= daoGuest.readAll().size()){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT);
            return false;
        } else if(idRoom < 0 || idRoom >= daoFacility.readAll().size()) {
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_ROOM);
            return false;
        } else if ((daoFacility.read(idRoom)).getRoomStatus().equals(RoomStatus.REPAIRED)) { // edit later!!!
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_REPAIRED);
            return false;
        } else {
            LocalDate checkInDate = getDate(reservationData[3]);
            LocalDateTime checkInTime = LocalDateTime.of(checkInDate, HOTEL_CHECK_IN_TIME);
            int numberOfDays = Integer.parseInt(reservationData[4]);
            LocalDateTime checkOutTime = LocalDateTime.of(checkInDate.plusDays(numberOfDays),
                    HOTEL_CHECK_OUT_TIME);

            if(isVacant(idRoom, checkInTime, checkOutTime)){
                HotelService reservation = new HotelService();
                reservation.setIdService(-1);
                reservation.setIdOrder(idOrder);
                reservation.setIdGuest(idGuest);
                reservation.setIdRoom(idRoom);
                reservation.setCheckInTime(checkInTime);
                reservation.setNumberOfDays(numberOfDays);
                reservation.setTypeOfService(TypeOfService.ROOM_RESERVATION);
                reservation.setCheckOutTime(checkOutTime);
                reservation.setCost(daoFacility.read(idRoom).getPrice() * numberOfDays);
                setIdRoomReservationNew(reservation);

                List<HotelService> roomReservationList = readAll().stream()
                        .filter(rr -> rr.getIdRoom() == idRoom)
                        .toList();
                int numberOfRecords = roomReservationList.size();
                if (numberOfRecords >= roomRecordsNumber) {
                    int idRoomReservationToDelete = roomReservationList.get(0).getIdService();
                    delete(idRoomReservationToDelete);
                }
                return daoHotelService.create(reservation);
            } else {
                System.out.println(ERROR_ROOM_NOT_AVAILABLE);
                return false;
            }
        }
    }


    @Override
    public HotelService read(int idReservation) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        if(daoHotelService.read(idReservation) != null){
            return daoHotelService.read(idReservation);
        }
        System.out.println(ALL_ROOM_RESERVATION_IS_EMPTY);
        return null;
    }

    @Override
    public boolean update(int idReservation, String reservationUpdatingString) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        if(read(idReservation) == null){
            System.out.println(ROOM_RESERVATION_NOT_EXISTS);
            System.out.println(ERROR_INPUT);
            return false;
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
        reservationUpdate.setIdGuest(reservationOld.getIdGuest());
        reservationUpdate.setIdRoom(reservationOld.getIdRoom());
        reservationUpdate.setCheckInTime(checkInTime);
        reservationUpdate.setNumberOfDays(numberOfDaysNew);
        reservationUpdate.setCheckOutTime(checkOutTime);
        reservationUpdate.setCost(daoFacility.read(reservationOld.getIdRoom()).getPrice() * numberOfDaysNew);

        delete(idReservation);
        if(createFromObject(reservationUpdate)){
            System.out.println(CONSOLE_CHANGE_ROOM_RESERVATION + " " + true);
            return true;
        } else {
            createFromObject(reservationOld);
            System.out.println(ERROR_UPDATE_ROOM_RESERVATION);
            return false;
        }
    }

    @Override
    public boolean delete(int idReservation) {
        if(readAll() != null){
            return daoHotelService.delete(idReservation);
        }
        System.out.println(ALL_ROOM_RESERVATION_IS_EMPTY);
        return false;
    }

    @Override
    public int countNumberOfGuestsOnDate(String checkedDateString) {
        LocalDateTime checkedDateTime = getDateTime(checkedDateString);
        return (int) readAll().stream()
                .filter(rr -> checkedDateTime.isAfter(rr.getCheckInTime()) &&
                        checkedDateTime.isBefore(rr.getCheckOutTime()))
                .count();
    }

    @Override
    public List<HotelService> readAllRoomReservationsSortByGuestName() {
        return readAll().stream()
                .sorted(new RoomReservationsComparatorByGuestName())
                .toList();
    }

    @Override
    public List<HotelService> readAllRoomReservationsSortByGuestCheckOut() {
        return readAll().stream()
                .sorted(new RoomReservationsComparatorByCheckOut())
                .toList();
    }

    @Override
    public int countGuestPaymentForRoom(int idGuest) {
        List<Integer> costs = readAll()
                .stream()
                .filter(rr -> rr.getIdGuest() == idGuest)
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
        List<String> guestsAndDates = new ArrayList<>();
        List<HotelService> roomReservationsForRoom = readAll()
                .stream()
                .filter(rr -> rr.getIdRoom() == idRoom)
                .sorted(new RoomReservationsComparatorByCheckOutReverse())
                .limit(3)
                .toList();
        for (HotelService rr : roomReservationsForRoom){
            if (rr != null) {
                int idGuest = rr.getIdGuest();
                for (int i = 0; i < daoGuest.readAll().size(); i++) {
                    if (idGuest == daoGuest.read(i).getIdGuest()) {
                        String guestAndDate = "\n#" + (i + 1) +
                                ":\nGuest's name: " + daoGuest.read(i).getName() +
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
    public List<HotelFacility> readAllRoomsFreeInTime(String checkedTimeString) {
        LocalDateTime checkedDateTime = getDateTime(checkedTimeString);
        List<HotelFacility> occupiedRooms = readAll().stream()
                .filter(rr -> rr.getTypeOfService().equals(TypeOfService.ROOM_RESERVATION))
                .filter(rr -> (checkedDateTime.isAfter(rr.getCheckInTime()) && checkedDateTime.isBefore(rr.getCheckOutTime())))
//                .map(Room.class::cast)
                .map(rr -> {
                    try {
                        return serviceHotelFacility.read(rr.getIdRoom());
                    } catch (InvocationTargetException | NoSuchMethodException | InstantiationException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
        List<HotelFacility> rooms = serviceHotelFacility.readAll().stream()
                .filter(hs -> hs.getCategory().equals(CategoryFacility.ROOM))
                .toList();
        List<HotelFacility> freeRooms = new ArrayList<>();
        for (HotelFacility r : rooms) {
            for (HotelFacility hs : occupiedRooms) {
                if (r.equals(hs)) {
                    freeRooms.add(r);
                }
            }
        }
        return freeRooms;
    }

    @Override
    public int countFreeRoomsInTime(String checkedTimeString) {
        return readAllRoomsFreeInTime(checkedTimeString).size();
    }

    @Override
    public List<HotelFacility> readAllFreeRoomsSortByPrice(String checkedTimeString) {
        return readAllRoomsFreeInTime(checkedTimeString).stream()
                .sorted(new RoomComparatorByPrice())
                .toList();
    }

    @Override
    public List<HotelFacility> readAllFreeRoomsSortByCapacity(String checkedTimeString) {
        return readAllRoomsFreeInTime(checkedTimeString).stream()
                .sorted(new RoomComparatorByCapacity())
                .toList();
    }

    @Override
    public List<HotelFacility> readAllFreeRoomsSortByLevel(String checkedTimeString) {
        return readAllRoomsFreeInTime(checkedTimeString).stream()
                .sorted(new RoomComparatorByLevel())
                .toList();
    }

    @Override
    public List<HotelService> readAllServicesSortByDate() {
        return daoHotelService.readAll()
                .stream()
                .sorted(new HotelServicesComparatorByDate())
                .toList();
    }

    @Override
    public List<HotelService> readAllServicesSortByPrice() {
        return daoHotelService.readAll()
                .stream()
                .sorted(new HotelServicesComparatorByPrice())
                .toList();
    }

    private boolean createFromObject(HotelService reservation) {
        if(isVacant(reservation.getIdRoom(), reservation.getCheckInTime(), reservation.getCheckOutTime())){
            return daoHotelService.create(reservation); // changed here
        } else {
            System.out.println(ERROR_ROOM_NOT_AVAILABLE);
            return false;
        }
    }

    private void setIdRoomReservationNew(HotelService reservation) {
        int lastId = daoHotelService.readAll()
                .stream()
                .map(HotelService::getIdService)
                .max(Comparator.comparingInt(o -> o))
                .orElse(-1);
        reservation.setIdService(lastId + 1);
    }

    private boolean isVacant(int idRoom, LocalDateTime checkInTime, LocalDateTime checkOutTime) {
        return readAll().stream()
                .filter(r -> r.getIdRoom() == idRoom)
                .filter(r -> (checkInTime.isAfter(r.getCheckInTime()) && checkInTime.isBefore(r.getCheckOutTime())) ||
                        (checkOutTime.isAfter(r.getCheckInTime()) && checkInTime.isBefore(r.getCheckOutTime())))
                .toList()
                .isEmpty();
    }

    private LocalDate getDate(String reservationDatum) {
        String[] numbers = reservationDatum.split("-");
        int year = Integer.parseInt(numbers[0]);
        int month = Integer.parseInt(numbers[1]);
        int day = Integer.parseInt(numbers[2]);
        return LocalDate.of(year,month,day);
    }

    private LocalDateTime getDateTime(String checkedDateString) {
        String[] timeData = checkedDateString.split("-");
        int year = Integer.parseInt(timeData[0]);
        int month = Integer.parseInt(timeData[1]);
        int day = Integer.parseInt(timeData[2]);
        int hour = Integer.parseInt(timeData[3]);
        int minute = Integer.parseInt(timeData[4]);
        return LocalDateTime.of(year,month,day, hour, minute);
    }

}
