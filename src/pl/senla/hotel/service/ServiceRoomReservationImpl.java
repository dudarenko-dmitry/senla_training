package pl.senla.hotel.service;

import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.FreeRoom;
import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.entity.services.TypeOfService;
import pl.senla.hotel.repository.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static pl.senla.hotel.constant.FreeRoomConstant.ERROR_READ_ALL_FREE_ROOM;
import static pl.senla.hotel.constant.HotelConstant.HOTEL_CHECK_IN_TIME;
import static pl.senla.hotel.constant.HotelConstant.HOTEL_CHECK_OUT_TIME;
import static pl.senla.hotel.constant.RoomReservationConstant.*;

public class ServiceRoomReservationImpl implements ServiceRoomReservation {

    private final RepositoryRoomReservation repositoryRoomReservation;
    private final RepositoryFreeRoom repositoryFreeRoom;
    private final RepositoryGuest repositoryGuest;
    private final RepositoryRoom repositoryRoom;

    public ServiceRoomReservationImpl() {
        this.repositoryRoomReservation = new RepositoryRoomReservationCollection();
        this.repositoryFreeRoom = new RepositoryFreeRoomCollection();
        this.repositoryGuest = new RepositoryGuestCollection();
        this.repositoryRoom = new RepositoryRoomCollection();
    }

