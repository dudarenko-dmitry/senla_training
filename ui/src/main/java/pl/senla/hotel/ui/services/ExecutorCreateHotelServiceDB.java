package pl.senla.hotel.ui.services;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.senla.hotel.controller.ControllerFacility;
import pl.senla.hotel.controller.ControllerRoomReservation;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;
import static pl.senla.hotel.constant.HotelFacilityConstant.ROOM_NOT_EXISTS;

@Component
@NoArgsConstructor
@Slf4j
public class ExecutorCreateHotelServiceDB {

    @Autowired
    private ControllerRoomReservation roomReservationController;
    @Autowired
    private ControllerFacility controllerFacility;

    //Later change return from RoomReservation to HotelService and refactor
    protected boolean createHotelServiceForGuest(int idOrder, int idGuest, int typeOfService)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException,
            InstantiationException { //use only (1) RoomReservation
        int typeOfService2 = makeChoice();
        Scanner sc = new Scanner(System.in);
        switch (typeOfService) {
            case 1 -> {
                log.info(INPUT_ID_ROOM);
                int idRoom = sc.nextInt();
                if (controllerFacility.read(idRoom) != null) {
                    String startDateString = inputDateString();
                    log.info(INPUT_NUMBER_OF_DAYS);
                    int numberOfDays = sc.nextInt();
                    String roomReservationString = idOrder + ";" +
                            idGuest + ";" +
                            idRoom + ";" +
                            startDateString + ";" +
                            numberOfDays;
                    roomReservationController.create(roomReservationString);
                    return true;
                }
                System.out.println(ROOM_NOT_EXISTS);
            }
            case 2 -> System.out.println("Do not use this type of Service: Restaurant. ");
            case 3 -> System.out.println("Do not use this type of Service: Transfer");
            default -> {
                System.out.println(ERROR_INPUT);
                createHotelServiceForGuest(idOrder, idGuest, typeOfService2);
            }
        }
        return false;
    }

    private int makeChoice(){
        log.info(INPUT_MENU_POINT);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private String inputDateString() {
        log.info(SELECT_START_TIME);
        Scanner sc = new Scanner(System.in);
        log.info(INPUT_YEAR);
        int year = sc.nextInt();
        log.info(INPUT_MONTH);
        int month = sc.nextInt();
        log.info(INPUT_DAY);
        int day = sc.nextInt();
        return year + "-" + month + "-" + day;
    }

    private String inputDateTimeString() {
        log.info(SELECT_START_TIME);
        Scanner sc = new Scanner(System.in);
        log.info(INPUT_YEAR);
        int year = sc.nextInt();
        log.info(INPUT_MONTH);
        int month = sc.nextInt();
        log.info(INPUT_DAY);
        int day = sc.nextInt();
        log.info(INPUT_HOUR);
        int hour = sc.nextInt();
        log.info(INPUT_MINUTE);
        int minute = sc.nextInt();
        return year + "-" + month + "-" + day + "-" + hour + "-" + minute;
    } // will be used with Restaurant and Transfer.
}
