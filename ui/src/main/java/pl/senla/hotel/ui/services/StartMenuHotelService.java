package pl.senla.hotel.ui.services;

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
public class StartMenuHotelService implements StartMenu {

    @Autowired
    @Qualifier("navigatorHotelServiceNew")
    private Navigator navigator;
    @Autowired
    private Choice userChoice;
    @Autowired
    @Qualifier("executorHotelService")
    private Executor executor;

    @Override
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
