package pl.senla.hotel.ui.services;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.controller.ControllerFacility;
import pl.senla.hotel.controller.ControllerRoomReservation;

import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;
import static pl.senla.hotel.constant.HotelFacilityConstant.ERROR_READ_ROOM;

@AppComponent
public class ExecutorCreateHotelService {

    @GetInstance(beanName = "ControllerRoomReservationCollection")
    private ControllerRoomReservation roomReservationController;
    @GetInstance(beanName = "ControllerFacilityCollection")
    private ControllerFacility controllerFacility;

    public ExecutorCreateHotelService() {}

    //Later change return from RoomReservation to HotelService and refactor
    protected boolean createHotelServiceForGuest(int idOrder, int idGuest) throws IllegalAccessException { //use only (1) RoomReservation
        int typeOfService = 1;
        while (typeOfService != 0){
            typeOfService = makeChoice();
            Scanner sc = new Scanner(System.in);
            switch (typeOfService) {
                case 1 -> {
                    System.out.print("Input Id Room --> ");
                    int idRoom = sc.nextInt();
                    if (controllerFacility.read(idRoom) != null) {
                        String startDateString = inputDateString();
                        System.out.print("Input number of days to reserve --> ");
                        int numberOfDays = sc.nextInt();
                        String roomReservationString = idOrder + ";" +
                                idGuest + ";" +
                                idRoom + ";" +
                                startDateString + ";" +
                                numberOfDays;
                        roomReservationController.create(roomReservationString);
                    }
                    System.out.println(ERROR_READ_ROOM);
                    return false;
                }
                case 2 -> {
                    System.out.println("Do not use this type of Service: Restaurant. ");
                }
                case 3 -> {
                    System.out.println("Do not use this type of Service: Transfer");
                }
                case 0 -> {
                    System.out.println(CONSOLE_CREATE_ORDER);
                    return true;
                }
                default -> {
                    System.out.println(ERROR_INPUT);
                    createHotelServiceForGuest(idOrder, idGuest);
                }
            }
        }
        return true;
    }

    private int makeChoice(){
        System.out.print("Input your choice --> ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private String inputDateString() {
        System.out.println("Input start date of Reservation: ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Input year --> ");
        int year = sc.nextInt();
        System.out.print("Input month --> ");
        int month = sc.nextInt();
        System.out.print("Input day --> ");
        int day = sc.nextInt();
        return year + "-" + month + "-" + day;
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
    } // will be used with Restaurant and Transfer.
}
