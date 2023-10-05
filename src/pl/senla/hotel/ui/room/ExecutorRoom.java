package pl.senla.hotel.ui.room;

import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.main.StartMenuMain;
import pl.senla.hotel.ui.room.roomlevel.StartMenuRoomLevel;
import pl.senla.hotel.controller.*;
import pl.senla.hotel.entity.facilities.CategoryFacility;
import pl.senla.hotel.entity.facilities.RoomStatus;

import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;

public class ExecutorRoom implements Executor {

    private static Executor executorRoom;
    private final ControllerFacility facilityController;
    private final ControllerRoom roomController;

    private ExecutorRoom() {
        this.facilityController = ControllerFacilityCollection.getControllerFacility();
        this.roomController = ControllerRoomCollection.getControllerRoom();
    }

    public static Executor getExecutorRoom(){
        if (executorRoom == null) {
            executorRoom = new ExecutorRoom();
        }
        return executorRoom;
    }

    @Override
    public void execute(int userSelection) throws IllegalAccessException {
        Scanner sc = new Scanner(System.in);
        switch (userSelection) {
            case 1 -> System.out.println(CONSOLE_READ_ALL_ROOMS + roomController.readAll());
            case 2 -> {
                System.out.print(INPUT_ID_ROOM);
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
                if(roomLevel.isEmpty()){
                    execute(userSelection);
                }
                String stringRoom = CategoryFacility.ROOM + ";" +
                        roomNumber + ";" +
                        price + ";" +
                        capacity + ";" +
                        roomLevel + ";" +
                        RoomStatus.AVAILABLE;
                System.out.println(CONSOLE_CREATE_ROOM +
                        facilityController.create(stringRoom));
            }
            case 4 -> {
                System.out.print(INPUT_ID_ROOM_UPDATE);
                int idRoomUpdate = sc.nextInt();
                System.out.print("Input new price --> ");
                int newPrice = sc.nextInt();
                HotelFacility roomUpdated = roomController.read(idRoomUpdate);
                if(roomUpdated != null){
                    System.out.println(CONSOLE_CHANGE_ROOM +
                            facilityController.update(idRoomUpdate, String.valueOf(newPrice)));
                } else {
                    System.out.println(ERROR_INPUT);
                }
            }
            case 5 -> {
                System.out.print(INPUT_ID_ROOM_UPDATE);
                int idRoomUpdate = sc.nextInt();
                HotelFacility roomUpdated = roomController.read(idRoomUpdate);
                if(roomUpdated != null){
                    System.out.println(CONSOLE_CHANGE_ROOM +
                            facilityController.updateRoomStatusAvailable(idRoomUpdate));
                } else {
                    System.out.println(ERROR_INPUT);
                }
            }
            case 6 -> {
                System.out.print(INPUT_ID_ROOM_UPDATE);
                int idRoomUpdate = sc.nextInt();
                HotelFacility roomUpdated = roomController.read(idRoomUpdate);
                if(roomUpdated != null){
                    System.out.println(CONSOLE_CHANGE_ROOM +
                            facilityController.updateRoomStatusRepaired(idRoomUpdate));
                } else {
                    System.out.println(ERROR_INPUT);
                }
            }
            case 7 -> {
                System.out.print(INPUT_ID_ROOM_DELETE);
                int idRoomDelete = sc.nextInt();
                System.out.println(CONSOLE_DELETE_ROOM + roomController.delete(idRoomDelete));
            }
            case 0 -> StartMenuMain.getStartMenu().runMenu();
            default -> {
                System.out.println(ERROR_INPUT);
                StartMenuMain.getStartMenu().runMenu();
            }
        }
    }
}
