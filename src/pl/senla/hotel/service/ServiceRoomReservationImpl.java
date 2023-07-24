package pl.senla.hotel.service;

import pl.senla.hotel.entity.services.FreeRoom;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.entity.services.TypeOfService;
import pl.senla.hotel.repository.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;
import static pl.senla.hotel.constant.FreeRoomConstant.ERROR_READ_ALL_FREE_ROOM;
import static pl.senla.hotel.constant.HotelConstant.*;
import static pl.senla.hotel.constant.RoomReservationConstant.*;

public class ServiceRoomReservationImpl implements ServiceRoomReservation {

    private static ServiceRoomReservation serviceRoomReservation;
    private final RepositoryHotelService repositoryHotelService;
    private final RepositoryRoomReservation repositoryRoomReservation; // delete?
    private final RepositoryFreeRoom repositoryFreeRoom; // delete
    private final RepositoryGuest repositoryGuest;
    private final RepositoryRoom repositoryRoom;

    private ServiceRoomReservationImpl() {
        this.repositoryHotelService = RepositoryHotelServiceCollection.getRepositoryHotelService();
        this.repositoryRoomReservation = RepositoryRoomReservationCollection.getRepositoryRoomReservation(); // delete?
        this.repositoryFreeRoom = new RepositoryFreeRoomCollection(); // delete
        this.repositoryGuest = RepositoryGuestCollection.getRepositoryGuest();
        this.repositoryRoom = RepositoryRoomCollection.getRepositoryRoom();
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
        int idGuest = Integer.parseInt(reservationData[0]);
        int idRoom = Integer.parseInt(reservationData[1]);

        if(idGuest < 0 || idGuest >= repositoryGuest.readAll().size()){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT);
            return false;
        } else if(idRoom < 0 || idRoom >= repositoryRoom.readAll().size()){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_ROOM);
            return false;
        } else {
            LocalDate checkInDate = getDate(reservationData[2]);
            LocalDateTime checkInTime = LocalDateTime.of(checkInDate, HOTEL_CHECK_IN_TIME);
            int numberOfDays = Integer.parseInt(reservationData[3]);
            LocalDateTime checkOutTime = LocalDateTime.of(checkInDate.plusDays(Integer.parseInt(reservationData[3])),
                    HOTEL_CHECK_OUT_TIME);

            boolean isVacant = readAll().stream()
                    .filter(r -> r.getIdRoom() == idRoom)
                    .filter(r -> (r.getCheckInTime().isAfter(checkInTime) && r.getCheckInTime().isBefore(checkOutTime)) ||
                            (r.getCheckOutTime().isAfter(checkInTime) && r.getCheckOutTime().isBefore(checkOutTime)))
                    .toList()
                    .isEmpty();

            if(isVacant){
                RoomReservation reservation = new RoomReservation();
                reservation.setIdService(-1);
                reservation.setIdGuest(idGuest);
                reservation.setIdRoom(idRoom);
                reservation.setCheckInTime(checkInTime);
                reservation.setNumberOfDays(numberOfDays);
                reservation.setTypeOfService(TypeOfService.ROOM_RESERVATION.getTypeName());
                reservation.setCheckOutTime(checkOutTime);
                reservation.setCost(repositoryRoom.read(idRoom).getPrice() * numberOfDays);
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
        reservationUpdate.setCost(repositoryRoom.read(reservationOld.getIdRoom()).getPrice() * numberOfDaysNew);

        delete(idReservation);
        if(createFromObject(reservationUpdate)){
            System.out.println("CHECKING from ServiceRoomRes.");// checking if is it created
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



    // Refactor All methods: delete using FreeRooms
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
        return repositoryFreeRoom.update(-1, freeRoom);
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
        int lastId = repositoryHotelService.readAll()
                .stream()
                .map(HotelService::getIdService)
                .max(Comparator.comparingInt(o -> o))
                .orElse(-1);
        reservation.setIdService(lastId + 1);
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
