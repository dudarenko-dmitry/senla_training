package pl.senla.hotel.ui.room.roomlevel;

import pl.senla.hotel.entity.services.RoomLevel;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

public class ExecutorRoomLevel {

    public String execute(int userSelection) {
        switch (userSelection) {
            case 1:
                return RoomLevel.ECONOM.getLevel();
            case 2:
                return RoomLevel.STANDART.getLevel();
            case 3:
                return RoomLevel.LUX.getLevel();
            default:
                System.out.println(ERROR_INPUT);
                execute(userSelection);
                return "";
        }
    }
}
