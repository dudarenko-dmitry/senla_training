package pl.senla.hotel.ui.room;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.controller.ControllerFacility;
import pl.senla.hotel.entity.facilities.CategoryFacility;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.facilities.RoomStatus;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.room.roomlevel.StartMenuRoomLevel;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;

@AppComponent
public class ExecutorRoomDB implements Executor {

    @GetInstance(beanName = "StartMenuRoomLevel")
    private StartMenuRoomLevel startMenuRoomLevel;
    @GetInstance(beanName = "ControllerFacilityDB")
    private ControllerFacility facilityController;

    public ExecutorRoomDB(){}

    @Override
    public void execute(int menuPoint) throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, InstantiationException {
        Scanner sc = new Scanner(System.in);
        switch (menuPoint) {
            case 1 -> System.out.println(CONSOLE_READ_ALL_ROOMS + facilityController.readAll());
            case 2 -> {
                System.out.print(INPUT_ID_ROOM);
                int id = sc.nextInt();
                System.out.println(CONSOLE_READ_ROOM + facilityController.read(id));
            }
            case 3 -> {
                System.out.println("Input new Room's data: ");
                System.out.print("Room number/name --> ");
                String roomNumber = sc.next();
                System.out.print("Price of Room --> ");
                int price = sc.nextInt();
                System.out.print("Capacity of Room --> ");
                int capacity = sc.nextInt();
                String roomLevel = startMenuRoomLevel.runMenu();
                if(roomLevel.isEmpty()){
                    execute(menuPoint);
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
                HotelFacility roomUpdated = facilityController.read(idRoomUpdate);
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
                HotelFacility roomUpdated = facilityController.read(idRoomUpdate);
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
                HotelFacility roomUpdated = facilityController.read(idRoomUpdate);
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
                System.out.println(CONSOLE_DELETE_ROOM + facilityController.delete(idRoomDelete));
            }
            default -> {
                System.out.println(ERROR_INPUT);
                execute(menuPoint);
            }
        }
    }
}
