package pl.senla.hotel.utils;

import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.entity.services.TypeOfService;
import pl.senla.hotel.service.ServiceRoom;

import java.time.LocalDateTime;

public final class RoomReservationUtil {

    @GetInstance(beanName = "ServiceRoomImpl")
    private final ServiceRoom serviceRoom;

    private RoomReservationUtil(ServiceRoom serviceRoom) {
        this.serviceRoom = serviceRoom;
    }

    public static RoomReservation convertCsvToRoomReservation(String csv, ServiceRoom serviceRoom) {
        String[] text = csv.split(";");
        RoomReservation reservation = new RoomReservation(serviceRoom);
        reservation.setIdService(Integer.valueOf(text[0].substring(1,text[0].length() - 1)));
        reservation.setIdOrder(Integer.valueOf(text[1].substring(1,text[1].length() - 1)));
        reservation.setTypeOfService(TypeOfService.valueOf(text[2].substring(1,text[2].length() - 1)));
        reservation.setIdGuest(Integer.valueOf(text[3].substring(1,text[3].length() - 1)));
        reservation.setIdRoom(Integer.valueOf(text[4].substring(1,text[4].length() - 1)));
        reservation.setCheckInTime(LocalDateTime.parse(text[5].substring(1,text[5].length() - 1)));
        reservation.setNumberOfDays(Integer.valueOf(text[6].substring(1,text[6].length() - 1)));
        reservation.setCheckOutTime(LocalDateTime.parse(text[7].substring(1,text[7].length() - 1)));
        reservation.setCost(Integer.valueOf(text[8].substring(1,text[8].length() - 1)));
        return reservation;
    }

    public static String[] convertHotelServiceToString(HotelService hs) {
        String idService = String.valueOf(hs.getIdService());
        String idOrder = String.valueOf(hs.getIdOrder());
        TypeOfService typeOfService = hs.getTypeOfService();
        String idGuest = String.valueOf(hs.getIdGuest());
        switch (typeOfService) {
            case ROOM_RESERVATION -> {
                RoomReservation hsReservation = (RoomReservation) hs;
                String idRoom = String.valueOf(hsReservation.getIdRoom());
                String checkInTime = String.valueOf(hsReservation.getCheckInTime());
                String numberOfDays = String.valueOf(hsReservation.getNumberOfDays());
                String checkOutTime = String.valueOf(hsReservation.getCheckOutTime());
                String cost = String.valueOf(hsReservation.getCost());
                return new String[] {
                        idService,
                        idOrder,
                        typeOfService.name(),
                        idGuest,
                        idRoom,
                        checkInTime,
                        numberOfDays,
                        checkOutTime,
                        cost
                };
            }
            case RESTAURANT -> System.out.println("This Hotel Service (Restaurant) was not created.");
            case TRANSFER -> System.out.println("This Hotel Service (Transfer) was not created.");
            default -> throw new IllegalStateException("Unexpected value: " + typeOfService);
        }
        return new String[0]; // change after creating of rest services
    }
}
