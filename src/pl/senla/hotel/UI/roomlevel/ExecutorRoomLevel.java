package pl.senla.hotel.UI.roomlevel;

import pl.senla.hotel.entity.services.RoomLevel;

import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT_NAVIGATE;

public class ExecutorRoomLevel {

    public String execute(int userSelection) {
        Scanner sc = new Scanner(System.in);
        int level = sc.nextInt();
        switch (level) {
            case 1:
                return RoomLevel.ECONOM.getLevel();
            case 2:
                return RoomLevel.STANDART.getLevel();
            case 3:
                return RoomLevel.LUX.getLevel();
            default:
                System.out.println(ERROR_INPUT_NAVIGATE);
//                startMainMenu();
                return null;
        }
    }
}
