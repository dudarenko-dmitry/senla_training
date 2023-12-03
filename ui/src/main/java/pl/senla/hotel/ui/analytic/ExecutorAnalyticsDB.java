package pl.senla.hotel.ui.analytic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.senla.hotel.controller.ControllerFacility;
import pl.senla.hotel.controller.ControllerGuest;
import pl.senla.hotel.controller.ControllerOrder;
import pl.senla.hotel.controller.ControllerRoomReservation;
import pl.senla.hotel.ui.Executor;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;

@Component
@Qualifier("ExecutorAnalyticsDB")
@Slf4j
public class ExecutorAnalyticsDB implements Executor {

    @Autowired
    private ControllerFacility facilityController;
    @Autowired
    private ControllerRoomReservation roomReservationController;
    @Autowired
    private ControllerGuest guestController;
    @Autowired
    private ControllerOrder orderController;

    public ExecutorAnalyticsDB(){}

    @Override
    public void execute(int menuPoint) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        Scanner sc = new Scanner(System.in);
        switch (menuPoint) {
            case 1 -> log.info(CONSOLE_READ_ALL_ROOMS_SORTED_BY_PRICE,
                    facilityController.readAllRoomsSortByPrice());
            case 2 -> log.info(CONSOLE_READ_ALL_ROOMS_SORTED_BY_CAPACITY,
                    facilityController.readAllRoomsSortByCapacity());
            case 3 -> log.info(CONSOLE_READ_ALL_ROOMS_SORTED_BY_LEVEL,
                    facilityController.readAllRoomsSortByLevel());
            case 4 -> {
                String checkedTimeString4 = inputDateTimeString();
                log.info(CONSOLE_READ_FREE_ROOMS_SORTED_BY_PRICE,
                        roomReservationController.readAllFreeRoomsSortByPrice(checkedTimeString4));
            }
            case 5 -> {
                String checkedTimeString5 = inputDateTimeString();
                log.info(CONSOLE_READ_FREE_ROOMS_SORTED_BY_CAPACITY,
                        roomReservationController.readAllFreeRoomsSortByCapacity(checkedTimeString5));
            }
            case 6 -> {
                String checkedTimeString6 = inputDateTimeString();
                log.info(CONSOLE_READ_ALL_FREE_ROOMS_SORTED_BY_LEVEL,
                        roomReservationController.readAllFreeRoomsSortByLevel(checkedTimeString6));
            }
            case 7 -> log.info(CONSOLE_READ_ALL_ROOM_RESERVATIONS_SORTED_BY_GUEST_NAME,
                            roomReservationController.readAllRoomReservationsSortByGuestName());
            case 8 -> log.info(CONSOLE_READ_ALL_ROOM_RESERVATIONS_SORTED_BY_CHECK_OUT,
                            roomReservationController.readAllRoomReservationsSortByGuestCheckOut());
            case 9 -> {
                String checkedTimeString9 = inputDateTimeString();
                log.info(CONSOLE_NUMBER_OF_FREE_ROOMS, checkedTimeString9,
                        roomReservationController.countFreeRoomsInTime(checkedTimeString9));
            }
            case 10 -> log.info(CONSOLE_NUMBER_GUEST_TOTAL, guestController.countNumberOfGuestsTotal());
            case 11 -> {
                String checkedTimeString11 = inputDateTimeString();
                log.info(CONSOLE_NUMBER_GUEST_IN_HOTEL_NOW, checkedTimeString11,
                        roomReservationController.countNumberOfGuestsOnDate(checkedTimeString11));
            }
            case 12 -> {
                String checkedTimeString12 = inputDateTimeString();
                log.info(CONSOLE_READ_ALL_FREE_ROOMS_TIME,
                        roomReservationController.readAllRoomsFreeInTime(checkedTimeString12));
            }
            case 13 -> {
                System.out.print(INPUT_ID_GUEST);
                int idGuest = sc.nextInt();
                log.info(CONSOLE_GUEST_PAYMENT_FOR_ROOM,
                        roomReservationController.countGuestPaymentForRoom(idGuest));
            }
            case 14 -> {
                System.out.print(INPUT_ID_ROOM);
                int idRoom = sc.nextInt();
                log.info(CONSOLE_3_GUESTS_AND_DATES, roomReservationController.read3LastGuestAndDatesForRoom(idRoom));
            }
            case 15 -> log.info(CONSOLE_READ_ALL_SERVICES_SORTED_BY_PRICE,
                    roomReservationController.readAllServicesSortByPrice());
            case 16 -> log.info(CONSOLE_READ_ALL_SERVICES_SORTED_BY_DATE,
                    roomReservationController.readAllServicesSortByDate());
            case 17 -> log.info(CONSOLE_READ_ALL_FACILITIES_SORTED_BY_CATEGORY,
                    facilityController.readPriceListForServicesSortByCategory());
            case 18 -> log.info(CONSOLE_READ_ALL_FACILITIES_SORTED_BY_PRICE,
                    facilityController.readPriceListForServicesSortByPrice());
            case 19 -> {
                log.info(INPUT_ID_ROOM);
                int idRoomRead = sc.nextInt();
                facilityController.read(idRoomRead);
            }
            default -> {
                System.out.println(ERROR_INPUT);
                execute(menuPoint);
            }
        }
    }

    private String inputDateTimeString() {
        System.out.println(SELECT_START_TIME);
        Scanner sc = new Scanner(System.in);
        System.out.print(INPUT_YEAR);
        int year = sc.nextInt();
        System.out.print(INPUT_MONTH);
        int month = sc.nextInt();
        System.out.print(INPUT_DAY);
        int day = sc.nextInt();
        System.out.print(INPUT_HOUR);
        int hour = sc.nextInt();
        System.out.print(INPUT_MINUTE);
        int minute = sc.nextInt();
        return year + "-" + month + "-" + day + "-" + hour + "-" + minute;
    }
}
