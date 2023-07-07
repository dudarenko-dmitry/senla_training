package pl.senla.hotel.ui.roomlevel;

import pl.senla.hotel.ui.Navigator;

public class StartMenuRoomLevel {

    private final Navigator navigator;
    private final ExecutorRoomLevel executor;

    public StartMenuRoomLevel() {
        this.navigator = new NavigatorRoomLevel();
        this.executor = new ExecutorRoomLevel();
    }

    public String runMenu() {
        navigator.buildMenu();
        int userSelection = navigator.makeChoice();
        return executor.execute(userSelection);
    }
}
