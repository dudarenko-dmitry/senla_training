package pl.senla.hotel.repository;


import pl.senla.hotel.comparators.RoomReservationsComparatorByCheckOut;
import pl.senla.hotel.comparators.RoomReservationsComparatorByGuestName;
import pl.senla.hotel.entity.*;
import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.storage.DataStorage;
import pl.senla.hotel.storage.DataStorageGuest;
import pl.senla.hotel.storage.DataStorageRoomReservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepositoryRoomReservationCollection implements RepositoryRoomReservation {

    private final DataStorage<RoomReservation> dataStorageRoomReservation;
    private final DataStorage<Guest> dataStorageGuest;

    public RepositoryRoomReservationCollection() {
        this.dataStorageGuest = DataStorageGuest.getDataStorageGuest();
        this.dataStorageRoomReservation = DataStorageRoomReservation.getDataStorageRoomReservation();
    }

    @Override
    public List<RoomReservation> readAll() {
        return dataStorageRoomReservation.getDataList();
    }

    @Override
    public boolean create(RoomReservation roomReservation) {
        readAll().add(roomReservation);
        return true;
    }

    @Override
    public RoomReservation read(int index) {
        return readAll().get(index);
    }

    @Override
    public boolean update(int index, RoomReservation roomReservation) {
        readAll().set(index, roomReservation);
        return true;
    }

    @Override
    public boolean delete(int index) {
        readAll().remove(index);
        return true;
    }

    @Override
    public List<RoomReservation> readAllRoomReservationsSortByGuestName() {
        return readAll().stream().sorted(new RoomReservationsComparatorByGuestName()).toList();
    }

    @Override
    public List<RoomReservation> readAllRoomReservationsSortByGuestCheckOut() {
        return readAll().stream().sorted(new RoomReservationsComparatorByCheckOut()).toList();
    }

    @Override
    public int countNumberOfGuestsOnDate(LocalDateTime checkedTime) {
        return (int) readAll()
                .stream()
                .filter(rr -> checkedTime.isAfter(rr.getCheckInTime()) &&
                        checkedTime.isBefore(rr.getCheckOutTime()))
                .count();
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
                .toList();
        int numberOfReservations = roomReservationsForRoom.size();
        int i = 1;
        while(i <= 3){
            if(numberOfReservations - i >= 0){
                RoomReservation rr = roomReservationsForRoom.get(numberOfReservations - i);
                int idGuest = rr.getIdGuest();
                Guest guest = dataStorageGuest.getDataList().get(idGuest);
                LocalDateTime checkInTime = rr.getCheckInTime();
                LocalDateTime checkOutTime = rr.getCheckOutTime();
                String guestAndDate = "\n" + i + ": " + guest.toString() + ", check-in = " +
                        checkInTime.toString() + ", check-out = " + checkOutTime.toString();
                guestsAndDates.add(guestAndDate);
            } else{
                guestsAndDates.add("\n" + i + ": no reservation");
            }
            i++;
        }
        return guestsAndDates;
    }
}
