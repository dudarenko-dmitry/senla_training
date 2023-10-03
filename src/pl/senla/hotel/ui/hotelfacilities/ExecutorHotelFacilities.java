package pl.senla.hotel.ui.hotelfacilities;

import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.StartMenu;
import pl.senla.hotel.ui.main.StartMenuMain;
import pl.senla.hotel.ui.room.StartMenuRoom;

import static pl.senla.hotel.constant.ConsoleConstant.*;

public class ExecutorHotelFacilities implements Executor {

    private static Executor executor;
    private final StartMenu menuRoom;
    private StartMenu menuTable;
    private StartMenu menuTransfer;
    private final Configuration configuration;

    private ExecutorHotelFacilities(Configuration appConfiguration) {
        this.configuration = appConfiguration;
        this.menuRoom = StartMenuRoom.getStartMenuRoom(configuration);
//        this.menuTable = new StartMenuTable();
//        this.menuTransfer = new StartMenuTransfer();
    }

    public static Executor getExecutorHotelFacilities(Configuration appConfiguration){
        if (executor == null) {
            executor = new ExecutorHotelFacilities(appConfiguration);
        }
        return executor;
    }

    @Override
    public void execute(int userSelection) {
        switch (userSelection) {
            case 1 -> menuRoom.runMenu();
            case 2 -> menuTable.runMenu();
            case 3 -> menuTransfer.runMenu();
            case 0 -> StartMenuMain.getStartMenu(configuration).runMenu();
            default -> {System.out.println(ERROR_INPUT);
                StartMenuMain.getStartMenu(configuration).runMenu();}
        }
    }
}
