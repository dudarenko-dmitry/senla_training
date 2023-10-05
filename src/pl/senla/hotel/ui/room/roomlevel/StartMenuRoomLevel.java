package pl.senla.hotel.ui.room.roomlevel;

import pl.senla.hotel.ui.Navigator;

public class StartMenuRoomLevel {

    private final Navigator navigator;
    private final ExecutorRoomLevel executor;

    public StartMenuRoomLevel() {
        this.navigator = new NavigatorRoomLevel();
        this.executor = new ExecutorRoomLevel();
    }

    public String runMenu() throws IllegalAccessException {
        navigator.buildMenu();
        int userSelection = navigator.makeChoice();
        return executor.execute(userSelection);
    }
}
