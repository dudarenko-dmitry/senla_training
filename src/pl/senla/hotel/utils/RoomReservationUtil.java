package pl.senla.hotel.utils;

import pl.senla.hotel.entity.services.CsvRoomReservation;
import pl.senla.hotel.entity.services.RoomReservation;

import java.time.LocalDateTime;

public final class RoomReservationUtil {

    private RoomReservationUtil() {
    }

    public static RoomReservation convertCsvToRoomReservation(CsvRoomReservation csv) {
        RoomReservation reservation = new RoomReservation();
        reservation.setIdService(csv.getIdService());
        reservation.setIdOrder(csv.getIdOrder());
        reservation.setTypeOfService(csv.getTypeOfService());
        reservation.setIdGuest(csv.getIdGuest());
        reservation.setIdRoom(csv.getIdRoom());
        reservation.setCheckInTime(LocalDateTime.parse(csv.getCheckInTime()));
        reservation.setNumberOfDays(csv.getNumberOfDays());
        reservation.setCheckOutTime(LocalDateTime.parse(csv.getCheckOutTime()));
        reservation.setCost(csv.getCost());
        return reservation;
    }
}
