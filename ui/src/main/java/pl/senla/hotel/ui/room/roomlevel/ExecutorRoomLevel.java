package pl.senla.hotel.ui.room.roomlevel;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.senla.hotel.entity.facilities.RoomLevel;

import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;
import static pl.senla.hotel.constant.ConsoleConstant.INPUT_MENU_POINT;

@Component
@NoArgsConstructor
@Slf4j
public class ExecutorRoomLevel {

    public String execute() {
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
                log.info(ERROR_INPUT);
                execute();
                return "";
            }
        }
    }

    private int makeChoice(){
        log.info(INPUT_MENU_POINT);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

}
