package pl.senla.hotel.ui.room;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

@AppComponent
public class StartMenuRoom implements StartMenu {

    private static StartMenu startMenuRoom;
    private final Navigator navigator;
    @GetInstance(beanName = "ExecutorRoom")
    private final Executor executor;

    private StartMenuRoom(Executor executor) {
        this.navigator = NavigatorRoom.getSingletonInstance();
        this.executor = executor;
    }

    public static StartMenu getSingletonInstance(Executor executor){
        if (startMenuRoom == null) {
            startMenuRoom = new StartMenuRoom(executor);
        }
        return startMenuRoom;
    }

    public void runMenu() throws IllegalAccessException {
        while (true) {
            navigator.buildMenu();
            int userSelection = navigator.makeChoice();
            executor.execute(userSelection);
        }
    }
}
