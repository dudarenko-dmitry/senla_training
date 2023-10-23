package pl.senla.hotel.ui.services;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.controller.ControllerOrder;
import pl.senla.hotel.controller.ControllerRoomReservation;

import pl.senla.hotel.entity.services.TypeOfService;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.order.StartMenuOrder;

import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;
import static pl.senla.hotel.constant.OrderConstant.ERROR_READ_ORDER;

@AppComponent
public class ExecutorUpdateHotelServiceList {

    @GetInstance(beanName = "StartMenuOrder")
    private StartMenuOrder startMenuOrder;
    @GetInstance(beanName = "ControllerOrderCollection")
    private ControllerOrder orderController;
    @GetInstance(beanName = "ControllerRoomReservationCollection")
    private ControllerRoomReservation roomReservationController;
    // add all other Controllers for different type of Hotel's Services

    public ExecutorUpdateHotelServiceList() {}

    protected boolean updateHotelServiceList(int idOrderUpdate, int typeOfServiceInt) throws IllegalAccessException {
        Scanner sc = new Scanner(System.in);
        switch (typeOfServiceInt) {
            case 1:
                System.out.println("Update Room's Reservation: ");
                if(orderController.read(idOrderUpdate) != null){
                    System.out.println(CONSOLE_READ_ALL_SERVICES + orderController.read(idOrderUpdate)
                            .getServices()
                            .stream()
                            .filter(s -> roomReservationController.read(s).getTypeOfService()
                                    .equals(TypeOfService.ROOM_RESERVATION))
                            .toList());

                    System.out.print("Input RoomReservation's ID to Update --> ");
                    int idRoomReservation = sc.nextInt();
                    System.out.println("Input new Date. ");
                    String checkInDateString = inputDateString();
                    System.out.print("Input number of days to reserve --> ");
                    int numberOfDays = sc.nextInt();
                    String roomReservationUpdateString = checkInDateString + ";" +
                            numberOfDays;
                    return roomReservationController.update(idRoomReservation, roomReservationUpdateString);
                } else {
                    System.out.println(ERROR_READ_ORDER);
                    System.out.println(ERROR_INPUT);
                    startMenuOrder.runMenu();
                }

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
