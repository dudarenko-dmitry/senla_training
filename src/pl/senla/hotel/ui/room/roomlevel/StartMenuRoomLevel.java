package pl.senla.hotel.ui.room.roomlevel;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
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
