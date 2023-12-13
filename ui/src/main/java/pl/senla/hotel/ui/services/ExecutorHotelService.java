package pl.senla.hotel.ui.services;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.senla.hotel.controller.ControllerOrder;
import pl.senla.hotel.controller.ControllerRoomReservation;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.StartMenu;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;

@Component
@NoArgsConstructor
@Slf4j
public class ExecutorHotelService implements Executor {

    @Autowired
    private ControllerOrder orderController;
    @Autowired
    private ControllerRoomReservation roomReservationController;
    @Autowired
    private ExecutorCreateHotelServiceDB executorCreateHotelService;
    @Autowired
    @Qualifier("startMenuOrderDB")
    private StartMenu startMenuOrder;

    @Override
    public void execute(int menuPoint) throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, InstantiationException {
        Scanner sc = new Scanner(System.in);
        switch (menuPoint) {
            case 1 -> log.info(CONSOLE_READ_ALL_SERVICES, roomReservationController.readAll());
            case 2 -> {
                log.info(INPUT_ID_RESERVATION);
                int id = sc.nextInt();
                log.info(CONSOLE_READ_SERVICE, roomReservationController.read(id));
            }
            case 3 -> {
                log.info("!!! USE ONLY FOR EXISTING ORDER !!!");
                log.info(INPUT_ID_ORDER);
                int idOrder = sc.nextInt();
                if (orderController.read(idOrder) != null) {
                    log.info(INPUT_ID_GUEST);
                    int idGuest = sc.nextInt();
                    log.info(CONSOLE_CREATE_ORDER, roomReservationController.create(String.valueOf(idGuest)));
                    executorCreateHotelService.createHotelServiceForGuest(idOrder, idGuest, 1);
                    log.info(ADD_NEW_SERVICE_FOR_ORDER);
                } else {
                    log.info("You should create new Order to start.");
                    startMenuOrder.runMenu(); // check
                }
            }
            case 4 -> {
                log.info(INPUT_ID_RESERVATION);
                int idOrderUpdate = sc.nextInt();
//                log.info(CONSOLE_CHANGE_ROOM_RESERVATION, startUpdateHotelServiceList.runMenu(idOrderUpdate));
            }
            case 5 -> {
                log.info(INPUT_ID_RESERVATION);
                int idServiceDelete = sc.nextInt();
                roomReservationController.delete(idServiceDelete);
                log.info(CONSOLE_DELETE_SERVICE);
            }
            default -> {
                System.out.println(ERROR_INPUT);
                execute(menuPoint);
            }
        }
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
