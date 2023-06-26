package pl.senla.hotel.service;

import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.FreeRoom;
import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.repository.RepositoryFreeRoom;
import pl.senla.hotel.repository.RepositoryFreeRoomCollection;
import pl.senla.hotel.repository.RepositoryRoomReservation;
import pl.senla.hotel.repository.RepositoryRoomReservationCollection;

import java.time.LocalDateTime;
import java.util.List;

import static pl.senla.hotel.constant.FreeRoomConstant.ERROR_READ_ALL_FREE_ROOM;
import static pl.senla.hotel.constant.RoomReservationConstant.*;

public class ServiceRoomReservationImpl implements ServiceRoomReservation {

    private final RepositoryRoomReservation roomReservationRepository = new RepositoryRoomReservationCollection();
    private final RepositoryFreeRoom freeRoomRepository = new RepositoryFreeRoomCollection();

    @Override
    public List<RoomReservation> readAll() {
        if(roomReservationRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM_RESERVATION);
        }
        return roomReservationRepository.readAll();
    }

    @Override
    public boolean create(RoomReservation reservation) {
        FreeRoom checkedFreeRoom = freeRoomRepository
                .readAll()
                .stream()
                .filter(fr -> fr.getRoom().equals(reservation.getRoom()))
                .filter(fr -> fr.getStartTime().isBefore(reservation.getCheckInTime()) &&
                        fr.getEndTime().isAfter(reservation.getCheckOutTime()))
                .findFirst()
                .orElse(null);
        if(reservation.getGuest() == null){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT);
            return false;
        } else if(reservation.getRoom() == null){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_ROOM);
            return false;
        } else if(roomReservationRepository.read(reservation.getIdRoomReservation()) != null) {
            System.out.println(ERROR_CREATE_ROOM_RESERVATION);
            return false;
        } else if (checkedFreeRoom == null){
            System.out.println(ERROR_ROOM_NOT_AVAILABLE);
            return false;
        }

        LocalDateTime checkedFreeRoomEndTime = freeRoomRepository.read(checkedFreeRoom.getIdFreeRoom()).getEndTime();
        checkedFreeRoom.setEndTime(reservation.getCheckInTime());
        updateFreeRoom(checkedFreeRoom);

        Room checkedRoomForFreeRoom = freeRoomRepository.read(checkedFreeRoom.getIdFreeRoom()).getRoom();
//        int newFreeRoomId = freeRoomRepository.readAll()
//                .stream()
//                .map(FreeRoom::getIdFreeRoom)
//                .max((o1, o2) -> o1 - o2)
//                .orElse(0);
        FreeRoom freeRoomNew = new FreeRoom(checkedRoomForFreeRoom, reservation.getCheckOutTime(), checkedFreeRoomEndTime);
//        setIdFreeRoomNew(freeRoomNew);
        createFreeRoom(freeRoomNew);
        setIdRoomReservationNew(reservation);
        return roomReservationRepository.create(reservation);
    }

    @Override
    public RoomReservation read(int id) {
        if(roomReservationRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM_RESERVATION);
            return null;
        } else if(roomReservationRepository.read(id) == null){
            System.out.println(ERROR_READ_ROOM_RESERVATION);
        }
        return roomReservationRepository.read(id);
    }

    @Override
    public boolean update(RoomReservation reservation) {
        if(roomReservationRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM_RESERVATION);
            return false;
        } else if(roomReservationRepository.read(reservation.getIdRoomReservation()) == null){
            System.out.println(ERROR_READ_ROOM_RESERVATION);
            return false;
        }
        reservation.setCost(reservation.getRoom().getPrice() * reservation.getNumberOfDays());
        delete(reservation.getIdRoomReservation());
        create(reservation);
        return true;
    }

    @Override
    public boolean delete(int id) {
        if(roomReservationRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM_RESERVATION);
            return false;
        } else if(roomReservationRepository.read(id) == null){
            System.out.println(ERROR_READ_ROOM_RESERVATION);
            return false;
        }
        FreeRoom freeRoom1 = readAllFreeRooms()
                .stream()
                .filter(fr -> fr.getRoom().equals(read(id).getRoom()))
                .filter(fr -> fr.getEndTime().equals(read(id).getCheckInTime()))
                .findFirst().orElse(null);
        FreeRoom freeRoom2 = readAllFreeRooms()
                .stream()
                .filter(fr -> fr.getRoom().equals(read(id).getRoom()))
                .filter(fr -> fr.getStartTime().isEqual(read(id).getCheckOutTime()))
                .findFirst().orElse(null);

        if(freeRoom1 != null && freeRoom2 != null){
            freeRoom1.setEndTime(freeRoom2.getEndTime());
            freeRoomRepository.update(freeRoom1);
            freeRoomRepository.delete(freeRoom2.getIdFreeRoom());
        } else {
            System.out.println("Something is going wrong in ServiceRoomRepository!!!");
        }
        return roomReservationRepository.delete(id);
    }

    @Override
    public List<FreeRoom> readAllFreeRooms() {
        if(freeRoomRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_FREE_ROOM);
        }
        return freeRoomRepository.readAll();
    }

    @Override
    public boolean createFreeRoom(FreeRoom freeRoom) {
        setIdFreeRoomNew(freeRoom);
        return freeRoomRepository.create(freeRoom);
    }

    @Override
    public FreeRoom readFreeRoom(int id) {
        return freeRoomRepository.read(id);
    }

    @Override
    public boolean updateFreeRoom(FreeRoom freeRoom) {
        return freeRoomRepository.update(freeRoom);
    }

    @Override
    public boolean deleteFreeRoom(int id) {
        return delete(id);
    }

    @Override
    public List<FreeRoom> readAllFreeRoomsSortByPrice() {
        return freeRoomRepository.readAllFreeRoomsSortByPrice();
    }

    @Override
    public List<FreeRoom> readAllFreeRoomsSortByCapacity() {
        return freeRoomRepository.readAllFreeRoomsSortByCapacity();
    }

    @Override
    public List<FreeRoom> readAllFreeRoomsSortByLevel() {
        return freeRoomRepository.readAllFreeRoomsSortByLevel();
    }

    @Override
    public List<RoomReservation> readAllRoomReservationsSortByGuestName() {
        return roomReservationRepository.readAllRoomReservationsSortByGuestName();
    }

    @Override
    public List<RoomReservation> readAllRoomReservationsSortByGuestCheckOut() {
        return roomReservationRepository.readAllRoomReservationsSortByGuestCheckOut();
    }

    @Override
    public int countFreeRoomsOnTime(LocalDateTime checkedDateTime) {
        return freeRoomRepository.countFreeRoomsOnTime(checkedDateTime);
    }

    @Override
    public int countNumberOfGuestsOnDate(LocalDateTime checkedTime) {
        return roomReservationRepository.countNumberOfGuestsOnDate(checkedTime);
    }

    @Override
    public List<FreeRoom> readAllRoomsFreeAtTime(LocalDateTime checkedTime) {
        return freeRoomRepository.readAllRoomsFreeAtTime(checkedTime);
    }

    @Override
    public int countGuestPaymentForRoom(int idGuest) {
        return roomReservationRepository.countGuestPaymentForRoom(idGuest);
    }

    @Override
    public List<String> read3LastGuestAndDatesForRoom(int idRoom) {
        return roomReservationRepository.read3LastGuestAndDatesForRoom(idRoom);
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
