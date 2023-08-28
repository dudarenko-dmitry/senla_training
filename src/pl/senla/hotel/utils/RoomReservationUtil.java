package pl.senla.hotel.utils;

import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.facilities.Room;
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
        String category = facility.getCategory();
        String nameFacility = facility.getNameFacility();
        int price = facility.getPrice();
        int capacity = facility.getCapacity();
        switch (category) {
            case "Room" -> {
                Room hsRoom = (Room) facility;
                String roomLevel = hsRoom.getRoomLevel();
                String roomStatus = hsRoom.getRoomStatus();
                return new String[] {
                        String.valueOf(idFacility),
                        category,
                        nameFacility,
                        String.valueOf(price),
                        String.valueOf(capacity),
                        roomLevel,
                        roomStatus
                };
            }
            case "Table" -> System.out.println("This Hotel Facility (Table) was not created.");
            case "Transport" -> System.out.println("This Hotel Facility (Transport) was not created.");
            default -> throw new IllegalStateException("Unexpected value: " + category);
        }
        return new String[0]; // change after creating of rest entities
    }
}
