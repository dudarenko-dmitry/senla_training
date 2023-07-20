package pl.senla.hotel.ui.services;

import pl.senla.hotel.controller.ControllerRoomReservation;
import pl.senla.hotel.controller.ControllerRoomReservationCollection;

import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;

public class ExecutorCreateHotelService {

    private final ControllerRoomReservation roomReservationController;

    public ExecutorCreateHotelService() {
        this.roomReservationController = new ControllerRoomReservationCollection();
    }

    //Later change return from RoomReservation to HotelService and refactor
    protected boolean createHotelServiceForGuest(int idGuest, int index) { //use only (1) RoomReservation
        Scanner sc = new Scanner(System.in);
        switch (index) {
            case 1 -> {
                System.out.print("Input Id Room --> ");
                int idRoom = sc.nextInt();
                String startDateString = inputDateString();
                System.out.print("Input number of days to reserve --> ");
                int numberOfDays = sc.nextInt();
                String roomReservationString = idGuest + ";" +
                        idRoom + ";" +
                        startDateString + ";" +
                        numberOfDays;
                return roomReservationController.create(roomReservationString);
            }
            case 2 -> {
                System.out.println("Do not use this type of Service: Restaurant. ");
                //logic
                return true;
            }
            case 3 -> {
                System.out.println("Do not use this type of Service: Transfer");
                //logic
                return true;
            }
            case 0 -> {
                System.out.println(CONSOLE_CREATE_ORDER);
                return true;
            }
            default -> {
                System.out.println(ERROR_INPUT_NAVIGATE);
                new StartCreateHotelService().runMenu(idGuest);
            }
        }
        return true;
    }

    private String inputDateString() {
        System.out.println("Input start date of Reservation: ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Input year --> ");
        int year = sc.nextInt();
        System.out.print("Input month --> ");
        int month = sc.nextInt();
        System.out.print("Input day --> ");
        int day = sc.nextInt();
        return year + "-" + month + "-" + day;
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
    } // will be used with Restaurant and Transfer.
}