    @Override
    public List<RoomReservation> readAll() {
        if(repositoryRoomReservation.readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM_RESERVATION);
        }
        return repositoryRoomReservation.readAll();
    }

    @Override
    public boolean create(String reservationString) {
        String[] reservationData = reservationString.split(":");

        int idGuest = Integer.parseInt(reservationData[0]);
        int idRoom = Integer.parseInt(reservationData[1]);
        LocalDate checkInDate = getDate(reservationData[2]);
        LocalDateTime checkInTime = LocalDateTime.of(checkInDate, HOTEL_CHECK_IN_TIME);
        int numberOfDays = Integer.parseInt(reservationData[3]);
        LocalDateTime checkOutTime = LocalDateTime.of(checkInDate.plusDays(Integer.parseInt(reservationData[3])),
                HOTEL_CHECK_OUT_TIME);

        RoomReservation reservation = new RoomReservation();
        reservation.setIdRoomReservation(-1);
        reservation.setIdGuest(idGuest);
        reservation.setIdRoom(idRoom);
        reservation.setCheckInTime(checkInTime);
        reservation.setNumberOfDays(numberOfDays);
        reservation.setTypeOfService(TypeOfService.ROOM_RESERVATION.getTypeName());
        reservation.setCheckOutTime(checkOutTime);
        reservation.setCost(repositoryRoom.read(idRoom).getPrice() * numberOfDays);
        setIdRoomReservationNew(reservation);

        if(idGuest < 0){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT);
            return false;
        } else if(idRoom < 0){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_ROOM);
            return false;
        } else if(read(reservation.getIdRoomReservation()) != null) {
            System.out.println(ERROR_CREATE_ROOM_RESERVATION);
            return false;
        } else {
            boolean notVacant = repositoryRoomReservation.readAll().stream()
                    .filter(r -> r.getIdRoom() == idRoom)
                    .filter(r -> !r.getCheckInTime().isBefore(checkInTime) &&
                            !r.getCheckOutTime().isAfter(checkOutTime))
                    .toList()
                    .isEmpty();
            if(!notVacant){
                return repositoryRoomReservation.create(reservation);
            } else {
                System.out.println(ERROR_ROOM_NOT_AVAILABLE);
                return false;
            }
        }
    }

    @Override
    public RoomReservation read(int idReservation) {
        if(readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM_RESERVATION);
            return null;
        } else if(repositoryRoomReservation.read(idReservation) == null){
            System.out.println(ERROR_READ_ROOM_RESERVATION);
        }
        return repositoryRoomReservation.read(idReservation);
    }

    @Override
    public boolean update(int idReservation, String reservationString) {
        RoomReservation reservationOld = repositoryRoomReservation.read(idReservation);
        if(repositoryRoomReservation.readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM_RESERVATION);
            return false;
        } else if(repositoryRoomReservation.read(idReservation) == null){
            System.out.println(ERROR_READ_ROOM_RESERVATION);
            return false;
        }

        RoomReservation reservation = read(idReservation);
        reservation.setCost(repositoryRoom.read(reservation.getIdRoom()).getPrice() * reservation.getNumberOfDays());
        repositoryRoomReservation.delete(idReservation);
        if(createFromObject(reservation)){
            return true;
        } else {
            repositoryRoomReservation.create(reservationOld);
            System.out.println("Old RoomReservation was restored.");
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        if(repositoryRoomReservation.readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM_RESERVATION);
            return false;
        } else if(repositoryRoomReservation.read(id) == null){
            System.out.println(ERROR_READ_ROOM_RESERVATION);
            return false;
        }
        FreeRoom freeRoom1 = readAllFreeRooms()
                .stream()
                .filter(fr -> fr.getRoom().equals(read(id).getIdRoom()))
                .filter(fr -> fr.getEndTime().equals(read(id).getCheckInTime()))
                .findFirst().orElse(null);
        FreeRoom freeRoom2 = readAllFreeRooms()
                .stream()
                .filter(fr -> fr.getRoom().equals(read(id).getIdRoom()))
                .filter(fr -> fr.getStartTime().isEqual(read(id).getCheckOutTime()))
                .findFirst().orElse(null);

        if(freeRoom1 != null && freeRoom2 != null){
            freeRoom1.setEndTime(freeRoom2.getEndTime());
            repositoryFreeRoom.update(freeRoom1);
            repositoryFreeRoom.delete(freeRoom2.getIdFreeRoom());
        } else {
            System.out.println("Something is going wrong in ServiceRoomRepository!!!");
        }
        return repositoryRoomReservation.delete(id);
    }

    @Override
    public int countNumberOfGuestsOnDate(LocalDateTime checkedTime) {
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



    // Refactor All methods with using FreeRooms
    @Override
    public List<FreeRoom> readAllFreeRooms() {
        if(repositoryFreeRoom.readAll() == null){
            System.out.println(ERROR_READ_ALL_FREE_ROOM);
        }
        return repositoryFreeRoom.readAll();
    }

    @Override
    public boolean createFreeRoom(FreeRoom freeRoom) {
        setIdFreeRoomNew(freeRoom);
        return repositoryFreeRoom.create(freeRoom);
    }

    @Override
    public FreeRoom readFreeRoom(int id) {
        return repositoryFreeRoom.read(id);
    }

    @Override
    public boolean updateFreeRoom(FreeRoom freeRoom) {
        return repositoryFreeRoom.update(freeRoom);
    }

    @Override
    public boolean deleteFreeRoom(int id) {
        return delete(id);
    }

    @Override
    public List<FreeRoom> readAllFreeRoomsSortByPrice() {
        return repositoryFreeRoom.readAllFreeRoomsSortByPrice();
    }

    @Override
    public List<FreeRoom> readAllFreeRoomsSortByCapacity() {
        return repositoryFreeRoom.readAllFreeRoomsSortByCapacity();
    }

    @Override
    public List<FreeRoom> readAllFreeRoomsSortByLevel() {
        return repositoryFreeRoom.readAllFreeRoomsSortByLevel();
    }

    @Override
    public int countFreeRoomsOnTime(LocalDateTime checkedDateTime) {
        return repositoryFreeRoom.countFreeRoomsOnTime(checkedDateTime);
    }

    @Override
    public List<FreeRoom> readAllRoomsFreeAtTime(LocalDateTime checkedTime) {
        return repositoryFreeRoom.readAllRoomsFreeAtTime(checkedTime);
    }



    //all private methods for RoomReservations
    private boolean createFromObject(RoomReservation reservation) {
        boolean notVacant = repositoryRoomReservation.readAll().stream()
                .filter(r -> r.getIdRoom() == reservation.getIdRoom())
                .filter(r -> !r.getCheckInTime().isBefore(reservation.getCheckInTime()) &&
                        !r.getCheckOutTime().isAfter(reservation.getCheckOutTime()))
                .toList()
                .isEmpty();
        if(!notVacant){
            return repositoryRoomReservation.create(reservation);
        } else {
            System.out.println(ERROR_ROOM_NOT_AVAILABLE);
            return false;
        }
    }

    private void setIdRoomReservationNew(RoomReservation reservation) {
        int lastId = readAll()
                .stream()
                .map(RoomReservation::getIdRoomReservation)
                .max((o1, o2) -> o1 - o2)
                .orElse(-1);
        reservation.setIdRoomReservation(lastId + 1);
    }

    private void setIdFreeRoomNew(FreeRoom freeRoom) {
        int lastId = readAllFreeRooms()
                .stream()
                .map(FreeRoom::getIdFreeRoom)
                .max((o1, o2) -> o1 - o2)
                .orElse(-1);
        freeRoom.setIdFreeRoom(lastId + 1);
    }

    private LocalDate getDate(String reservationDatum) {
        String[] numbers = reservationDatum.split("-");
        int year = Integer.parseInt(numbers[0]);
        int month = Integer.parseInt(numbers[1]);
        int day = Integer.parseInt(numbers[2]);
        return LocalDate.of(year,month,day);
    }
}
