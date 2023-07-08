package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.main.StartMenuMain;
import pl.senla.hotel.ui.room.roomlevel.StartMenuRoomLevel;
import pl.senla.hotel.controller.*;
import pl.senla.hotel.entity.facilities.CategoryFacility;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.FreeRoom;
import pl.senla.hotel.entity.services.RoomStatus;

import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;
import static pl.senla.hotel.constant.HotelConstant.*;

public class ExecutorRoom implements Executor {

    private final ControllerFacility facilityController;
    private final ControllerRoom roomController;
    private final ControllerRoomReservation roomReservationController;

    public ExecutorRoom() {
        this.facilityController = new ControllerFacilityCollection();
        this.roomController = new ControllerRoomCollection();
        this.roomReservationController = new ControllerRoomReservationCollection();
    }

    @Override
    public void execute(int userSelection) {
        Scanner sc = new Scanner(System.in);
        switch (userSelection) {
            case 1 -> System.out.println(CONSOLE_READ_ALL_ROOMS + roomController.readAll());
            case 2 -> {
                System.out.print("Input ID Room -->");
                int id = sc.nextInt();
                System.out.println(CONSOLE_READ_ROOM + roomController.read(id));
            }
            case 3 -> {
                System.out.println("Input new Room's data: ");
                System.out.print("Room number/name --> ");
                String roomNumber = sc.next();
                System.out.print("Price of Room --> ");
                int price = sc.nextInt();
                System.out.print("Capacity of Room --> ");
                int capacity = sc.nextInt();
                String roomLevel = new StartMenuRoomLevel().runMenu();
                if(roomLevel.equals("")){
                    execute(userSelection);
                }
                Room room = new Room(CategoryFacility.ROOM.getTypeName(), roomNumber, price, capacity,
                        roomLevel, RoomStatus.AVAILABLE.getStatus());
                System.out.println(CONSOLE_CREATE_ROOM + roomController.create(room));
                FreeRoom freeRoom1 = new FreeRoom(room, START_DATE_YEAR, END_DATE_YEAR);
                facilityController.create(room); // CHECK (need for creating price-list)
                roomReservationController.createFreeRoom(freeRoom1);
            }
            case 4 -> {
                System.out.print("Input ID Room to Update -->");
                int idRoomUpdate = sc.nextInt();
                System.out.print("Input new price --> ");
                int newPrice = sc.nextInt();
                Room roomUpdated = roomController.read(idRoomUpdate);
                roomUpdated.setPrice(newPrice);
                facilityController.update(roomUpdated);
                System.out.println(CONSOLE_CHANGE_ROOM + roomController.update(roomUpdated));
            }
            case 5 -> {
                System.out.print("Input ID Room to Delete -->");
                int idRoomDelete = sc.nextInt();
                System.out.println(CONSOLE_DELETE_ROOM + roomController.delete(idRoomDelete));
            }
            case 0 -> new StartMenuMain().runMenu();
            default -> {
                System.out.println(ERROR_INPUT_NAVIGATE);
                new StartMenuMain().runMenu();
            }
        }
    }
}
