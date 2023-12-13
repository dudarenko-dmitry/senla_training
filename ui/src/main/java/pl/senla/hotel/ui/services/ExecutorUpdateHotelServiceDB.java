package pl.senla.hotel.ui.services;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.senla.hotel.controller.ControllerOrder;
import pl.senla.hotel.controller.ControllerRoomReservation;
import pl.senla.hotel.entity.services.HotelService;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;
import static pl.senla.hotel.constant.OrderConstant.ORDER_NOT_EXISTS;

@Component
@NoArgsConstructor
@Slf4j
public class ExecutorUpdateHotelServiceDB {

    @Autowired
    private ControllerOrder orderController;
    @Autowired
    private ControllerRoomReservation roomReservationController;

    protected HotelService updateHotelServiceList(int idOrderUpdate) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        if(orderController.read(idOrderUpdate) != null){
            int typeOfServiceInt = makeChoice();
            Scanner sc = new Scanner(System.in);
            switch (typeOfServiceInt) {
                case 1 -> {
                    log.info(UPDATE_RESERVATION);
                    log.info(CONSOLE_READ_ALL_SERVICES_FOR_ORDER,
                            orderController.readAllServicesForOrder(idOrderUpdate));
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
                    return null;
                }
                case 3 -> {
                    log.info("Update Transfer's Reservation: do not use");
                    return null;
                }
                default -> {
                    updateHotelServiceList(idOrderUpdate);
                    return null;
                }
            }
        } else {
            log.info(ORDER_NOT_EXISTS);
            log.info(ERROR_INPUT);
            return null;
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
