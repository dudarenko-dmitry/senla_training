package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.controller.*;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.main.StartMenuMain;

import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;
import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

public class ExecutorAnalytics implements Executor {

    private static Executor executor;
    private final ControllerRoom roomController;
    private final ControllerFacility facilityController;
    private final ControllerRoomReservation roomReservationController;
    private final ControllerGuest guestController;
    private final ControllerOrder orderController;

    private ExecutorAnalytics() {
        this.roomController = ControllerRoomCollection.getControllerRoom();
        this.facilityController = ControllerFacilityCollection.getControllerFacility();
        this.roomReservationController = ControllerRoomReservationCollection.getControllerRoomReservation();
        this.guestController = ControllerGuestCollection.getControllerGuest();
        this.orderController = ControllerOrderCollection.getControllerOrder();
    }

    public static Executor getExecutorAnalytics(){
        if (executor == null) {
            executor = new ExecutorAnalytics();
        }
        return executor;
    }

    @Override
    public void execute(int userSelection) {
        Scanner sc = new Scanner(System.in);
        switch (userSelection) {
            case 1: // ready
                System.out.println(CONSOLE_READ_ALL_ROOMS + SORTED_BY_PRICE +
                        facilityController.readAllRoomsSortByPrice());
                break;
            case 2: // ready
                System.out.println(CONSOLE_READ_ALL_ROOMS + SORTED_BY_CAPACITY +
                        facilityController.readAllRoomsSortByCapacity());
                break;
            case 3: // ready
                System.out.println(CONSOLE_READ_ALL_ROOMS + SORTED_BY_LEVEL +
                        facilityController.readAllRoomsSortByLevel());
                break;
            case 4: // ready
                String checkedTimeString = inputDateTimeString();
                System.out.println(CONSOLE_READ_ALL_FREE_ROOMS + SORTED_BY_PRICE +
                        roomReservationController.readAllFreeRoomsSortByPrice(checkedTimeString));
                break;
            case 5: // ready
                checkedTimeString = inputDateTimeString();
                System.out.println(CONSOLE_READ_ALL_FREE_ROOMS + SORTED_BY_CAPACITY +
                        roomReservationController.readAllFreeRoomsSortByCapacity(checkedTimeString));
                break;
            case 6: // ready
                checkedTimeString = inputDateTimeString();
                System.out.println(CONSOLE_READ_ALL_FREE_ROOMS + SORTED_BY_LEVEL +
                        roomReservationController.readAllFreeRoomsSortByLevel(checkedTimeString));
                break;
            case 7: // ready
                System.out.println(CONSOLE_READ_ALL_ROOM_RESERVATIONS + SORTED_BY_GUEST_NAME +
                        roomReservationController.readAllRoomReservationsSortByGuestName());
                break;
            case 8: // ready
                System.out.println(CONSOLE_READ_ALL_ROOM_RESERVATIONS + SORTED_BY_CHECK_OUT +
                        roomReservationController.readAllRoomReservationsSortByGuestCheckOut());
                break;
            case 9:
                checkedTimeString = inputDateTimeString();
                System.out.println(CONSOLE_NUMBER_OF_FREE_ROOMS + checkedTimeString + ": " +
                        roomReservationController.countFreeRoomsInTime(checkedTimeString));
                break;
            case 10: // ready
                System.out.println(CONSOLE_NUMBER_GUEST_TOTAL + guestController.countNumberOfGuestsTotal());
                break;
            case 11: // ready
                checkedTimeString = inputDateTimeString();
                System.out.println(CONSOLE_NUMBER_GUEST_IN_HOTEL_NOW + checkedTimeString + ": " +
                        roomReservationController.countNumberOfGuestsOnDate(checkedTimeString));
                break;
            case 12:
                checkedTimeString = inputDateTimeString();
                System.out.println(CONSOLE_READ_ALL_FREE_ROOMS_TIME +
                        roomReservationController.readAllRoomsFreeInTime(checkedTimeString));
                break;
            case 13: // ready
                System.out.print(INPUT_ID_GUEST);
                int idGuest = sc.nextInt();
                System.out.println(CONSOLE_GUEST_PAYMENT_FOR_ROOM +
                        roomReservationController.countGuestPaymentForRoom(idGuest));
                break;
            case 14: // ready
                System.out.print(INPUT_ID_ROOM);
                int idRoom = sc.nextInt();
                System.out.println(CONSOLE_3_GUESTS_AND_DATES + roomReservationController.read3LastGuestAndDatesForRoom(idRoom));
                break;
            case 15:
                System.out.print(INPUT_ID_GUEST);
                idGuest = sc.nextInt();
                System.out.println(CONSOLE_READ_ALL_SERVICES_FOR_GUEST + SORTED_BY_PRICE +
                        orderController.readAllServicesForGuestSortByPrice(idGuest));
                break;
            case 16:
                System.out.print(INPUT_ID_GUEST);
                idGuest = sc.nextInt();
                System.out.println(CONSOLE_READ_ALL_SERVICES_FOR_GUEST + SORTED_BY_DATE +
                        orderController.readAllServicesForGuestSortByDate(idGuest));
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
                System.out.print(INPUT_ID_ROOM);
                idRoom = sc.nextInt();
                roomController.read(idRoom);
                break;
            case 0:
                StartMenuMain.getStartMenu().runMenu();
            default:
                System.out.println(ERROR_INPUT);
                StartMenuAnalytics.getStartMenuAnalytics().runMenu();
        }
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
