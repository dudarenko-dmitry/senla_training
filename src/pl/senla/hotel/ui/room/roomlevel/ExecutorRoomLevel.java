package pl.senla.hotel.ui.room.roomlevel;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.entity.facilities.RoomLevel;

import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

@AppComponent
public class ExecutorRoomLevel {

    public ExecutorRoomLevel() {}

    public String execute() throws IllegalAccessException {
        int userSelection = makeChoice();
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
                execute();
                return "";
            }
        }
    }

    private int makeChoice(){
        System.out.print("Input your choice --> ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

}
