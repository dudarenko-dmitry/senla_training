package pl.senla.hotel.UI.roomlevel;

import pl.senla.hotel.UI.Navigator;

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
