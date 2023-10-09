package pl.senla.hotel.ui.room.roomlevel;

import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.entity.facilities.RoomLevel;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.room.StartMenuRoom;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

public class ExecutorRoomLevel {

    @GetInstance(beanName = "ExecutorRoom")
    private final Executor executor;

    public ExecutorRoomLevel(Executor executor) {
        this.executor = executor;
    }

    public String execute(int userSelection) throws IllegalAccessException {
        switch (userSelection) {
            case 1 -> {
                return String.valueOf(RoomLevel.ECONOM);
            }
            case 2 -> {
                return String.valueOf(RoomLevel.STANDART);
            }
            case 3 -> {
                return String.valueOf(RoomLevel.LUX);
            }
            default -> {
                System.out.println(ERROR_INPUT);
                StartMenuRoom.getSingletonInstance(executor).runMenu();
                return "";
            }
        }
    }
}
