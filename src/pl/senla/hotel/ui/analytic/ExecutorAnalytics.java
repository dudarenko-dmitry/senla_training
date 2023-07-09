package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.controller.*;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.main.StartMenuMain;

import java.time.LocalDateTime;
import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;
import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT_NAVIGATE;

public class ExecutorAnalytics implements Executor {

    private final ControllerRoom roomController;
    private final ControllerFacility facilityController;
    private final ControllerRoomReservation roomReservationController;
    private final ControllerGuest guestController;
    private final ControllerOrder orderController;

    public ExecutorAnalytics() {
        this.roomController = new ControllerRoomCollection();
        this.facilityController = new ControllerFacilityCollection();
        this.roomReservationController = new ControllerRoomReservationCollection();
        this.guestController = new ControllerGuestCollection();
        this.orderController = new ControllerOrderCollection();
    }

    @Override
    public void execute(int userSelection) {
        Scanner sc = new Scanner(System.in);
        switch (userSelection) {
            case 1:
                System.out.println(CONSOLE_READ_ALL_ROOMS + SORTED_BY_PRICE +
                        roomController.readAllRoomsSortByPrice());
                break;
            case 2:
                System.out.println(CONSOLE_READ_ALL_ROOMS + SORTED_BY_CAPACITY +
                        roomController.readAllRoomsSortByCapacity());
                break;
            case 3:
                System.out.println(CONSOLE_READ_ALL_ROOMS + SORTED_BY_LEVEL +
                        roomController.readAllRoomsSortByLevel());
                break;
            case 4:
                System.out.println(CONSOLE_READ_ALL_FREE_ROOMS + SORTED_BY_PRICE +
                        roomReservationController.readAllFreeRoomsSortByPrice());
                break;
            case 5:
                System.out.println(CONSOLE_READ_ALL_FREE_ROOMS + SORTED_BY_CAPACITY +
                        roomReservationController.readAllFreeRoomsSortByCapacity());
                break;
            case 6:
                System.out.println(CONSOLE_READ_ALL_FREE_ROOMS + SORTED_BY_LEVEL +
                        roomReservationController.readAllFreeRoomsSortByLevel());
                break;
            case 7:
                System.out.println(CONSOLE_READ_ALL_ROOM_RESERVATIONS + SORTED_BY_GUEST_NAME +
                        roomReservationController.readAllRoomReservationsSortByGuestName());
                break;
            case 8:
                System.out.println(CONSOLE_READ_ALL_ROOM_RESERVATIONS + SORTED_BY_CHECK_OUT +
                        roomReservationController.readAllRoomReservationsSortByGuestCheckOut());
                break;
            case 9:
                LocalDateTime checkedTime = inputDateTime();
                System.out.println(CONSOLE_NUMBER_OF_FREE_ROOMS + checkedTime + ": " +
                        roomReservationController.countFreeRoomsOnTime(checkedTime));
                break;
            case 10:
                System.out.println(CONSOLE_NUMBER_GUEST_TOTAL + guestController.countNumberOfGuestsTotal());
                break;
            case 11:
                checkedTime = inputDateTime();
                System.out.println(CONSOLE_NUMBER_GUEST_IN_HOTEL_NOW + checkedTime + ": " +
                        roomReservationController.countNumberOfGuestsOnDate(checkedTime));
                break;
            case 12:
                checkedTime = inputDateTime();
                System.out.println(CONSOLE_READ_ALL_FREE_ROOMS_TIME +
                        roomReservationController.readAllRoomsFreeAtTime(checkedTime));
                break;
            case 13:
                System.out.print("Input Guest's ID --> ");
                int idGuest = sc.nextInt();
                System.out.println(CONSOLE_GUEST_PAYMENT_FOR_ROOM +
                        roomReservationController.countGuestPaymentForRoom(idGuest));
                break;
            case 14:
                System.out.print("Input Room's ID --> ");
                int idRoom = sc.nextInt();
                System.out.println(CONSOLE_3_GUESTS_AND_DATES + roomReservationController.read3LastGuestAndDatesForRoom(idRoom));
                break;
            case 15:
                System.out.print("Input Guest's ID --> ");
                idGuest = sc.nextInt();
                System.out.println(CONSOLE_READ_ALL_SERVICES_FOR_GUEST + SORTED_BY_PRICE +
                        orderController.readAllServicesSortByPrice(idGuest));
                break;
            case 16:
                System.out.print("Input Guest's ID --> ");
                idGuest = sc.nextInt();
                System.out.println(CONSOLE_READ_ALL_SERVICES_FOR_GUEST + SORTED_BY_DATE +
                        orderController.readAllServicesSortByDate(idGuest));
                break;
            case 17:
                System.out.println(CONSOLE_READ_ALL_FACILITIES + SORTED_BY_CATEGORY +
                        facilityController.readPriceListForServicesSortByCategory());
                break;
            case 18:
                System.out.println(CONSOLE_READ_ALL_FACILITIES + SORTED_BY_PRICE +
                        facilityController.readPriceListForServicesSortByPrice());
                break;
            case 19:
                System.out.print("Input Room's ID --> ");
                idRoom = sc.nextInt();
                roomController.read(idRoom);
                break;
            case 0:
                new StartMenuMain().runMenu();
            default:
                System.out.println(ERROR_INPUT_NAVIGATE);
                new StartMenuAnalytics().runMenu();
        }
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
    } //ready
}
