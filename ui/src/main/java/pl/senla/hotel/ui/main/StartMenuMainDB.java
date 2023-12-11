package pl.senla.hotel.ui.main;

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
@NoArgsConstructor
public class StartMenuMainDB implements StartMenu {

    @Autowired
    @Qualifier("navigatorMainMenu")
    private Navigator navigator;
    @Autowired
    private Choice userChoice;
    @Autowired
    @Qualifier("ExecutorMainDB")
    private Executor executor;

    @Override
    public void runMenu() throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, InstantiationException {
        while (true) {
            navigator.buildMenu();
            int menuPoint = userChoice.makeChoice();
            executor.execute(menuPoint);
        }
    }
}
