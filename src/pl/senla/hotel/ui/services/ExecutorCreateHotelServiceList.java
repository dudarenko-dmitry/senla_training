package pl.senla.hotel.ui.services;

import pl.senla.hotel.controller.ControllerRoom;
import pl.senla.hotel.controller.ControllerRoomCollection;
import pl.senla.hotel.controller.ControllerRoomReservation;
import pl.senla.hotel.controller.ControllerRoomReservationCollection;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.RoomReservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.CONSOLE_CREATE_ROOM_RESERVATION;
import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT_NAVIGATE;

public class ExecutorCreateHotelServiceList {

    private final ControllerRoom roomController;
    private final ControllerRoomReservation roomReservationController;

    public ExecutorCreateHotelServiceList() {
        this.roomController = new ControllerRoomCollection();
        this.roomReservationController = new ControllerRoomReservationCollection();
    }

    //Later change return from RoomReservation to HotelService and refactor
    protected List<HotelService> createHotelServiceList(List<HotelService> guestServices, int guest, int index) { //use only (1) RoomReservation
        Scanner sc = new Scanner(System.in);
        switch (index) {
            case 1:
                System.out.print("Input Id Room --> ");
                int idRoom = sc.nextInt();
                Room room = roomController.read(idRoom);
                LocalDate startDate = inputDate();
                System.out.print("Input number of days to reserve --> ");
                int numberOfDays = sc.nextInt();
                RoomReservation roomReservationNew = new RoomReservation(guest, room, startDate, numberOfDays);
                if(roomReservationNew.getIdRoomReservation() == -1){
                    System.out.println("RoomReservation was not created. Check Room or Guest");
                    break;
                }
                System.out.println(CONSOLE_CREATE_ROOM_RESERVATION +
                        roomReservationController.create(roomReservationNew));
                guestServices.add(roomReservationNew);
                break;
            case 2: // do not use
                System.out.println("Do not use this type of Service: Restaurant. ");
                //LocalDateTime startDateTime = inputDateTime();
                //logic
                //guestServices.add(new Restaurant());
                break;
            case 3: // do not use
                System.out.println("Do not use this type of Service: Transfer");
                //startDateTime = inputDateTime();
                //logic
                //guestServices.add(new Transfer());
                break;
            case 0:
                return guestServices;
            default:
                System.out.println(ERROR_INPUT_NAVIGATE);
                new StartCreateHotelServiceList().runMenu(guest);
        }
        return guestServices; // return List<HotelServices>
    }

    private LocalDate inputDate() {
        System.out.println("Select start date of Reservation. ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Input year --> ");
        int year = sc.nextInt();
        System.out.print("Input month --> ");
        int month = sc.nextInt();
        System.out.print("Input day --> ");
        int day = sc.nextInt();
        return LocalDate.of(year, month, day);
    }

    private LocalDateTime inputDateTime() {
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
        return LocalDateTime.of(year, month, day, hour, minute);
    }
}
