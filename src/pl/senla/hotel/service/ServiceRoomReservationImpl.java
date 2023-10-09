package pl.senla.hotel.service;

import pl.senla.hotel.annotations.config.ConfigProperty;
import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.comparators.*;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.facilities.CategoryFacility;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.facilities.RoomStatus;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.entity.services.TypeOfService;
import pl.senla.hotel.repository.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static pl.senla.hotel.constant.ConsoleConstant.CONSOLE_CHANGE_ROOM_RESERVATION;
import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;
import static pl.senla.hotel.constant.HotelConstant.*;
import static pl.senla.hotel.constant.RoomReservationConstant.*;

@AppComponent
public class ServiceRoomReservationImpl implements ServiceRoomReservation {

    private static ServiceRoomReservation serviceRoomReservation;
    @GetInstance(beanName = "ServiceFacilityImpl")
    private final ServiceFacility serviceHotelFacility;
    @GetInstance(beanName = "RepositoryHotelServiceCollection")
    private final Repository<HotelService> repositoryHotelService;
    @GetInstance(beanName = "RepositoryRoomReservationCollection")
    private final Repository<RoomReservation> repositoryRoomReservation;
    @GetInstance(beanName = "RepositoryGuestCollection")
    private final Repository<Guest> repositoryGuest;
    @GetInstance(beanName = "RepositoryFacilityCollection")
    private final Repository<HotelFacility> repositoryFacility;
    @GetInstance(beanName = "ServiceRoomImpl")
    private final transient ServiceRoom serviceRoom;
    @ConfigProperty(configFileName = "hotel.properties", propertyName = "room-records.number", type = "Integer")
    private Integer roomRecordsNumber;

    private ServiceRoomReservationImpl(ServiceFacility serviceHotelFacility,
                                       Repository<HotelService> repositoryHotelService,
                                       Repository<RoomReservation> repositoryRoomReservation,
                                       Repository<Guest> repositoryGuest,
                                       Repository<HotelFacility> repositoryFacility,
                                       ServiceRoom serviceRoom) {
        this.serviceHotelFacility = serviceHotelFacility;
        this.repositoryHotelService = repositoryHotelService;
        this.repositoryRoomReservation = repositoryRoomReservation;
        this.repositoryGuest = repositoryGuest;
        this.repositoryFacility = repositoryFacility;
        this.serviceRoom = serviceRoom;
    }

    public static ServiceRoomReservation getSingletonInstance(ServiceFacility serviceHotelFacility,
                                                              Repository<HotelService> repositoryHotelService,
                                                              Repository<RoomReservation> repositoryRoomReservation,
                                                              Repository<Guest> repositoryGuest,
                                                              Repository<HotelFacility> repositoryFacility,
                                                              ServiceRoom serviceRoom){
        if (serviceRoomReservation == null) {
            serviceRoomReservation = new ServiceRoomReservationImpl(serviceHotelFacility,
                    repositoryHotelService,
                    repositoryRoomReservation,
                    repositoryGuest,
                    repositoryFacility,
                    serviceRoom);
        }
        return serviceRoomReservation;
    }

