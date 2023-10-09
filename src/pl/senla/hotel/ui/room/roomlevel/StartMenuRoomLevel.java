package pl.senla.hotel.ui.room.roomlevel;

import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ui.Navigator;

public class StartMenuRoomLevel {

    private final Navigator navigator;
    @GetInstance(beanName = "ExecutorRoomLevel")
    private final ExecutorRoomLevel executor;

    public StartMenuRoomLevel(ExecutorRoomLevel executor) {
        this.navigator = new NavigatorRoomLevel();
        this.executor = executor;
    }

    public String runMenu() throws IllegalAccessException {
        navigator.buildMenu();
        int userSelection = navigator.makeChoice();
        return executor.execute(userSelection);
    }
}
