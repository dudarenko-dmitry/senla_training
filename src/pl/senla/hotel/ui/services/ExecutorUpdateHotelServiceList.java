package pl.senla.hotel.ui.services;

import pl.senla.hotel.controller.ControllerRoomReservation;
import pl.senla.hotel.controller.ControllerRoomReservationCollection;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.RoomReservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.CONSOLE_READ_ALL_SERVICES;
import static pl.senla.hotel.constant.HotelConstant.HOTEL_CHECK_IN_TIME;

public class ExecutorUpdateHotelServiceList {

    private final ControllerRoomReservation roomReservationController;

    public ExecutorUpdateHotelServiceList() {
        this.roomReservationController = new ControllerRoomReservationCollection();
    }

    protected List<HotelService> updateHotelServiceList(List<HotelService> services, int typeOfServiceInt) {
        Scanner sc = new Scanner(System.in);
        switch (typeOfServiceInt) {
            case 1:
                System.out.println("Update Room's Reservation: ");
                System.out.println(CONSOLE_READ_ALL_SERVICES + services);
                System.out.print("Input Service's ID to Update --> ");
                int idService = sc.nextInt();
                System.out.println("Input new Date. ");
                LocalDate startDate = inputDate();
                System.out.print("Input number of days to reserve --> ");
                int numberOfDays = sc.nextInt();
                RoomReservation roomReservation = roomReservationController.read(idService);
                roomReservation.setCheckInTime(LocalDateTime.of(startDate, HOTEL_CHECK_IN_TIME));
                roomReservation.setNumberOfDays(numberOfDays);
                roomReservationController.update(-1, "");
                break;
            case 2:
                System.out.println("Update Restaurant's Reservation: ");
                System.out.println(services);
                // do not use
                break;
            case 3:
                System.out.println("Update Transfer's Reservation: ");
                System.out.println(services);
                // do not use 2
                break;
            case 0:
                return services;
            default:
                new StartUpdateHotelServiceList().runMenu(services);
        }
        return services;
    }

    private LocalDate inputDate() {
        System.out.println("Select start date of Reservation. ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Input year --> ");
        int year = sc.nextInt();
        System.out.print("Input month --> ");
        int month = sc.nextInt();
        System.out.print("Input day --> ");
        int day = sc.nextInt();
        return LocalDate.of(year, month, day);
    }

}
