package pl.senla.hotel.utils;

import pl.senla.hotel.entity.facilities.*;
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

    public static String[] convertFacilityToString(HotelFacility facility) {
        int idFacility = facility.getIdFacility();
        CategoryFacility categoryFacility = facility.getCategory();
        String nameFacility = facility.getNameFacility();
        int price = facility.getPrice();
        int capacity = facility.getCapacity();
        switch (categoryFacility) {
            case ROOM -> {
                Room hsRoom = (Room) facility;
                RoomLevel roomLevel = hsRoom.getRoomLevel();
                RoomStatus roomStatus = hsRoom.getRoomStatus();
                return new String[] {
                        String.valueOf(idFacility),
                        categoryFacility.name(),
                        nameFacility,
                        String.valueOf(price),
                        String.valueOf(capacity),
                        roomLevel.name(),
                        roomStatus.name()
                };
            }
            case TABLE -> System.out.println("This Hotel Facility (Table) was not created.");
            case TRANSPORT -> System.out.println("This Hotel Facility (Transport) was not created.");
            default -> throw new IllegalStateException("Unexpected value: " + categoryFacility.name());
        }
        return new String[0]; // change after creating of rest entities
    }
}