    @Override
    public List<RoomReservation> readAll() {
        if(repositoryHotelService.readAll() == null || repositoryHotelService.readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_ROOM_RESERVATION);
            return Collections.emptyList();
        }
        return repositoryRoomReservation.readAll()
                .stream()
                .map(RoomReservation.class::cast) //check
//                .filter(o -> o.getTypeOfService().equals(TypeOfService.ROOM_RESERVATION))
                .toList();
    }

    @Override
    public boolean create(String reservationString) {
        String[] reservationData = reservationString.split(";");
        int idOrder = Integer.parseInt(reservationData[0]);
        int idGuest = Integer.parseInt(reservationData[1]);
        int idRoom = Integer.parseInt(reservationData[2]);

        if(idGuest < 0 || idGuest >= repositoryGuest.readAll().size()){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT);
            return false;
        } else if(idRoom < 0 || idRoom >= repositoryFacility.readAll().size()) {
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_ROOM);
            return false;
        } else if (((Room)repositoryFacility.read(idRoom)).getRoomStatus().equals(RoomStatus.REPAIRED)) { // edit later!!!
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_REPAIRED);
            return false;
        } else {
            LocalDate checkInDate = getDate(reservationData[3]);
            LocalDateTime checkInTime = LocalDateTime.of(checkInDate, HOTEL_CHECK_IN_TIME);
            int numberOfDays = Integer.parseInt(reservationData[4]);
            LocalDateTime checkOutTime = LocalDateTime.of(checkInDate.plusDays(numberOfDays),
                    HOTEL_CHECK_OUT_TIME);

            if(isVacant(idRoom, checkInTime, checkOutTime)){
                RoomReservation reservation = new RoomReservation(serviceRoom);
                reservation.setIdService(-1);
                reservation.setIdOrder(idOrder);
                reservation.setIdGuest(idGuest);
                reservation.setIdRoom(idRoom);
                reservation.setCheckInTime(checkInTime);
                reservation.setNumberOfDays(numberOfDays);
                reservation.setTypeOfService(TypeOfService.ROOM_RESERVATION);
                reservation.setCheckOutTime(checkOutTime);
                reservation.setCost(repositoryFacility.read(idRoom).getPrice() * numberOfDays);
                setIdRoomReservationNew(reservation);

                List<RoomReservation> roomReservationList = readAll().stream()
                        .filter(rr -> rr.getIdRoom() == idRoom)
                        .toList();
                int numberOfRecords = roomReservationList.size();
                if (numberOfRecords >= roomRecordsNumber) {
                    int idRoomReservationToDelete = roomReservationList.get(0).getIdService();
                    delete(idRoomReservationToDelete);
                }
                repositoryRoomReservation.create(reservation);
                return repositoryHotelService.create(reservation);
            } else {
                System.out.println(ERROR_ROOM_NOT_AVAILABLE);
                return false;
            }
        }
    }


    @Override
    public RoomReservation read(int idReservation) {
        if(repositoryHotelService.readAll() == null || repositoryHotelService.readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_ROOM_RESERVATION);
            return null;
        }
        for (int i = 0; i <= readAll().size(); i++){
            if (readAll().get(i).getIdService() == idReservation){
                return (RoomReservation) repositoryHotelService.read(i);
            }
        }
        System.out.println(ERROR_READ_ROOM_RESERVATION);
        System.out.println(ERROR_INPUT);
        return null;
    }

    @Override
    public boolean update(int idReservation, String reservationUpdatingString) {
        if(repositoryHotelService.readAll() == null || repositoryHotelService.readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_ROOM_RESERVATION);
            return false;
        } else if(read(idReservation) == null){
            System.out.println(ERROR_READ_ROOM_RESERVATION);
            System.out.println(ERROR_INPUT);
            return false;
        }
        RoomReservation reservationOld = read(idReservation);
        String[] reservationData = reservationUpdatingString.split(";");
        String dateString = reservationData[0];
        LocalDate checkInDate = getDate(dateString);
        LocalDateTime checkInTime = LocalDateTime.of(checkInDate, HOTEL_CHECK_IN_TIME);
        int numberOfDaysNew = Integer.parseInt(reservationData[1]);
        LocalDateTime checkOutTime = LocalDateTime.of(checkInDate.plusDays(numberOfDaysNew), HOTEL_CHECK_OUT_TIME);

        RoomReservation reservationUpdate = new RoomReservation(serviceRoom);
        reservationUpdate.setIdService(idReservation);
        reservationUpdate.setTypeOfService(TypeOfService.ROOM_RESERVATION);
        reservationUpdate.setIdGuest(reservationOld.getIdGuest());
        reservationUpdate.setIdRoom(reservationOld.getIdRoom());
        reservationUpdate.setCheckInTime(checkInTime);
        reservationUpdate.setNumberOfDays(numberOfDaysNew);
        reservationUpdate.setCheckOutTime(checkOutTime);
        reservationUpdate.setCost(repositoryFacility.read(reservationOld.getIdRoom()).getPrice() * numberOfDaysNew);

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
        if(readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM_RESERVATION);
            return false;
        }
        for (int i = 0; i <= readAll().size(); i++){
            if (readAll().get(i).getIdService() == idReservation){
                repositoryRoomReservation.delete(i);
                return repositoryHotelService.delete(i);
            }
        }
        System.out.println(ERROR_READ_ROOM_RESERVATION);
        System.out.println(ERROR_INPUT);
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
    public List<RoomReservation> readAllRoomReservationsSortByGuestName() {
        return readAll().stream()
                .sorted(new RoomReservationsComparatorByGuestName(repositoryGuest))
                .toList();
    }

    @Override
    public List<RoomReservation> readAllRoomReservationsSortByGuestCheckOut() {
        return readAll().stream()
                .sorted(new RoomReservationsComparatorByCheckOut())
                .toList();
    }

    @Override
    public int countGuestPaymentForRoom(int idGuest) {
        List<Integer> costs = readAll()
                .stream()
                .filter(rr -> rr.getIdGuest() == idGuest)
                .map(RoomReservation::getCost)
                .toList();
        int sum = 0;
        for(Integer cost : costs){
            sum = sum + cost;
        }
        return sum;
    }

    @Override
    public List<String> read3LastGuestAndDatesForRoom(int idRoom) {
        List<String> guestsAndDates = new ArrayList<>();
        List<RoomReservation> roomReservationsForRoom = readAll()
                .stream()
                .filter(rr -> rr.getIdRoom() == idRoom)
                .sorted(new RoomReservationsComparatorByCheckOutReverse())
                .limit(3)
                .toList();
        for (RoomReservation rr : roomReservationsForRoom){
            if (rr != null) {
                int idGuest = rr.getIdGuest();
                for (int i = 0; i < repositoryGuest.readAll().size(); i++) {
                    if (idGuest == repositoryGuest.read(i).getIdGuest()) {
                        String guestAndDate = "\n#" + (i + 1) +
                                ":\nGuest's name: " + repositoryGuest.read(i).getName() +
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
        LocalDateTime checkedDateTime = getDateTime(checkedTimeString);
        List<HotelFacility> occupiedRooms = readAll().stream()
                .filter(rr -> rr.getTypeOfService().equals(TypeOfService.ROOM_RESERVATION))
                .filter(rr -> (checkedDateTime.isAfter(rr.getCheckInTime()) && checkedDateTime.isBefore(rr.getCheckOutTime())))
                .map(Room.class::cast)
                .map(rr -> serviceHotelFacility.read(rr.getIdFacility()))
                .toList();
        List<HotelFacility> rooms = serviceHotelFacility.readAll().stream()
                .filter(hs -> hs.getCategory().equals(CategoryFacility.ROOM))
                .toList();
        List<Room> freeRooms = new ArrayList<>();
        for (HotelFacility r : rooms) {
            for (HotelFacility hs : occupiedRooms) {
                if (r.equals(hs)) {
                    freeRooms.add((Room) r);
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
    public List<Room> readAllFreeRoomsSortByPrice(String checkedTimeString) {
        return readAllRoomsFreeInTime(checkedTimeString).stream()
                .sorted(new RoomComparatorByPrice())
                .toList();
    }

    @Override
    public List<Room> readAllFreeRoomsSortByCapacity(String checkedTimeString) {
        return readAllRoomsFreeInTime(checkedTimeString).stream()
                .sorted(new RoomComparatorByCapacity())
                .toList();
    }

    @Override
    public List<Room> readAllFreeRoomsSortByLevel(String checkedTimeString) {
        return readAllRoomsFreeInTime(checkedTimeString).stream()
                .sorted(new RoomComparatorByLevel())
                .toList();
    }

    private boolean createFromObject(RoomReservation reservation) {
        if(isVacant(reservation.getIdRoom(), reservation.getCheckInTime(), reservation.getCheckOutTime())){
            return repositoryHotelService.create(reservation); // changed here
        } else {
            System.out.println(ERROR_ROOM_NOT_AVAILABLE);
            return false;
        }
    }

    private void setIdRoomReservationNew(RoomReservation reservation) {
        int lastId = repositoryHotelService.readAll()
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
