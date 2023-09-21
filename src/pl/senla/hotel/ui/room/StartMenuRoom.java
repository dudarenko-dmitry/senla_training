package pl.senla.hotel.ui.room;

import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

public class StartMenuRoom implements StartMenu {

    private static StartMenu startMenuRoom;
    private final Navigator navigator;
    private final Executor executor;

    private StartMenuRoom(Configuration appConfiguration) {
        this.navigator = NavigatorRoom.getNavigatorRoom();
        this.executor = ExecutorRoom.getExecutorRoom(appConfiguration);
    }

    public static StartMenu getStartMenuRoom(Configuration appConfiguration){
        if (startMenuRoom == null) {
            startMenuRoom = new StartMenuRoom(appConfiguration);
        }
        return startMenuRoom;
    }

    public void runMenu() {
        while (true) {
            navigator.buildMenu();
            int userSelection = navigator.makeChoice();
            executor.execute(userSelection);
        }
    }
}
