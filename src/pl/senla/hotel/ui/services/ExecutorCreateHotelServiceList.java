package pl.senla.hotel.ui.services;

import pl.senla.hotel.controller.ControllerRoomReservation;
import pl.senla.hotel.controller.ControllerRoomReservationCollection;
import pl.senla.hotel.entity.services.HotelService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.CONSOLE_CREATE_ROOM_RESERVATION;
import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT_NAVIGATE;

public class ExecutorCreateHotelServiceList {

    private final ControllerRoomReservation roomReservationController;

    public ExecutorCreateHotelServiceList() {
        this.roomReservationController = new ControllerRoomReservationCollection();
    }

    //Later change return from RoomReservation to HotelService and refactor
    protected List<HotelService> createHotelServiceList(int idGuest, int index) { //use only (1) RoomReservation
        Scanner sc = new Scanner(System.in);
        List<HotelService> guestServices = new ArrayList<>();
        switch (index) {
            case 1:
                System.out.print("Input Id Room --> ");
                int idRoom = sc.nextInt();
                String startDateString = inputDateString();
                System.out.print("Input number of days to reserve --> ");
                int numberOfDays = sc.nextInt();

                StringBuilder roomReservationString = new StringBuilder()
                        .append(idGuest).append(";")
                        .append(idRoom).append(";")
                        .append(startDateString).append(";")
                        .append(numberOfDays);

                System.out.println(CONSOLE_CREATE_ROOM_RESERVATION +
                        roomReservationController.create(String.valueOf(roomReservationString)));

//                guestServices.add(roomReservationNew);
                break;
            case 2: // do not use
                System.out.println("Do not use this type of Service: Restaurant. ");
                //logic
                //guestServices.add(new Restaurant());
                break;
            case 3: // do not use
                System.out.println("Do not use this type of Service: Transfer");
                //logic
                //guestServices.add(new Transfer());
                break;
            case 0:
                return guestServices;
            default:
                System.out.println(ERROR_INPUT_NAVIGATE);
                new StartCreateHotelServiceList().runMenu();
        }
        return guestServices; // return List<HotelServices>
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

    private String inputDateString() {
        System.out.println("Select start date of Reservation. ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Input year --> ");
        int year = sc.nextInt();
        System.out.print("Input month --> ");
        int month = sc.nextInt();
        System.out.print("Input day --> ");
        int day = sc.nextInt();
        return year + "-" + month + "-" + day;
    }

    private LocalDateTime inputDateTime() {
        System.out.println("Select start Time of Reservation. ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Input year --> ");
        int year = sc.nextInt();
        System.out.print("Input month --> ");
        int month = sc.nextInt();
        System.out.print("Input day --> ");
        int day = sc.nextInt();
        System.out.print("Input hour --> ");
        int hour = sc.nextInt();
        System.out.print("Input minute --> ");
        int minute = sc.nextInt();
        return LocalDateTime.of(year, month, day, hour, minute);
    }

    private String inputDateTimeString() {
        System.out.println("Select start Time of Reservation. ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Input year --> ");
        int year = sc.nextInt();
        System.out.print("Input month --> ");
        int month = sc.nextInt();
        System.out.print("Input day --> ");
        int day = sc.nextInt();
        System.out.print("Input hour --> ");
        int hour = sc.nextInt();
        System.out.print("Input minute --> ");
        int minute = sc.nextInt();
        return year + "-" + month + "-" + day + "-" + hour + "-" + minute;
    }
}
