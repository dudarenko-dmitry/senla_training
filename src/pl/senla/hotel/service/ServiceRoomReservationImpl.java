package pl.senla.hotel.service;

import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.FreeRoom;
import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.repository.*;

import java.time.LocalDateTime;
import java.util.List;

import static pl.senla.hotel.constant.FreeRoomConstant.ERROR_READ_ALL_FREE_ROOM;
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
    public boolean create(RoomReservation reservation) {
        FreeRoom checkedFreeRoom = repositoryFreeRoom
                .readAll()
                .stream()
                .filter(fr -> fr.getRoom().equals(reservation.getIdRoom()))
                .filter(fr -> fr.getStartTime().isBefore(reservation.getCheckInTime()) &&
                        fr.getEndTime().isAfter(reservation.getCheckOutTime()))
                .findFirst()
                .orElse(null);
        if(reservation.getIdGuest() == -1){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT);
            return false;
        } else if(reservation.getIdRoom() == -1){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_ROOM);
            return false;
        } else if(read(reservation.getIdRoomReservation()) != null) {
            System.out.println(ERROR_CREATE_ROOM_RESERVATION);
            return false;
        } else if (checkedFreeRoom == null){
            System.out.println(ERROR_ROOM_NOT_AVAILABLE);
            return false;
        }

        LocalDateTime checkedFreeRoomEndTime = repositoryFreeRoom.read(checkedFreeRoom.getIdFreeRoom()).getEndTime();
        checkedFreeRoom.setEndTime(reservation.getCheckInTime());
        updateFreeRoom(checkedFreeRoom);

        Room checkedRoomForFreeRoom = repositoryFreeRoom.read(checkedFreeRoom.getIdFreeRoom()).getRoom();
        FreeRoom freeRoomNew = new FreeRoom(checkedRoomForFreeRoom, reservation.getCheckOutTime(), checkedFreeRoomEndTime);
        createFreeRoom(freeRoomNew);
        setIdRoomReservationNew(reservation);
        return repositoryRoomReservation.create(reservation);
    }

    @Override
    public RoomReservation read(int id) {
        if(readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM_RESERVATION);
            return null;
        } else if(repositoryRoomReservation.read(id) == null){
            System.out.println(ERROR_READ_ROOM_RESERVATION);
        }
        return repositoryRoomReservation.read(id);
    }

    @Override
    public boolean update(RoomReservation reservation) {
        if(repositoryRoomReservation.readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM_RESERVATION);
            return false;
        } else if(repositoryRoomReservation.read(reservation.getIdRoomReservation()) == null){
            System.out.println(ERROR_READ_ROOM_RESERVATION);
            return false;
        }
        reservation.setCost(reservation.getIdRoom().getPrice() * reservation.getNumberOfDays());
        delete(reservation.getIdRoomReservation());
        create(reservation);
        return true;
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
    public List<RoomReservation> readAllRoomReservationsSortByGuestName() {
        return repositoryRoomReservation.readAllRoomReservationsSortByGuestName();
    }

    @Override
    public List<RoomReservation> readAllRoomReservationsSortByGuestCheckOut() {
        return repositoryRoomReservation.readAllRoomReservationsSortByGuestCheckOut();
    }

    @Override
    public int countFreeRoomsOnTime(LocalDateTime checkedDateTime) {
        return repositoryFreeRoom.countFreeRoomsOnTime(checkedDateTime);
    }

    @Override
    public int countNumberOfGuestsOnDate(LocalDateTime checkedTime) {
        return repositoryRoomReservation.countNumberOfGuestsOnDate(checkedTime);
    }

    @Override
    public List<FreeRoom> readAllRoomsFreeAtTime(LocalDateTime checkedTime) {
        return repositoryFreeRoom.readAllRoomsFreeAtTime(checkedTime);
    }

    @Override
    public int countGuestPaymentForRoom(int idGuest) {
        return repositoryRoomReservation.countGuestPaymentForRoom(idGuest);
    }

    @Override
    public List<String> read3LastGuestAndDatesForRoom(int idRoom) {
        return repositoryRoomReservation.read3LastGuestAndDatesForRoom(idRoom);
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
}
