package pl.senla.hotel.UI.hotelfacilities;

import pl.senla.hotel.UI.Executor;
import pl.senla.hotel.UI.Navigator;
import pl.senla.hotel.UI.StartMenu;
import pl.senla.hotel.UI.room.StartMenuRoom;
import pl.senla.hotel.controller.ControllerFacility;
import pl.senla.hotel.controller.ControllerFacilityCollection;

import static pl.senla.hotel.constant.ConsoleConstant.*;

public class ExecutorHotelFacilities implements Executor {

    private Navigator menuHotelFacilities;
    private ControllerFacility facilityController;
    private StartMenu menuRoom;
    private StartMenu menuTable;
    private StartMenu menuTransfer;
    private StartMenu menuMain;

    public ExecutorHotelFacilities() {
        this.menuHotelFacilities = new NavigatorHotelFacilities();
        this.facilityController = new ControllerFacilityCollection();
        this.menuRoom = new StartMenuRoom();
//        this.menuTable = new StartMenuTable();
//        this.menuTransfer = new StartMenuTransfer();
//        this.menuMain = new StartMenuMain();
    }

    @Override
    public void execute(int userSelection) {
        switch (userSelection) {
            case 1 -> menuRoom.runMenu();
            case 2 -> menuTable.runMenu();
            case 3 -> menuTransfer.runMenu();
            case 0 -> menuMain.runMenu();
            default -> System.out.println(ERROR_INPUT_NAVIGATE); // add action
        }
    }
}
