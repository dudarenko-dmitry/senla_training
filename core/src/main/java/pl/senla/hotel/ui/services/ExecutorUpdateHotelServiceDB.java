package pl.senla.hotel.ui.services;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.controller.ControllerOrder;
import pl.senla.hotel.controller.ControllerRoomReservation;
import pl.senla.hotel.entity.services.TypeOfService;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;
import static pl.senla.hotel.constant.OrderConstant.ORDER_NOT_EXISTS;

@AppComponent
@Slf4j
public class ExecutorUpdateHotelServiceDB {

    @GetInstance(beanName = "ControllerOrderDB")
    private ControllerOrder orderController;
    @GetInstance(beanName = "ControllerRoomReservationDB")
    private ControllerRoomReservation roomReservationController;

    public ExecutorUpdateHotelServiceDB() {}

    protected boolean updateHotelServiceList(int idOrderUpdate) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        if(orderController.read(idOrderUpdate) != null){
            int typeOfServiceInt = makeChoice();
            Scanner sc = new Scanner(System.in);
            switch (typeOfServiceInt) {
                case 1 -> {
                    log.info(UPDATE_RESERVATION);
                    log.info(CONSOLE_READ_ALL_SERVICES, orderController.read(idOrderUpdate)
                            .getIdServices()
                            .stream()
                            .filter(s -> {
                                try {
                                    return roomReservationController.read(s).getTypeOfService()
                                            .equals(TypeOfService.ROOM_RESERVATION);
                                } catch (InvocationTargetException | NoSuchMethodException | InstantiationException |
                                         IllegalAccessException e) {
                                    throw new RuntimeException(e);
                                }
                            })
                            .toList());
                    log.info(INPUT_ID_RESERVATION_UPDATE);
                    int idRoomReservation = sc.nextInt();
                    log.info(SELECT_START_TIME);
                    String checkInDateString = inputDateString();
                    log.info(INPUT_NUMBER_OF_DAYS);
                    int numberOfDays = sc.nextInt();
                    String roomReservationUpdateString = checkInDateString + ";" +
                            numberOfDays;
                    return roomReservationController.update(idRoomReservation, roomReservationUpdateString);
                }
                case 2 -> {
                    log.info("Update Restaurant's Reservation: do not use");
                    return true;
                }
                case 3 -> {
                    log.info("Update Transfer's Reservation: do not use");
                    return true;
                }
                default -> {
                    updateHotelServiceList(idOrderUpdate);
                    return false;
                }
            }
        } else {
            log.info(ORDER_NOT_EXISTS);
            log.info(ERROR_INPUT);
            return false;
        }
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
}
