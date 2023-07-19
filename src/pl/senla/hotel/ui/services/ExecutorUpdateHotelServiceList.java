package pl.senla.hotel.ui.services;

import pl.senla.hotel.controller.ControllerOrder;
import pl.senla.hotel.controller.ControllerOrderCollection;
import pl.senla.hotel.controller.ControllerRoomReservation;
import pl.senla.hotel.controller.ControllerRoomReservationCollection;

import pl.senla.hotel.entity.services.TypeOfService;

import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.CONSOLE_READ_ALL_SERVICES;
import static pl.senla.hotel.constant.ConsoleConstant.CONSOLE_READ_ORDER;

public class ExecutorUpdateHotelServiceList {

    private final ControllerOrder orderController;
    private final ControllerRoomReservation roomReservationController;
    // add all other Controllers for different type of Hotel's Services

    public ExecutorUpdateHotelServiceList() {
        this.orderController = new ControllerOrderCollection();
        this.roomReservationController = new ControllerRoomReservationCollection();
        // add all other Controllers for different type of Hotel's Services
    }

    protected boolean updateHotelServiceList(int idOrderUpdate, int typeOfServiceInt) {
        System.out.println(CONSOLE_READ_ORDER + orderController.read(idOrderUpdate));
        Scanner sc = new Scanner(System.in);
        switch (typeOfServiceInt) {
            case 1:
                System.out.println("Update Room's Reservation: ");
                System.out.println(CONSOLE_READ_ALL_SERVICES + orderController.read(idOrderUpdate)
                        .getServices()
                        .stream()
                        .filter(s -> s.getTypeOfService().equals(TypeOfService.ROOM_RESERVATION))
                        .toList()
                        .toString());

                System.out.print("Input RoomReservation's ID to Update --> ");
                int idRoomReservation = sc.nextInt();
                System.out.println("Input new Date. ");
                String checkInDateString = inputDateString();
                System.out.print("Input number of days to reserve --> ");

                int numberOfDays = sc.nextInt();

                StringBuilder roomReservationUpdateString = new StringBuilder()
                        .append(checkInDateString).append(":")
                        .append(numberOfDays);
                return roomReservationController.update(idRoomReservation, String.valueOf(roomReservationUpdateString));
            case 2:
                System.out.println("Update Restaurant's Reservation: ");
                // do not use
                return true;
            case 3:
                System.out.println("Update Transfer's Reservation: ");
                // do not use 2
                return true;
            default:
                return false;
        }
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
}
