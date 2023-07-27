package pl.senla.hotel.service;

import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.entity.services.TypeOfService;
import pl.senla.hotel.repository.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static pl.senla.hotel.constant.ConsoleConstant.CONSOLE_CHANGE_ROOM_RESERVATION;
import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;
import static pl.senla.hotel.constant.HotelConstant.*;
import static pl.senla.hotel.constant.RoomReservationConstant.*;

public class ServiceRoomReservationImpl implements ServiceRoomReservation {

    private static ServiceRoomReservation serviceRoomReservation;
    private final RepositoryHotelService repositoryHotelService;
    private final RepositoryRoomReservation repositoryRoomReservation; // delete?
    private final RepositoryGuest repositoryGuest;
    private final RepositoryFacility repositoryFacility;

    private ServiceRoomReservationImpl() {
        this.repositoryHotelService = RepositoryHotelServiceCollection.getRepositoryHotelService();
        this.repositoryRoomReservation = RepositoryRoomReservationCollection.getRepositoryRoomReservation(); // delete?
        this.repositoryGuest = RepositoryGuestCollection.getRepositoryGuest();
        this.repositoryFacility = RepositoryFacilityCollection.getRepositoryFacility();
    }

    public static ServiceRoomReservation getServiceRoomReservation(){
        if (serviceRoomReservation == null) {
            serviceRoomReservation = new ServiceRoomReservationImpl();
        }
        return serviceRoomReservation;
    }

    @Override
    public List<RoomReservation> readAll() {
        if(repositoryHotelService.readAll() == null || repositoryHotelService.readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_ROOM_RESERVATION);
            return Collections.emptyList();
        }
        return repositoryHotelService.readAll()
                .stream()
                .map(RoomReservation.class::cast) //check
                .filter(o -> o.getTypeOfService().equals(TypeOfService.ROOM_RESERVATION.getTypeName()))
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
        } else if(idRoom < 0 || idRoom >= repositoryFacility.readAll().size()){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_ROOM);
            return false;
        } else {
            LocalDate checkInDate = getDate(reservationData[3]);
            LocalDateTime checkInTime = LocalDateTime.of(checkInDate, HOTEL_CHECK_IN_TIME);
            int numberOfDays = Integer.parseInt(reservationData[4]);
            LocalDateTime checkOutTime = LocalDateTime.of(checkInDate.plusDays(numberOfDays),
                    HOTEL_CHECK_OUT_TIME);

            if(isVacant(idRoom, checkInTime, checkOutTime)){
                RoomReservation reservation = new RoomReservation();
                reservation.setIdService(-1);
                reservation.setIdOrder(idOrder);
                reservation.setIdGuest(idGuest);
                reservation.setIdRoom(idRoom);
                reservation.setCheckInTime(checkInTime);
                reservation.setNumberOfDays(numberOfDays);
                reservation.setTypeOfService(TypeOfService.ROOM_RESERVATION.getTypeName());
                reservation.setCheckOutTime(checkOutTime);
                reservation.setCost(repositoryFacility.read(idRoom).getPrice() * numberOfDays);
                setIdRoomReservationNew(reservation);
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

        RoomReservation reservationUpdate = new RoomReservation();
        reservationUpdate.setIdService(idReservation);
        reservationUpdate.setTypeOfService(TypeOfService.ROOM_RESERVATION.getTypeName());
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
            System.out.println("It is not impossible to update this RoomReservation.\nOld RoomReservation was restored.");
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
                return repositoryHotelService.delete(i);
            }
        }
        System.out.println(ERROR_READ_ROOM_RESERVATION);
        System.out.println(ERROR_INPUT);
        return false;
    }

    //edit next 5 methods
    @Override
    public int countNumberOfGuestsOnDate(String checkedTimeString) {
        return repositoryRoomReservation.countNumberOfGuestsOnDate(checkedTime);
    }

    @Override
    public List<RoomReservation> readAllRoomReservationsSortByGuestName() {
        return repositoryRoomReservation.readAllRoomReservationsSortByGuestName();
    }

    @Override
    public List<RoomReservation> readAllRoomReservationsSortByGuestCheckOut() {
        return repositoryRoomReservation.readAllRoomReservationsSortByGuestCheckOut();
    }

    @Override
    public int countGuestPaymentForRoom(int idGuest) {
        return repositoryRoomReservation.countGuestPaymentForRoom(idGuest);
    }

    @Override
    public List<String> read3LastGuestAndDatesForRoom(int idRoom) {
        return repositoryRoomReservation.read3LastGuestAndDatesForRoom(idRoom);
    }



    // Refactor All methods: delete using FreeRooms
    @Override
    public List<Room> readAllFreeRoomsSortByPrice() {
        return repositoryFreeRoom.readAllFreeRoomsSortByPrice();
    }

    @Override
    public List<Room> readAllFreeRoomsSortByCapacity() {
        return repositoryFreeRoom.readAllFreeRoomsSortByCapacity();
    }

    @Override
    public List<Room> readAllFreeRoomsSortByLevel() {
        return repositoryFreeRoom.readAllFreeRoomsSortByLevel();
    }

    @Override
    public int countFreeRoomsOnTime(String checkedDateTimeString) {
        return repositoryFreeRoom.countFreeRoomsOnTime(checkedDateTime);
    }

    @Override
    public List<Room> readAllRoomsFreeAtTime(String checkedTimeString) {
        return repositoryFreeRoom.readAllRoomsFreeAtTime(checkedTime);
    }



    //all private methods for RoomReservations
    private boolean createFromObject(RoomReservation reservation) {
        if(isVacant(reservation.getIdRoom(), reservation.getCheckInTime(), reservation.getCheckOutTime())){
            return repositoryRoomReservation.create(reservation);
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
}
