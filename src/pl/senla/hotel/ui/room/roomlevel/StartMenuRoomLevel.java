package pl.senla.hotel.ui.room.roomlevel;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ui.Choice;
import pl.senla.hotel.ui.Navigator;

@AppComponent
public class StartMenuRoomLevel {
    @GetInstance(beanName = "NavigatorRoomLevel")
    private Navigator navigator;
    @GetInstance(beanName = "ExecutorRoomLevel")
    private ExecutorRoomLevel executor;

    public StartMenuRoomLevel() {}

    public String runMenu() throws IllegalAccessException {
        navigator.buildMenu();
        return executor.execute();
    }
}
