package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.controller.*;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.main.StartMenuMain;

import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;
import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

@AppComponent
public class ExecutorAnalytics implements Executor {

    private static Executor executor;
    @GetInstance(beanName = "ControllerRoomCollection")
    private final ControllerRoom roomController;
    @GetInstance(beanName = "ControllerFacilityCollection")
    private final ControllerFacility facilityController;
    @GetInstance(beanName = "ControllerRoomReservationCollection")
    private final ControllerRoomReservation roomReservationController;
    @GetInstance(beanName = "ControllerGuestCollection")
    private final ControllerGuest guestController;
    @GetInstance(beanName = "ControllerOrderCollection")
    private final ControllerOrder orderController;
    @GetInstance(beanName = "NavigatorMainMenu")
    private final Navigator navigatorMain;
    @GetInstance(beanName = "ExecutorMain")
    private final Executor executorMain;
    @GetInstance(beanName = "NavigatorAnalytics")
    private final Navigator navigator;

    private ExecutorAnalytics(ControllerRoom roomController,
                              ControllerFacility facilityController,
                              ControllerRoomReservation roomReservationController,
                              ControllerGuest guestController,
                              ControllerOrder orderController,
                              Navigator navigatorMain,
                              Executor executorMain,
                              Navigator navigator) {
        this.roomController = roomController;
        this.facilityController = facilityController;
        this.roomReservationController = roomReservationController;
        this.guestController = guestController;
        this.orderController = orderController;
        this.navigatorMain = navigatorMain;
        this.executorMain = executorMain;
        this.navigator = navigator;
    }

    public static Executor getSingletonInstance(ControllerRoom roomController,
                                                ControllerFacility facilityController,
                                                ControllerRoomReservation roomReservationController,
                                                ControllerGuest guestController,
                                                ControllerOrder orderController,
                                                Navigator navigatorMain,
                                                Executor executorMain,
                                                Navigator navigator){
        if (executor == null) {
            executor = new ExecutorAnalytics(roomController, facilityController, roomReservationController,
                    guestController, orderController, navigatorMain, executorMain, navigator);
        }
        return executor;
    }

    @Override
    public void execute(int userSelection) throws IllegalAccessException {
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
                String checkedTimeString4 = inputDateTimeString();
                System.out.println(CONSOLE_READ_ALL_FREE_ROOMS + SORTED_BY_PRICE +
                        roomReservationController.readAllFreeRoomsSortByPrice(checkedTimeString4));
                break;
            case 5: // ready
                String checkedTimeString5 = inputDateTimeString();
                System.out.println(CONSOLE_READ_ALL_FREE_ROOMS + SORTED_BY_CAPACITY +
                        roomReservationController.readAllFreeRoomsSortByCapacity(checkedTimeString5));
                break;
            case 6: // ready
                String checkedTimeString6 = inputDateTimeString();
                System.out.println(CONSOLE_READ_ALL_FREE_ROOMS + SORTED_BY_LEVEL +
                        roomReservationController.readAllFreeRoomsSortByLevel(checkedTimeString6));
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
                String checkedTimeString9 = inputDateTimeString();
                System.out.println(CONSOLE_NUMBER_OF_FREE_ROOMS + checkedTimeString9 + ": " +
                        roomReservationController.countFreeRoomsInTime(checkedTimeString9));
                break;
            case 10: // ready
                System.out.println(CONSOLE_NUMBER_GUEST_TOTAL + guestController.countNumberOfGuestsTotal());
                break;
            case 11: // ready
                String checkedTimeString11 = inputDateTimeString();
                System.out.println(CONSOLE_NUMBER_GUEST_IN_HOTEL_NOW + checkedTimeString11 + ": " +
                        roomReservationController.countNumberOfGuestsOnDate(checkedTimeString11));
                break;
            case 12:
                String checkedTimeString12 = inputDateTimeString();
                System.out.println(CONSOLE_READ_ALL_FREE_ROOMS_TIME +
                        roomReservationController.readAllRoomsFreeInTime(checkedTimeString12));
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
                System.out.println(CONSOLE_READ_ALL_SERVICES + SORTED_BY_PRICE +
                        orderController.readAllServicesSortByPrice());
                break;
            case 16:
                System.out.println(CONSOLE_READ_ALL_SERVICES + SORTED_BY_DATE +
                        orderController.readAllServicesSortByDate());
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
                StartMenuMain.getSingletonInstance(navigatorMain, executorMain).runMenu();
            default:
                System.out.println(ERROR_INPUT);
                StartMenuAnalytics.getSingletonInstance(navigator, executor).runMenu();
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
