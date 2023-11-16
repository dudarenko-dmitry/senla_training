package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.controller.*;
import pl.senla.hotel.ui.Executor;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;

@AppComponent
public class ExecutorAnalyticsDB implements Executor {

    @GetInstance(beanName = "ControllerFacilityDB")
    private ControllerFacility facilityController;
    @GetInstance(beanName = "ControllerRoomReservationDB")
    private ControllerRoomReservation roomReservationController;
    @GetInstance(beanName = "ControllerGuestDB")
    private ControllerGuest guestController;
    @GetInstance(beanName = "ControllerOrderDB")
    private ControllerOrder orderController;

    public ExecutorAnalyticsDB(){}

    @Override
    public void execute(int menuPoint) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        Scanner sc = new Scanner(System.in);
        switch (menuPoint) {
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
                        roomReservationController.readAllServicesSortByPrice());
                break;
            case 16:
                System.out.println(CONSOLE_READ_ALL_SERVICES + SORTED_BY_DATE +
                        roomReservationController.readAllServicesSortByDate());
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
                facilityController.read(idRoom);
                break;
            default:
                System.out.println(ERROR_INPUT);
                execute(menuPoint);
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
