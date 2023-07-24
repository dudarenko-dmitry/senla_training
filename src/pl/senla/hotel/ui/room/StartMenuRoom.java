package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;
import pl.senla.hotel.ui.guest.StartMenuGuest;

public class StartMenuRoom implements StartMenu {

    private static StartMenu startMenuRoom;
    private final Navigator navigator;
    private final Executor executor;

    private StartMenuRoom() {
        this.navigator = NavigatorRoom.getNavigatorRoom();
        this.executor = ExecutorRoom.getExecutorRoom();
    }

    public static StartMenu getStartMenuRoom(){
        if (startMenuRoom == null) {
            startMenuRoom = new StartMenuRoom();
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
