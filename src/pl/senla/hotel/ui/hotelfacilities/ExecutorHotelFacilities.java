package pl.senla.hotel.ui.hotelfacilities;

import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.StartMenu;
import pl.senla.hotel.ui.main.StartMenuMain;
import pl.senla.hotel.ui.room.StartMenuRoom;

import static pl.senla.hotel.constant.ConsoleConstant.*;

public class ExecutorHotelFacilities implements Executor {

    private final StartMenu menuRoom;
    private StartMenu menuTable;
    private StartMenu menuTransfer;

    public ExecutorHotelFacilities() {
        this.menuRoom = new StartMenuRoom();
//        this.menuTable = new StartMenuTable();
//        this.menuTransfer = new StartMenuTransfer();
    }

    @Override
    public void execute(int userSelection) {
        switch (userSelection) {
            case 1 -> menuRoom.runMenu();
            case 2 -> menuTable.runMenu();
            case 3 -> menuTransfer.runMenu();
            case 0 -> new StartMenuMain().runMenu();
            default -> {System.out.println(ERROR_INPUT_NAVIGATE);
                new StartMenuMain().runMenu();}
        }
    }
}
