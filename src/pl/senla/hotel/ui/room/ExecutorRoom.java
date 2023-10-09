package pl.senla.hotel.ui.room;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.main.StartMenuMain;
import pl.senla.hotel.ui.room.roomlevel.ExecutorRoomLevel;
import pl.senla.hotel.ui.room.roomlevel.StartMenuRoomLevel;
import pl.senla.hotel.controller.*;
import pl.senla.hotel.entity.facilities.CategoryFacility;
import pl.senla.hotel.entity.facilities.RoomStatus;

import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;

@AppComponent
public class ExecutorRoom implements Executor {

    private static Executor executorRoom;
    @GetInstance(beanName = "ControllerFacilityCollection")
    private final ControllerFacility facilityController;
    @GetInstance(beanName = "ControllerRoomCollection")
    private final ControllerRoom roomController;
    @GetInstance(beanName = "ExecutorRoomLevel")
    private final ExecutorRoomLevel executor;
    @GetInstance(beanName = "NavigatorMainMenu")
    private final Navigator navigatorMain;
    @GetInstance(beanName = "ExecutorMain")
    private final Executor executorMain;

    private ExecutorRoom(ControllerFacility facilityController, ControllerRoom roomController,
                         ExecutorRoomLevel executor, Navigator navigatorMain, Executor executorMain) {
        this.facilityController = facilityController;
        this.roomController = roomController;
        this.executor = executor;
        this.navigatorMain = navigatorMain;
        this.executorMain = executorMain;
    }

    public static Executor getSingletonInstance(ControllerFacility facilityController, ControllerRoom roomController,
                                                ExecutorRoomLevel executor, Navigator navigatorMain,
                                                Executor executorMain){
        if (executorRoom == null) {
            executorRoom = new ExecutorRoom(facilityController, roomController, executor, navigatorMain, executorMain);
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
                String roomLevel = new StartMenuRoomLevel(executor).runMenu();
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
            case 0 -> StartMenuMain.getSingletonInstance(navigatorMain, executorMain).runMenu();
            default -> {
                System.out.println(ERROR_INPUT);
                StartMenuMain.getSingletonInstance(navigatorMain, executorMain).runMenu();
            }
        }
    }
}
