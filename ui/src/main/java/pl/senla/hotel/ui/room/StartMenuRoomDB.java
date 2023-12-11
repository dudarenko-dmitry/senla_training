package pl.senla.hotel.ui.room;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.senla.hotel.ui.Choice;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

import java.lang.reflect.InvocationTargetException;

@Component
@Qualifier("StartMenuRoomDB")
@NoArgsConstructor
public class StartMenuRoomDB implements StartMenu {

    @Autowired
    @Qualifier("NavigatorRoom")
    private Navigator navigator;
    @Autowired
    private Choice userChoice;
    @Autowired
    @Qualifier("ExecutorRoomDB")
    private Executor executor;

    public void runMenu() throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, InstantiationException {
        int menuPoint = 1;
        while (menuPoint != 0) {
            navigator.buildMenu();
            menuPoint = userChoice.makeChoice();
            if (menuPoint != 0) {
                executor.execute(menuPoint);
            }
        }
    }
}
