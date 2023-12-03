package pl.senla.hotel.ui.room;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.senla.hotel.controller.ControllerFacility;
import pl.senla.hotel.entity.facilities.CategoryFacility;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.facilities.RoomStatus;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.room.roomlevel.StartMenuRoomLevel;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;

@Component
@Qualifier("ExecutorRoomDB")
@NoArgsConstructor
@Slf4j
public class ExecutorRoomDB implements Executor {

    @Autowired
    private StartMenuRoomLevel startMenuRoomLevel;
    @Autowired
    private ControllerFacility facilityController;

    @Override
    public void execute(int menuPoint) throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, InstantiationException {
        Scanner sc = new Scanner(System.in);
        switch (menuPoint) {
            case 1 -> log.info(CONSOLE_READ_ALL_ROOMS, facilityController.readAll());
            case 2 -> {
                log.info(INPUT_ID_ROOM);
                int id = sc.nextInt();
                log.info(CONSOLE_READ_ROOM, facilityController.read(id));
            }
            case 3 -> {
                log.info(INPUT_ROOM_DATA);
                log.info(INPUT_ROOM_NUMBER);
                String roomNumber = sc.next();
                log.info(INPUT_PRICE);
                int price = sc.nextInt();
                log.info(INPUT_CAPACITY);
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
                log.info(CONSOLE_CREATE_ROOM,
                        facilityController.create(stringRoom));
            }
            case 4 -> {
                log.info(INPUT_ID_ROOM_UPDATE);
                int idRoomUpdate = sc.nextInt();
                log.info(INPUT_PRICE);
                int newPrice = sc.nextInt();
                Room roomUpdated = facilityController.read(idRoomUpdate);
                if(roomUpdated != null){
                    log.info(CONSOLE_CHANGE_ROOM, facilityController.update(idRoomUpdate, String.valueOf(newPrice)));
                } else {
                    log.info(ERROR_INPUT);
                }
            }
            case 5 -> {
                log.info(INPUT_ID_ROOM_UPDATE);
                int idRoomUpdate = sc.nextInt();
                Room roomUpdated = facilityController.read(idRoomUpdate);
                if(roomUpdated != null){
                    log.info(CONSOLE_CHANGE_ROOM, facilityController.updateRoomStatusAvailable(idRoomUpdate));
                } else {
                    log.info(ERROR_INPUT);
                }
            }
            case 6 -> {
                log.info(INPUT_ID_ROOM_UPDATE);
                int idRoomUpdate = sc.nextInt();
                Room roomUpdated = facilityController.read(idRoomUpdate);
                if(roomUpdated != null){
                    log.info(CONSOLE_CHANGE_ROOM, facilityController.updateRoomStatusRepaired(idRoomUpdate));
                } else {
                    log.info(ERROR_INPUT);
                }
            }
            case 7 -> {
                log.info(INPUT_ID_ROOM);
                int idRoomDelete = sc.nextInt();
                facilityController.delete(idRoomDelete);
                log.info(CONSOLE_DELETE_ROOM);
            }
            default -> {
                log.info(ERROR_INPUT);
                execute(menuPoint);
            }
        }
    }
}